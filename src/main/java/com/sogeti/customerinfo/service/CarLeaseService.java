package com.sogeti.customerinfo.service;

import com.sogeti.customerinfo.controller.CarLeaseController;
import com.sogeti.customerinfo.request.LeaseInformationRequest;
import com.sogeti.customerinfo.response.CarDetailsResponse;
import com.sogeti.customerinfo.response.SingleCarDetailsResponse;
/**
 * Interface with methods for processing incoming requests for
 * {@link CarLeaseController}
 *
 * @author Shruti Gautam
 */
public interface CarLeaseService {
    CarDetailsResponse getAllCarsAvailableForLease();
    Float calculateLease(LeaseInformationRequest request);
    SingleCarDetailsResponse getCarInformationByCarId(final long carId);
}
