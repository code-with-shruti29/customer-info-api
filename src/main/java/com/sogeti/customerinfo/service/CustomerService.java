package com.sogeti.customerinfo.service;

import com.sogeti.customerinfo.controller.CustomerController;
import com.sogeti.customerinfo.entity.Customer;
import com.sogeti.customerinfo.request.CustomerInformationRequest;
import com.sogeti.customerinfo.request.UpdateCustomerEmailRequest;

import java.util.List;
/**
 * Interface with methods for processing incoming requests for
 * {@link CustomerController}
 *
 * @author Shruti Gautam
 */
public interface CustomerService {
    Customer findCustomer(Long customerId);
    List<Customer> findAllCustomers();
    Long addCustomer(CustomerInformationRequest rustomerInformationRequest);
    void updateCustomerEmail(Long customerId,
                             UpdateCustomerEmailRequest updateCustomerEmailRequest);
    void deleteCustomer(Long customerId);
}
