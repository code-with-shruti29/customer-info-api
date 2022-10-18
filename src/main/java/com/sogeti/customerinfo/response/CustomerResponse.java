package com.sogeti.customerinfo.response;

import com.sogeti.customerinfo.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Customer customer;
}
