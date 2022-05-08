package com.project.controller;


import com.project.model.Book;
import com.project.service.BookService;
import dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/book")
@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final BookService service;

    @Autowired
    public RestController(BookService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public BookDTO createBook(@RequestBody final Book book) {
        return service.create(book);
    }

    @PutMapping("/update/{id}")
    public BookDTO updateBook(@PathVariable("id") final String id, @RequestBody Book book) {
        return service.update(book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") final String id) {
        service.deleteById(Long.parseLong(id));
    }

    @GetMapping("/")
    public List<BookDTO> findBooks() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BookDTO findById(long id) {
        return service.findById(id);
    }

}
