package com.example.bookrenting.controller;
import com.example.bookrenting.model.*;
import com.example.bookrenting.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @PostMapping
    public Rental rentBook(@RequestBody Rental rental) {
        return rentalService.saveRental(rental);
    }
}