package com.example.bookrenting.repository;

import com.example.bookrenting.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByIsRead(boolean isRead);
}
