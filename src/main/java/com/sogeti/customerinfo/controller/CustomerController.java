package com.sogeti.customerinfo.controller;

import com.sogeti.customerinfo.entity.Customer;
import com.sogeti.customerinfo.request.CustomerInformationRequest;
import com.sogeti.customerinfo.request.UpdateCustomerEmailRequest;
import com.sogeti.customerinfo.response.CustomerResponse;
import com.sogeti.customerinfo.response.CustomersResponse;
import com.sogeti.customerinfo.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 * Class for handling incoming requests for performing CRUD
 * operations on {@link Customer}
 *
 * @author  Shruti Gautam
 */
@RestController
@Slf4j
@RequestMapping("/api/customers")
public class CustomerController {
  @Autowired
  CustomerService customerService;

  /**
   * This method handles the incoming request to add a Customer and customer details
   * in database.
   * @param customerInformationRequest
   * @return ResponseEntity<Long>
   */
  @PostMapping
  public ResponseEntity<Long> addCustomer(
      @Valid @RequestBody CustomerInformationRequest customerInformationRequest) {
    Long newCustomerId=customerService.addCustomer(customerInformationRequest);
    return new ResponseEntity<>(newCustomerId,HttpStatus.OK);
  }
  /**
   * This method handles the incoming request to update a Customer's email
   * in database.
   * @param customerId
   * @param updateCustomerEmailRequest
   * @return ResponseEntity<String>
   */
  @PutMapping(value = "/{customerId}")
  public ResponseEntity<String> updateCustomerEmail(
      @PathVariable("customerId") long customerId,
      @Valid @RequestBody UpdateCustomerEmailRequest updateCustomerEmailRequest) {
    customerService.updateCustomerEmail(customerId, updateCustomerEmailRequest);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  /**
   * This method handles the incoming request to delete a Customer and customer details
   * from database.
   * @param customerId
   * @return ResponseEntity<String>
   */
  @DeleteMapping(value = "/{customerId}")
  public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") long customerId) {
    customerService.deleteCustomer(customerId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  /**
   * This method handles the incoming request to retrieve all Customers and customer details
   * from database.
   * @return ResponseEntity<CustomersResponse>
   */
  @GetMapping
  public ResponseEntity<CustomersResponse> getAllCustomers() {
    final List<Customer> customers = customerService.findAllCustomers();
    CustomersResponse customersResponse=new CustomersResponse();
    customersResponse.setCustomers(customers);
    return new ResponseEntity<>(customersResponse, HttpStatus.OK);
  }
  /**
   * This method handles the incoming request to get a Customer and customer details
   * based on customerId from database.
   * @param customerId
   * @return ResponseEntity<CustomerResponse>
   */
  @GetMapping(value = "/{customerId}")
  public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("customerId") long customerId) {
    Customer customer=customerService.findCustomer(customerId);
    CustomerResponse customerResponse = new CustomerResponse();
    customerResponse.setCustomer(customer);
    return new ResponseEntity<>(customerResponse,HttpStatus.OK);
  }
}
