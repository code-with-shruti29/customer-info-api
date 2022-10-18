package com.sogeti.customerinfo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne(mappedBy = "customer",cascade = {CascadeType.ALL})
    @JsonManagedReference
    private Address address;
    @OneToOne(mappedBy = "customer",cascade = {CascadeType.ALL})
    @JsonManagedReference
    private ContactDetails contact;
}
