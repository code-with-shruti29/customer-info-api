package com.sogeti.customerinfo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Class for sending response with lease Information after calculation.
 *
 * @author Shruti Gautam
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaseInformationResponse {
    private Long carId;
    private Float leaseRate;
}
