package com.sogeti.customerinfo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class for sending response with Car Information.
 * This is part of {@link CarDetailsResponse}
 * @author Shruti Gautam
 */
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
