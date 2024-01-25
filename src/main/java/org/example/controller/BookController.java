package org.example.controller;

import org.example.dto.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService service;
    @PostMapping
    public void addBooK(@RequestBody Book book){
         service.addBook(book);
    }

}
