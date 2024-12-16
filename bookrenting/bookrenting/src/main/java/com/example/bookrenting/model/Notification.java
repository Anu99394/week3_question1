package com.example.bookrenting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
    public class Notification
{
        @ManyToOne(fetch = FetchType.EAGER)
        @JsonBackReference
        private Rental rental;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private boolean isRead = false;

    private LocalDateTime createdAt;

//        @ManyToOne
//        private Rental rental;

        // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental)
    {
        this.rental = rental;
    }

    public void setIsRead(boolean b) {
        isRead=true;
    }
}

