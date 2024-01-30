package com.example.newtour.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="location")
public class Location {


    @Id
    @Column(name="id_location")
    private int id_location;
    @Column(name="name_location")
    private String name_location;
    @Column(name="address_location")
    private String address_location;
    @Column(name="location_img")
    private String location_img;
    public Location(int id_location, String name_location, String address_location, String location_img, List<TourDetail> location_TourDetail) {
        this.id_location = id_location;
        this.name_location = name_location;
        this.address_location = address_location;
        this.location_img = location_img;
        this.location_TourDetail = location_TourDetail;
    }

    public Location() {
    }

    @OneToMany(mappedBy = "id_tour_detail")
    private List<TourDetail> location_TourDetail;

}
