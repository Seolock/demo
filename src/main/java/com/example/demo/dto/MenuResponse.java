package com.example.demo.dto;

import com.example.demo.domain.Menu;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuResponse {

    private Long id;
    private String name;
    private Long price;

    public static MenuResponse from(Menu menu){
        return builder()
                .id(menu.getId())
                .name(menu.getName())
                .price(menu.getPrice())
                .build();
    }

}
