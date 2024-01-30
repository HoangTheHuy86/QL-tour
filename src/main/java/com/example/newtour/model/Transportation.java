package com.example.newtour.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="transportation")
public class Transportation {

    @Id
    @Column(name = "id_Transportation")
    private int id_transportation;
    @Column(name = "name_Transportation")
    private String name_transportation;

    public Transportation() {
    }

    public Transportation(int id_transportation, String name_transportation) {
        this.id_transportation = id_transportation;
        this.name_transportation = name_transportation;
    }

    @OneToMany(mappedBy = "id_tour_detail")
    private List<TourDetail> transportation_TourDetail;

}
