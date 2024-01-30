package com.example.newtour.repository;

import com.example.newtour.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Integer> {

    @Query(value = "SELECT * FROM location", nativeQuery = true)
    List<Location> findAllEntity();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM location WHERE id_location = :id", nativeQuery = true)
    void deleteByIdLocation(@Param("id") Integer id);

    @Query(value = "SELECT * FROM location where id_location = :id", nativeQuery = true)
    Location findByIdLocation(@Param("id") Integer id);

}
