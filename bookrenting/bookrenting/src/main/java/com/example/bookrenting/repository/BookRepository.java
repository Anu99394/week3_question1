package com.example.bookrenting.repository;

import com.example.bookrenting.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByGenre(String genre);
    List<Book> findByTitleContainingIgnoreCase(String title);
}