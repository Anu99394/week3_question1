package com.example.bookrenting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NotificationScheduler {
    @Autowired
    private RentalService rentalService;

    @Scheduled(cron = "0 0 8 * * ?") // Run every day at 8 AM
    public void sendDailyReminders() {
        rentalService.sendRemindersForExpiringRentals();
    }
}
