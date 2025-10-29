package com.example.DigitalLibrary.service;

import com.example.DigitalLibrary.entities.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book saveBook(Book book);
    Book getBookById(Long id);
    void deleteBook(Long id);
}
