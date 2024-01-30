package com.example.newtour.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="hotel")
    public class Hotel {

    @Id
    @Column(name="id_hotel")
    private int id_hotel;
    @Column(name="name_hotel")
    private String name_hotel;
    @Column(name="address_hotel")
    private String address_hotel;
    @Column(name = "hotel_img")
    private String hotel_img;

    public Hotel() {
    }

    public Hotel(int id_hotel, String name_hotel, String address_hotel, String hotel_img, List<TourDetail> hotel_TourDetail) {
        this.id_hotel = id_hotel;
        this.name_hotel = name_hotel;
        this.address_hotel = address_hotel;
        this.hotel_img = hotel_img;
        this.hotel_TourDetail = hotel_TourDetail;
    }

    @OneToMany(mappedBy = "id_tour_detail")
    private List<TourDetail> hotel_TourDetail;
}
