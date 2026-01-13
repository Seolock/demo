package com.example.demo.controller;

import com.example.demo.dto.ReviewRequest;
import com.example.demo.dto.ReviewResponse;
import com.example.demo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{id}")
    public ReviewResponse createReview(@RequestBody ReviewRequest reviewRequest, @PathVariable Long id){
        return reviewService.createReview(reviewRequest,id);
    }

    @GetMapping("/{id}")
    public List<ReviewResponse> readReviews(@PathVariable Long id){
        return reviewService.readReviews(id);
    }

    @PutMapping("/{id}")
    public ReviewResponse updateReview(@RequestBody ReviewRequest reviewRequest, @PathVariable Long id){
        return reviewService.updateReview(reviewRequest,id);
    }

    @DeleteMapping("/{id}")
    public ReviewResponse deleteReview(@RequestBody ReviewRequest reviewRequest, @PathVariable Long id){
        return reviewService.deleteReview(reviewRequest,id);
    }

}
