package com.sogeti.customerinfo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Address {
    @Id
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonBackReference
    private Customer customer;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String place;

}
