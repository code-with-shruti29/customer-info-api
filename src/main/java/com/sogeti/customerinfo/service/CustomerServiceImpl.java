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

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRespository repository;
    private static String CUSTOMER_NOT_FOUND = "No car found with ID :";
    private static String CUSTOMER_NOT_FOUND_FOR_UPDATE = "No car found for update with ID :";

    @Override
    public Customer findCustomer(Long id) {
        return searchCustomerById(id,CUSTOMER_NOT_FOUND);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Long addCustomer(CustomerInformationRequest request) {
        Customer customer = populateCustomer(request);
        Customer newCustomer = repository.save(customer);
        return newCustomer.getId();

    }

    @Override
    public void updateCustomerEmail(Long id, UpdateCustomerEmailRequest request) {
    Customer customer =searchCustomerById(id,CUSTOMER_NOT_FOUND_FOR_UPDATE);
    customer.getContact().setEmail(request.getEmail());
    repository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    private Customer populateCustomer(CustomerInformationRequest request){
        Customer customer = new Customer();
        customer.setName(request.getName());
        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setEmail(request.getEmailAddress());
        contactDetails.setPhoneNumber(request.getPhoneNumber());
        contactDetails.setCustomer(customer);
        customer.setContact(contactDetails);
        Address address = new Address();
        address.setHouseNumber(request.getHouseNumber());
        address.setPlace(request.getPlace());
        address.setStreet(request.getStreet());
        address.setZipCode(request.getZipCode());
        address.setCustomer(customer);
        customer.setAddress(address);
        return customer;
    }

    private Customer searchCustomerById(final Long carId, final String exceptionMessage){
        Customer customer = repository.findById(carId).orElseThrow(
                () -> new CustomerNotFoundException(exceptionMessage + carId));
        return customer;
    }
}
