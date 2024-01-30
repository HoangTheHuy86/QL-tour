package com.example.newtour.repository;

import com.example.newtour.model.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface TransportationRepository2 extends JpaRepository<Transportation,Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM transportation WHERE id_transportation = :id", nativeQuery = true)
    void deleteByIdTransportation(@Param("id") Integer id);}
