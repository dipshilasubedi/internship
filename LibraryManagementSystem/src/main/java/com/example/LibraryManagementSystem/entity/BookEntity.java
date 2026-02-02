package com.example.LibraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_book")
@Getter
@Setter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private String price;
    @Column(name="author")
    private String author;
    @Column(name="genere")
    private String genere;
    @Column(name="description")
    private String description;
}
