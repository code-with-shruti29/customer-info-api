package com.sogeti.customerinfo.service;

import com.sogeti.customerinfo.config.RestTemplateConfig;
import com.sogeti.customerinfo.request.LeaseInformationRequest;
import com.sogeti.customerinfo.response.CarDetailsResponse;
import com.sogeti.customerinfo.util.CarLeaseCalculater;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test class for methods of {@link CarLeaseCalculater}
 *
 * @author  Shruti Gautam
 */
@RunWith(MockitoJUnitRunner.class)
public class CarLeaseServiceTest {
    @InjectMocks
    CarLeaseServiceImpl carLeaseService;

    @Mock
    private CarLeaseCalculater carleaseCalculater;
    @Test
    public void testGetAllCarsAvailableForLease(){
        LeaseInformationRequest leaseInformationRequest= mock(LeaseInformationRequest.class);
        when(leaseInformationRequest.getDuration()).thenReturn(10);
        when(leaseInformationRequest.getInterestRate()).thenReturn(10f);
        when(leaseInformationRequest.getMileage()).thenReturn(1000l);
        when(leaseInformationRequest.getNetPrice()).thenReturn(1000f);
        when(carleaseCalculater.getLeaseRate(1000l,10,1000,10)).thenReturn(9.16333293914795f);
        float carleaseRate =carLeaseService.calculateLease(leaseInformationRequest);
        assertEquals(9.16333293914795,carleaseRate);
    }
}
