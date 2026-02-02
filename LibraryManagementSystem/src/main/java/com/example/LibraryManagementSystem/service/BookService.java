package com.example.LibraryManagementSystem.service;


import com.example.LibraryManagementSystem.payload.request.BookRequest;
import com.example.LibraryManagementSystem.payload.response.BookResponse;

public interface BookService {
    void createBook(BookRequest book);
    BookResponse getBookById(Long id);
    BookResponse updateBook( BookRequest book, Long id);
}
