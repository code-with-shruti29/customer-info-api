package com.sogeti.customerinfo.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for methods of {@link CarLeaseCalculater}
 *
 * @author  Shruti Gautam
 */
@RunWith(MockitoJUnitRunner.class)
public class CarLeaseCalculaterTest {
    @InjectMocks
    CarLeaseCalculater carLeaseCalculater;

    @Test
    public void testGetLeaseRate(){
        float carLeaseRate =carLeaseCalculater.getLeaseRate(1000l,10,1000,10);
        assertEquals(9.16333293914795,carLeaseRate);
    }


}
