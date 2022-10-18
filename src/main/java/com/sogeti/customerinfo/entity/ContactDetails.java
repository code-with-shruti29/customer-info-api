package com.sogeti.customerinfo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

/**
 * Entity class for ContactDetails
 * @author Shruti Gautam
 *
 */
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
