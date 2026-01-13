package com.example.demo.repository;

import com.example.demo.domain.Menu;
import com.example.demo.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findAllByMenu(Menu menu);

}
