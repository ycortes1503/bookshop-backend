package com.project.service;

import com.project.model.Book;
import dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAll();

    BookDTO findById(Long id);

    void deleteById(Long id);

    BookDTO create(Book book);

    BookDTO update(Book book);

}
