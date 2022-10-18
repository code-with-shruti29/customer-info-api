package com.sogeti.customerinfo.service;

import com.sogeti.customerinfo.request.LeaseInformationRequest;
import com.sogeti.customerinfo.response.CarDetailsResponse;

public interface CarLeaseService {
    CarDetailsResponse getAllCarsAvailableForLease();
    Float calculateLease(LeaseInformationRequest request);
}
