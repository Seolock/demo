package com.example.demo.dto;

import com.example.demo.domain.Review;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewResponse {

    private Long id;
    private Long score;
    private String content;

    public static ReviewResponse from(Review review){
        return builder()
                .id(review.getId())
                .score(review.getScore())
                .content(review.getContent())
                .build();
    }
}
