package com.example.newtour.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="tour_detail")
public class TourDetail {

    @Id
    @Column(name = "id_tour_detail")
    private int id_tour_detail;
    @Column(name = "time_start")
    private String time_start;
    @Column(name = "time_end")
    private String time_end;

    //    f_K tour
    @ManyToOne
    @JoinColumn(name = "id_tour")
    private Tour tour;
//    f_k khach san
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

//    f_k dia diem
    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;
//    f_k nha hang
    @ManyToOne
    @JoinColumn(name = "id_restaurant")
    private Restaurant restaurant;
//    f_k phuong tien
    @ManyToOne
    @JoinColumn(name = "id_transportation")
    private Transportation transportation;


}
