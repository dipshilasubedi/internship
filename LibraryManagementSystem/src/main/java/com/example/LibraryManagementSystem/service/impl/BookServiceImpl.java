package com.example.LibraryManagementSystem.service.impl;

import com.example.LibraryManagementSystem.entity.BookEntity;
import com.example.LibraryManagementSystem.exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.mapper.BookMapper;
import com.example.LibraryManagementSystem.payload.request.BookRequest;
import com.example.LibraryManagementSystem.payload.response.BookResponse;
import com.example.LibraryManagementSystem.repository.BookRepository;
import com.example.LibraryManagementSystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public void createBook(BookRequest book){
        BookEntity bookEntity=BookMapper.toEntity(book);
        bookRepository.save(bookEntity);
    }
     @Override
    public BookResponse getBookById(Long id){
        BookEntity bookEntity= bookRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Not Found"));
       BookResponse bookResponse =BookMapper.toResponse(bookEntity);
        return bookResponse;
    }
@Override
    public BookResponse updateBook( BookRequest book, Long id){
    BookEntity bookEntity= bookRepository.findById(id).
            orElseThrow(()-> new ResourceNotFoundException("Not Found"));
    bookEntity=BookMapper.toEntity(book);
    bookRepository.save(bookEntity);
    BookResponse bookResponse= BookMapper.toResponse(bookEntity);
    return bookResponse;
}
@Override
    public void deleteBook(Long id){
    BookEntity bookEntity= bookRepository.findById(id).
            orElseThrow(()-> new ResourceNotFoundException("Not Found"));
    bookRepository.delete(bookEntity);
}
}
