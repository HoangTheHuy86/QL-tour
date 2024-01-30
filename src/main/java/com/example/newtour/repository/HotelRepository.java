package com.example.newtour.repository;

import com.example.newtour.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hotel WHERE id_hotel = :id", nativeQuery = true)
    void deleteByIdHotel(@Param("id") Integer id);

    @Query(value = "SELECT * FROM hotel where id_hotel = :id", nativeQuery = true)
    Hotel findByIdHotel(@Param("id") Integer id);

}
