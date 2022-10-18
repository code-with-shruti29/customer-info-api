package com.sogeti.customerinfo.controller;

import com.google.gson.Gson;
import com.sogeti.customerinfo.request.LeaseInformationRequest;
import com.sogeti.customerinfo.response.CarDetailsResponse;
import com.sogeti.customerinfo.response.SingleCarDetailsResponse;
import com.sogeti.customerinfo.service.CarLeaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
/**
 * Test class for methods of {@link CarLeaseController}
 *
 * @author  Shruti Gautam
 */
@RunWith(MockitoJUnitRunner.class)
public class CarLeaseControllerTest {
    @InjectMocks
    CarLeaseController carLeaseController;

    @Mock
    private CarLeaseService carLeaseService;
    @Test
    public void testGetAllCars() throws Exception {
        CarDetailsResponse carDetailsResponse = new CarDetailsResponse();
        when(carLeaseService.getAllCarsAvailableForLease()).thenReturn(carDetailsResponse);
        standaloneSetup(carLeaseController)
                .build()
                .perform(get("/api/cars").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testSingleCars() throws Exception {
        SingleCarDetailsResponse singleCarDetailsResponse = new SingleCarDetailsResponse();
        when(carLeaseService.getCarInformationByCarId(2L)).thenReturn(singleCarDetailsResponse);
        standaloneSetup(carLeaseController)
                .build()
                .perform(get("/api/cars/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCalculateLeaseRate() throws Exception {
        LeaseInformationRequest leaseInformationRequest= new LeaseInformationRequest();
        when(carLeaseService.calculateLease(leaseInformationRequest)).thenReturn(2F);
        Gson gson= new Gson();
        standaloneSetup(carLeaseController)
                .build()
                .perform(post("/api/cars/leaserates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(leaseInformationRequest))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

