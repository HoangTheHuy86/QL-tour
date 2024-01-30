package com.example.newtour.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="restaurant")
public class Restaurant {

    @Id
    @Column(name="id_restaurant")
    private int id_restaurant;
    @Column(name="name_restaurant")
    private String name_restaurant;
    @Column(name="address_restaurant")
    private String address_restaurant;
    @Column(name = "restaurant_img")
    private String restaurant_img;

    public Restaurant(int id_restaurant, String name_restaurant, String address_restaurant, String restaurant_img, List<TourDetail> restaurant_TourDetail) {
        this.id_restaurant = id_restaurant;
        this.name_restaurant = name_restaurant;
        this.address_restaurant = address_restaurant;
        this.restaurant_img = restaurant_img;
        this.restaurant_TourDetail = restaurant_TourDetail;
    }

    public Restaurant() {
    }

    @OneToMany(mappedBy = "id_tour_detail")
    private List<TourDetail> restaurant_TourDetail;
}
