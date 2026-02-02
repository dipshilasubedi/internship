package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.payload.request.BookRequest;
import com.example.LibraryManagementSystem.payload.response.BookResponse;
import com.example.LibraryManagementSystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/create")
    public void createBook(@RequestBody BookRequest book){
        bookService.createBook(book);
    }
     @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id){
         return bookService.getBookById(id);
     }
     @PutMapping("/update/{id}")
    public BookResponse updateBook(@RequestBody BookRequest book, @PathVariable Long id){
        return bookService.updateBook(book,id);
     }
     @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
     }
}
