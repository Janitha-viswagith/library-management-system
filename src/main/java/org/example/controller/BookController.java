package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
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
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {

        return service.deleteBook(id) ?
                ResponseEntity.ok("Delete") :
                ResponseEntity.notFound().build();

    }

    @GetMapping("search/{id}")
    public Book getBooKById(@PathVariable Long id){
        return service.getBooKById(id);
    }
}
