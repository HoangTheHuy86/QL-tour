package com.example.newtour.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="bill_detail")
public class BillDetail {

    @Id
    @Column(name="id_bill_detail")
    private int id_bill_detail;


    @ManyToOne
    @JoinColumn(name = "id_bill")
    private Bill bill;

}
