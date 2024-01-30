package com.example.newtour.repository;

import com.example.newtour.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM restaurant WHERE id_restaurant = :id", nativeQuery = true)
    void deleteByIdRestaurant(@Param("id") Integer id);

    @Query(value = "SELECT * FROM restaurant where id_restaurant = :id", nativeQuery = true)
    Restaurant findByIdRestaurant(@Param("id") Integer id);

}
