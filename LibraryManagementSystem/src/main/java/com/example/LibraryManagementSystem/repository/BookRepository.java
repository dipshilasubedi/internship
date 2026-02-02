package com.example.LibraryManagementSystem.repository;

import com.example.LibraryManagementSystem.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
