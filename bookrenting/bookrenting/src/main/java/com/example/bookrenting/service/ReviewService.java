package com.example.bookrenting.service;

import com.example.bookrenting.model.*;
import com.example.bookrenting.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Review> getReviewsByBook(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    public Review addReview(Review review) {
        // Fetch the book from the database using the bookId from the review
        Book book = bookRepository.findById(review.getBook().getId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Set the book to the review
        review.setBook(book);

        // Save and return the review
        return reviewRepository.save(review);
    }
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}