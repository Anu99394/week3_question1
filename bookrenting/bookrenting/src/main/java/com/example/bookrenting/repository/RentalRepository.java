package com.example.bookrenting.repository;

import com.example.bookrenting.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
//    List<Rental> getReturnDate(LocalDate returnDate);
}