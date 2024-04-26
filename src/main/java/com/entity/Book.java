package com.entity;

import lombok.Data;

@Data
public class Book {
    /** 書籍ID */
    private int id;
    /** タイトル */
    private String title;
    /** 著者 */
    private String author;
}
