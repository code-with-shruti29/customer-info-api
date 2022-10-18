package com.sogeti.customerinfo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarLeaseDetails {
    private Long id;
    private CarDetails carDetails;
    private Float grossPrice;
    private Float netPrice;
    private Long mileage;
    private Float interestRate;
}
