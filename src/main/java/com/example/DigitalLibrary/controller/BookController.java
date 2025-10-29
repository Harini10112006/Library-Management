package com.example.DigitalLibrary.controller;

import com.example.DigitalLibrary.entities.Book;
import com.example.DigitalLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }

    @GetMapping("/list")
    public String listBooksAlt(Model model) {
        return listBooks(model);
    }

    @GetMapping("/form")
    public String showBookForm(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            model.addAttribute("book", bookRepository.findById(id).orElse(new Book()));
        } else {
            model.addAttribute("book", new Book());
        }
        return "book/form";
    }

    @PostMapping
    public String saveBook(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}

