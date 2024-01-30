package com.example.newtour.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="bill")
public class Bill {

    @Id
    @Column(name="id_bill")
    private int id_bill;
    @Column(name = "print_time")
    private String print_time;
    @Column(name="price_bill")
    private Float price_bill;

    @OneToMany(mappedBy = "id_bill_detail")
    private List<BillDetail> listBillDetail;


    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

}
