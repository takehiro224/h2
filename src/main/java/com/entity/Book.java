package com.entity;

import java.util.List;

import lombok.Data;

@Data
public class Book {
    /** 書籍ID */
    private int id;
    /** タイトル */
    private String title;
    /** 著者 */
    private String author;
    /** 書籍と出版社の1対1の関係 */
    private Publisher publisher;
    /** 書籍とレビューの1対多の関係 */
    private List<Review> reviews;
}
