package com.example.bookrenting.service;

import com.example.bookrenting.model.*;
import com.example.bookrenting.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental saveRental(Rental rental) {
        // Generate initial notification
        Rental savedRental = rentalRepository.save(rental);

        // Log the saved rental for debugging
        System.out.println("Saved Rental: " + savedRental);
        Notification notification = new Notification();
        notification.setMessage("Reminder: Your rental is due on " + rental.getReturnDate());
        notification.setRental(savedRental);
        notification.setCreatedAt(java.time.LocalDateTime.now());
        notificationRepository.save(notification);
        return rentalRepository.save(rental);
    }

    @Transactional
    public void sendRemindersForExpiringRentals() {
        LocalDate today = LocalDate.now();

        // Fetch rentals whose return date is tomorrow
       // List<Rental> rentals = rentalRepository.findRentalsByReturnDate(today.plusDays(1));
        List<Rental> rentals=new ArrayList<>();
        // For each rental, create a reminder notification
        for (Rental rental : rentals) {
            // Check if the rental's return date is exactly one day from today
            if (rental.getReturnDate().equals(today.plusDays(1))) {
                // Create a new notification for the expiring rental
                Notification notification = new Notification();
                notification.setMessage("Reminder: Your rental for the book '" + rental.getBook().getTitle() + "' is expiring tomorrow (" + rental.getReturnDate() + ").");
                notification.setRental(rental); // Associate the notification with the rental
                notification.setCreatedAt(java.time.LocalDateTime.now());

                // Save the notification to the database
                notificationRepository.save(notification);
            }
        }

    }
}
