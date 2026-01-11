package com.example.demo.dto;

import lombok.Data;

@Data
public class ReviewRequest {

    private Long menuId;
    private Long score;
    private String Content;

}
