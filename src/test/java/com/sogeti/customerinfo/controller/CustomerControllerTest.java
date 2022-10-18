package com.sogeti.customerinfo.controller;

import com.google.gson.Gson;
import com.sogeti.customerinfo.entity.Customer;
import com.sogeti.customerinfo.request.CustomerInformationRequest;
import com.sogeti.customerinfo.request.UpdateCustomerEmailRequest;
import com.sogeti.customerinfo.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
/**
 * Test class for methods of {@link CustomerController}
 *
 * @author  Shruti Gautam
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
    @InjectMocks
    CustomerController customerController;

    @Mock
    CustomerService customerService;

    @Test
    public void testAddCar() throws Exception {
        CustomerInformationRequest customerInformationRequest= getCustomerInformationRequest();
        Gson gson= new Gson();
        standaloneSetup(customerController)
                .build()
                .perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(customerInformationRequest))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateCustomerEmail() throws Exception {
        UpdateCustomerEmailRequest updateCustomerEmailRequest = new UpdateCustomerEmailRequest();
        Gson gson= new Gson();
        standaloneSetup(customerController)
                .build()
                .perform(put("/api/customers/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(updateCustomerEmailRequest))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCustomer() throws Exception {
        standaloneSetup(customerController)
                .build()
                .perform(delete("/api/customers/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        when(customerService.findAllCustomers()).thenReturn(new ArrayList<Customer>());
        standaloneSetup(customerController)
                .build()
                .perform(get("/api/customers").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCustomer() throws Exception {
        when(customerService.findCustomer(anyLong())).thenReturn(new Customer());
        standaloneSetup(customerController)
                .build()
                .perform(get("/api/customers/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
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
