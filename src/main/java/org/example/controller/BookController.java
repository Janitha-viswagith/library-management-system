package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {


   final BookService service;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBooK(@RequestBody Book book){
         service.addBook(book);
    }

    @GetMapping("/get")
    public Iterable<BookEntity> getBooK(){
        return service.getBooKS();
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {

        if (service.deleteBook(id)) {
            return "Delete";
        } else {
            return "Not Delete";

        }
    }
}
