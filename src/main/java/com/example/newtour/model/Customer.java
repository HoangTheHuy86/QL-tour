package com.example.newtour.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="customer")
public class Customer {

    @Id
    @Column(name="id_customer")
    private int id_customer;
    @Column(name="name_customer")
    private String name_customer;
    @Column(name="age_customer")
    private String age_customer;
    @Column(name="sdt")
    private int sdt;
    @Column(name="address_customer")
    private String address_customer;


    @OneToMany(mappedBy = "id_bill")
    private List<Bill> listBill;

}
