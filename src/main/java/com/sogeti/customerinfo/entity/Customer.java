package com.sogeti.customerinfo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity class for Customer
 *
 * @author Shruti Gautam
 *
 */
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
