package com.example.newtour.repository;

import com.example.newtour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TourRepository extends JpaRepository<Tour,Integer> {


    @Query(value = "SELECT * FROM tour", nativeQuery = true)
    List<Tour> selectAllTour();

    @Query(value = "SELECT * FROM tour where id_tour = :id ", nativeQuery = true)
    Tour getTourById(@Param("id") Integer id);

}
