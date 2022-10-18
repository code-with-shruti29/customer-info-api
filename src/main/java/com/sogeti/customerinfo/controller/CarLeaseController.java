package com.sogeti.customerinfo.controller;

import com.sogeti.customerinfo.request.LeaseInformationRequest;
import com.sogeti.customerinfo.response.CarDetailsResponse;
import com.sogeti.customerinfo.response.LeaseInformationResponse;
import com.sogeti.customerinfo.service.CarLeaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class for handling incoming requests for calculating lease
 * and for getting car details from car-info-api
 *
 * @author  Shruti Gautam
 */
@RestController
@Slf4j
@RequestMapping("/api/cars")
public class CarLeaseController {
  @Autowired private CarLeaseService carLeaseService;

  @GetMapping
  public ResponseEntity<CarDetailsResponse> getAllcars() {
    final CarDetailsResponse cars = carLeaseService.getAllCarsAvailableForLease();
    return new ResponseEntity<>(cars, HttpStatus.OK);
  }

  @PostMapping (value = "/leaserates")
  public ResponseEntity<LeaseInformationResponse> calculateLeaseRate(
      @RequestBody LeaseInformationRequest request) {
    final Float leaseRate=carLeaseService.calculateLease(request);
    LeaseInformationResponse leaseInformationResponse= new LeaseInformationResponse();
    leaseInformationResponse.setCarId(request.getCarId());
    leaseInformationResponse.setLeaseRate(leaseRate);
    return new ResponseEntity<>(leaseInformationResponse,HttpStatus.OK);
  }
}
