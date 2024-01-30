package com.example.newtour.repository;

import com.example.newtour.model.Tour;
import com.example.newtour.model.TourDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourDetailRepository extends JpaRepository<TourDetail,Integer> {
}
