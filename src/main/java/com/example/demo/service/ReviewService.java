package com.example.demo.service;

import com.example.demo.domain.Menu;
import com.example.demo.domain.Review;
import com.example.demo.dto.ReviewRequest;
import com.example.demo.dto.ReviewResponse;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final MenuRepository menuRepository;
    private final ReviewRepository reviewRepository;

    public ReviewResponse createReview(ReviewRequest reviewRequest, Long id) {
        Menu menu = menuRepository.findById(id).orElseThrow();
        Review review = reviewRepository.save(Review.from(reviewRequest, menu));
        return ReviewResponse.from(review);
    }

    public List<ReviewResponse> readReviews(Long id){
        Menu menu = menuRepository.findById(id).orElseThrow();
        List<Review> reviews = reviewRepository.findAllByMenu(menu);
        return reviews.stream().map(ReviewResponse::from).toList();
    }

    @Transactional
    public ReviewResponse updateReview(ReviewRequest reviewRequest, Long id) {
        Review review = reviewRepository.findById(id).orElseThrow();
        review.update(reviewRequest);
        return ReviewResponse.from(review);
    }

    public ReviewResponse deleteReview(ReviewRequest reviewRequest, Long id) {
        Review review = reviewRepository.findById(id).orElseThrow();
        reviewRepository.deleteById(id);
        return ReviewResponse.from(review);
    }

}
