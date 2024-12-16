package com.example.bookrenting.controller;

import com.example.bookrenting.model.Notification;
import com.example.bookrenting.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @GetMapping("/unread")
    public List<Notification> getUnreadNotifications() {
        return notificationRepository.findByIsRead(false);
    }

    @PutMapping("/{id}/mark-as-read")
    public Notification markNotificationAsRead(@PathVariable Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notification.setIsRead(true);
        return notificationRepository.save(notification);
    }
}
