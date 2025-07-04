package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void save() {
        System.out.println("Book saved to database.");
    }
}
