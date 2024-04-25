package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class H2Service {

    public void select() {
        Connection connection = null;
        final String jdbcURL = "jdbc:h2://h2:9092/mem:test";
        try {
            connection = DriverManager.getConnection(jdbcURL, "sa", "");
            // データを取得
            String selectSQL = "SELECT * FROM users";
            try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        System.out.println("ID: " + id + ", Name: " + name);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void operation() {
        Connection connection = null;
        final String jdbcURL = "jdbc:h2://h2:9092/mem:test";
        try {
            connection = DriverManager.getConnection(jdbcURL, "sa", "");

            // テーブルを作成
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(255))";
            try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
                statement.executeUpdate();
            }

            // データを挿入
            String insertSQL = "INSERT INTO users (id, name) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
                statement.setInt(1, 2);
                statement.setString(2, "John Doe");
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
