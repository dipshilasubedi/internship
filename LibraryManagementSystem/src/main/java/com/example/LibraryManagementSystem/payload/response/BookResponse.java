package com.example.LibraryManagementSystem.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private String price;
    private String author;
    private String genere;
    private String description;
}
