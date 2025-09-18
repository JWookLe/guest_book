package com.example.guest_book.controller;

import com.example.guest_book.entity.GuestBook;
import com.example.guest_book.repository.GuestBookRepository;
import com.example.guest_book.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final GuestBookService guestBookService;
    private List<GuestBook> bookList;

    @GetMapping({"/list", "/"})
    public String getBookList(Model model) {
        bookList = guestBookService.listBooks();
        model.addAttribute("dataList", bookList);
        return "list";
    }

    @GetMapping("/add")
    public String writeArticle() {
        return "write";
    }

    @PostMapping("/add")
    public String addArticle(@RequestParam String post, @RequestParam String writer) {
        GuestBook book = new GuestBook();
        book.setPost(post);
        book.setWriter(writer);

        guestBookService.addPost(book);

        return "redirect:list";
    }

}
