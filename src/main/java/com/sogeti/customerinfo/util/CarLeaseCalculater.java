package com.sogeti.customerinfo.util;

import com.sogeti.customerinfo.request.LeaseInformationRequest;
import org.springframework.stereotype.Component;

@Component
public class CarLeaseCalculater {
    private static int TWELVE = 12;

    public float getLeaseRate(long mileage,int duration,float netPrice, float interestRate){
        return  ((mileage / TWELVE) * duration) / netPrice
                + (((interestRate / 100) * netPrice) / TWELVE);

    }
}
