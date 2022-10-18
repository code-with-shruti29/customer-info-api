package com.sogeti.customerinfo.config;

import com.sogeti.customerinfo.controller.CarLeaseController;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
/**
 * Test class for methods of {@link RestTemplateConfig}
 *
 * @author  Shruti Gautam
 */
public class RestTemplateConfigTest {
    @Test
    public void testGetRestTemplate(){
        RestTemplateConfig restTemplateConfig = new RestTemplateConfig();
        assertNotNull(restTemplateConfig.getRestTemplate());
    }
}
