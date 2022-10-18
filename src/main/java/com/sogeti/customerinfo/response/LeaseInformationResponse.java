package com.sogeti.customerinfo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaseInformationResponse {
    private Long carId;
    private Float leaseRate;
}
