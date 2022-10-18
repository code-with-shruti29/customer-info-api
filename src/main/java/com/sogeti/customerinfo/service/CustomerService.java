package com.sogeti.customerinfo.service;


import com.sogeti.customerinfo.entity.Customer;
import com.sogeti.customerinfo.request.CustomerInformationRequest;
import com.sogeti.customerinfo.request.UpdateCustomerEmailRequest;

import java.util.List;

public interface CustomerService {
    Customer findCustomer(Long id);
    List<Customer> findAllCustomers();
    Long addCustomer(CustomerInformationRequest request);
    void updateCustomerEmail(Long customerId, UpdateCustomerEmailRequest request);
    void deleteCustomer(Long Id);
}
