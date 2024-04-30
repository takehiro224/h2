package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.entity.Book;
import com.mapper.BookMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {
    /** DI */
    private final BookMapper bookMapper;

    /** メニュー画面を表示する */
    @GetMapping("/")
    public String showIndex() {
        return "book/index";
    }

    /** 全ての書籍を取得する */
    @GetMapping("/list")
    public String showAllBooks(Model model) {
        model.addAttribute("message", "一覧表示");
        model.addAttribute("books", bookMapper.getAllBooks());
        return "book/success";
    }

    /** 特定のIDを持つ書籍を取得する */
    @GetMapping("/detail/{id}")
    public String showBook(@PathVariable int id, Model model) {
        model.addAttribute("message", "詳細表示");
        model.addAttribute("book", bookMapper.getBookById(id));
        return "book/success";
    }

    /** 新しい書籍を作成する */
    @GetMapping("/create")
    public String createBook(Model model) {
        /** 登録用ダミーデータ */
        Book book = new Book();
        book.setTitle("クラウド技術を学ぶ");
        book.setAuthor("山田次郎");
        bookMapper.insertBook(book);
        model.addAttribute("message", "登録成功");
        return "book/success";
    }

    /** 特定のIDを持つ書籍を更新する */
    @GetMapping("/update/{id}")
    public String updateBook(@PathVariable int id, Model model) {
        /** 更新用ダミー */
        Book book = new Book();
        book.setId(id);
        book.setTitle("更新タイトル");
        book.setAuthor("渡邊奈夕");
        bookMapper.updateBook(book);
        model.addAttribute("message", "更新成功");
        return "book/success";
    }

    /** 特定のIDを持つ書籍を削除する */
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id, Model model) {
        bookMapper.deleteBookById(id);
        model.addAttribute("message", "削除成功");
        return "book/success";
    }
}