package com.example.LibraryManagementSystem.mapper;

import com.example.LibraryManagementSystem.entity.BookEntity;
import com.example.LibraryManagementSystem.payload.request.BookRequest;
import com.example.LibraryManagementSystem.payload.response.BookResponse;

public class BookMapper {
public static BookResponse toResponse(BookEntity bookentity){
    BookResponse bookResponse= new BookResponse();
    bookResponse.setId(bookentity.getId());
    bookResponse.setName(bookentity.getName());
    bookResponse.setPrice(bookentity.getPrice());
    bookResponse.setAuthor(bookentity.getAuthor());
    bookResponse.setGenere(bookentity.getGenere());
    bookResponse.setDescription(bookentity.getDescription());
    return bookResponse;
}
public static  BookEntity toEntity (BookRequest book){
    BookEntity bookEntity=new BookEntity();
    bookEntity.setName(book.getName());
    bookEntity.setAuthor(book.getAuthor());
    bookEntity.setPrice(book.getPrice());
    bookEntity.setGenere(book.getGenere());
    bookEntity.setDescription(book.getDescription());
    return bookEntity;
}
}
