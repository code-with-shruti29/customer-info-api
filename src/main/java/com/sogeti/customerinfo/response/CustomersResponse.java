package com.sogeti.customerinfo.response;

import com.sogeti.customerinfo.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomersResponse {
    private List<Customer> customers;
}
