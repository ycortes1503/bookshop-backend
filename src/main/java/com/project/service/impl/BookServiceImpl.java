package com.project.service.impl;

import com.project.model.Book;
import com.project.repository.BookRepository;
import com.project.service.BookService;
import dto.BookDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    private final ModelMapper mapper;

    @Autowired
    public BookServiceImpl(BookRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<BookDTO> getAll() {
        log.info("Getting Books");
        List<Book> list = repository.findAll();
        return list.stream().map(b -> mapper.map(b, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO findById(Long id) {
        log.info("Get book by Id");
        Book book = repository.findById(id).orElseThrow();
        return mapper.map(book, BookDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete book by Id");
        Book book =  repository.findById(id).orElseThrow();
        repository.delete(book);
    }

    @Override
    public BookDTO create(Book book) {
        log.info("Create new book");
        Book newBook = mapper.map(book, Book.class);
        newBook = repository.save(newBook);
        return mapper.map(newBook, BookDTO.class);
    }

    @Override
    public BookDTO update(Book book) {
        log.info("Update book");
        Book updatedBook =  repository.findById(book.getId()).orElseThrow();
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setCode(book.getCode());
        updatedBook.setOverview(book.getOverview());
        updatedBook.setPrice(book.getPrice());
        updatedBook.setTitle(book.getTitle());
        updatedBook = repository.save(updatedBook);
        return mapper.map(updatedBook, BookDTO.class);
    }
}
