package org.example.service.Impl;

import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
   @Autowired
    BookRepository repository;
   @Bean
   public void setup(){
       this.mapper = new ModelMapper();
   }
   private ModelMapper mapper;
    @Override
    public void addBook(Book book) {
    BookEntity entity  =mapper.map(book, BookEntity.class);
    repository.save(entity);
    }
}
