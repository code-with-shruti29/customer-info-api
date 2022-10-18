package com.sogeti.customerinfo.service;

import com.sogeti.customerinfo.entity.Customer;
import com.sogeti.customerinfo.repository.CustomerRespository;
import com.sogeti.customerinfo.request.CustomerInformationRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for methods of {@link CustomerServiceImpl}
 *
 * @author  Shruti Gautam
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @InjectMocks
    CustomerServiceImpl CustomerService;

    @Mock
    private CustomerRespository customerRespository;

    @Test
    public void testAddCustomer(){
        CustomerInformationRequest customerInformationRequest= getCustomerInformationRequest();
        Customer customer= mock(Customer.class);
        when(customer.getId()).thenReturn(1l);
        when(customerRespository.save(any())).thenReturn(customer);
        Long customerId=CustomerService.addCustomer(customerInformationRequest);
        assertEquals(1l,customerId);
    }

    @Test
    public void testFindAll(){
        when(customerRespository.findAll()).thenReturn(new ArrayList<Customer>());
        List<Customer> customers =CustomerService.findAllCustomers();
        assertNotNull(customers);
    }

    @Test
    public void testFindCustomer(){
        when(customerRespository.findById(anyLong())).thenReturn(java.util.Optional.of(new Customer()));
        Customer customer =CustomerService.findCustomer(1l);
        assertNotNull(customer);
    }

    private  CustomerInformationRequest getCustomerInformationRequest(){
        CustomerInformationRequest customerInformationRequest= new CustomerInformationRequest();
        customerInformationRequest.setName("abc");
        customerInformationRequest.setHouseNumber("102");
        customerInformationRequest.setPlace("Utrecht");
        customerInformationRequest.setStreet("Otterstraat");
        customerInformationRequest.setZipCode("3513CL");
        customerInformationRequest.setEmailAddress("abc@abc.com");
        customerInformationRequest.setPhoneNumber("123456");
        return customerInformationRequest;
    }

}
