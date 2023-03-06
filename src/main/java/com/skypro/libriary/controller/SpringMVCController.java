package com.skypro.libriary.controller;

import com.skypro.libriary.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/skypro")
public class SpringMVCController {
    private BookService bookservice;

    public SpringMVCController(BookService bookservice) {
        this.bookservice = bookservice;
    }
    @RequestMapping("/web")
    public String getBooks(Model model) {
        model.addAttribute("books", bookservice.getBooks());
        return "dashboard";
    }
}

