package com.sogeti.customerinfo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ContactDetails {
    @Id
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @MapsId
    private Customer customer;
    private String email;
    private String phoneNumber;
}
