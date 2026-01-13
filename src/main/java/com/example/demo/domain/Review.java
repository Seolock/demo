package com.example.demo.domain;

import com.example.demo.dto.ReviewRequest;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long score;
    private String content;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Menu menu;

    public static Review from(ReviewRequest reviewRequest, Menu menu){
        return builder()
                .score(reviewRequest.getScore())
                .content(reviewRequest.getContent())
                .menu(menu)
                .build();
    }

    public void update(ReviewRequest reviewRequest) {
        this.score = reviewRequest.getScore();
        this.content = reviewRequest.getContent();
    }
}
