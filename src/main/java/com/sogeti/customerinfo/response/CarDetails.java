package com.sogeti.customerinfo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDetails {
    private Long id;
    private String make;
    private String model;
    private String version;
    private Integer numberOfDoors;
    private Float cO2Emission;
    private CarLeaseDetails carLeaseDetails;

}
