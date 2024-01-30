package com.example.newtour.model;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tour")
@Data
public class Tour {

    @Id
    @Column(name="id_tour")
    private int id_tour;
    @Column(name = "name_tour")
    private String name_tour;
    @Column(name = "mo_ta_tour")
    private String mo_ta_tour;
    @Column(name = "time_start_tour")
    private String time_start_tour;
    @Column(name = "time_end_tour")
    private String time_end_tour;
    @Column(name = "cost_adult")
    private Float cost_adult;
    @Column(name = "cost_children")
    private Float cost_children;
    @Column(name = "tour_img")
    private String tour_img;

    public Tour() {
    }

    public Tour(int id_tour, String name_tour, String mo_ta_tour, String time_start_tour, String time_end_tour, Float cost_adult, Float cost_children, String tour_img, List<TourDetail> listTourDetail) {
        this.id_tour = id_tour;
        this.name_tour = name_tour;
        this.mo_ta_tour = mo_ta_tour;
        this.time_start_tour = time_start_tour;
        this.time_end_tour = time_end_tour;
        this.cost_adult = cost_adult;
        this.cost_children = cost_children;
        this.tour_img = tour_img;
        this.listTourDetail = listTourDetail;
    }

    @OneToMany(mappedBy = "id_tour_detail")
    private List<TourDetail> listTourDetail;






}
