package com.example.bookrenting.repository;
import com.example.bookrenting.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface UserRepository extends JpaRepository<User, Long> {}