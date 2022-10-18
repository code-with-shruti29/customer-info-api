package com.sogeti.customerinfo.service;

import com.sogeti.customerinfo.entity.Address;
import com.sogeti.customerinfo.entity.ContactDetails;
import com.sogeti.customerinfo.entity.Customer;
import com.sogeti.customerinfo.exception.CustomerNotFoundException;
import com.sogeti.customerinfo.repository.CustomerRespository;
import com.sogeti.customerinfo.request.CustomerInformationRequest;
import com.sogeti.customerinfo.request.UpdateCustomerEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Class providing method implementation of {@link CustomerService} interface
 *
 * @author Shruti Gautam
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRespository repository;
    private static final String CUSTOMER_NOT_FOUND = "No car found with ID :";
    private static final String CUSTOMER_NOT_FOUND_FOR_UPDATE = "No car found for update with ID :";

    /**
     * This method retrieves the customer based on customer id from the database
     * in database.
     * @param customerId
     * @return Customer
     */
    @Override
    public Customer findCustomer(final Long customerId) {
        return searchCustomerById(customerId,CUSTOMER_NOT_FOUND);
    }
    /**
     * This method retrieves the all the customers and customer details from the database
     * @return ResponseEntity<Long>
     */
    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAll();
    }

    /**
     * This method saves a customer and customer details in the database
     * @param request
     * @return ResponseEntity<Long>
     */
    @Override
    public Long addCustomer(final CustomerInformationRequest request) {
        Customer customer = populateCustomer(request);
        Customer newCustomer = repository.save(customer);
        return newCustomer.getId();

    }

    /**
     * This method updates the email address of a customer in the database
     * @param id
     * @param updateCustomerEmailRequest
     * @return ResponseEntity<Long>
     */
    @Override
    public void updateCustomerEmail(final Long id,
                                    final UpdateCustomerEmailRequest updateCustomerEmailRequest) {
    Customer customer =searchCustomerById(id,CUSTOMER_NOT_FOUND_FOR_UPDATE);
    customer.getContact().setEmail(updateCustomerEmailRequest.getEmail());
    repository.save(customer);
    }

    /**
     * This method deletes a customer and customer details from the database based on customerId
     * @param customerId
     */
    @Override
    public void deleteCustomer(final Long customerId) {
        repository.deleteById(customerId);
    }

    /**
     * This method populates a customer and customer details to be saved in the database
     * with values received in the request
     * @param customerInformationRequest
     * @return Customer
     */
    private Customer populateCustomer(final CustomerInformationRequest customerInformationRequest){
        Customer customer = new Customer();
        customer.setName(customerInformationRequest.getName());
        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setEmail(customerInformationRequest.getEmailAddress());
        contactDetails.setPhoneNumber(customerInformationRequest.getPhoneNumber());
        contactDetails.setCustomer(customer);
        customer.setContact(contactDetails);
        Address address = new Address();
        address.setHouseNumber(customerInformationRequest.getHouseNumber());
        address.setPlace(customerInformationRequest.getPlace());
        address.setStreet(customerInformationRequest.getStreet());
        address.setZipCode(customerInformationRequest.getZipCode());
        address.setCustomer(customer);
        customer.setAddress(address);
        return customer;
    }

    private Customer searchCustomerById(final Long carId, final String exceptionMessage){
       return repository.findById(carId).orElseThrow(
                () -> new CustomerNotFoundException(exceptionMessage + carId));

    }
}
