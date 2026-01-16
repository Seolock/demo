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
public class Review extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long score;
    @Column(nullable = false, length = 500)
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
