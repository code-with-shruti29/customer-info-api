package com.sogeti.customerinfo.response;

import com.sogeti.customerinfo.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class for sending response with with single customer details
 * @author Shruti Gautam
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Customer customer;
}
