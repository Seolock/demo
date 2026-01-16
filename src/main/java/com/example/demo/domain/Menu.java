package com.example.demo.domain;

import com.example.demo.dto.MenuRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Menu extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(nullable = false, length = 30)
    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(nullable = false)
    private Long price;

    @OneToMany(mappedBy="menu",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private List<Review> reviews;

    public static Menu from(MenuRequest menuRequest){
        return builder()
                .name(menuRequest.getName())
                .price(menuRequest.getPrice())
                .build();
    }

    public void update(MenuRequest menuRequest){
        this.name = menuRequest.getName();
        this.price = menuRequest.getPrice();
    }

}
