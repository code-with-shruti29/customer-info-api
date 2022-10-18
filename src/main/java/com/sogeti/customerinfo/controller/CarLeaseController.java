package com.sogeti.customerinfo.controller;

import com.sogeti.customerinfo.request.LeaseInformationRequest;
import com.sogeti.customerinfo.response.CarDetailsResponse;
import com.sogeti.customerinfo.response.LeaseInformationResponse;
import com.sogeti.customerinfo.response.SingleCarDetailsResponse;
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
  /**
   * This method handles the incoming request to retrieve all cars and their details
   * by calling car-info-api.
   * @return ResponseEntity<CarDetailsResponse>
   */
  @GetMapping
  public ResponseEntity<CarDetailsResponse> getAllcars() {
    final CarDetailsResponse cars = carLeaseService.getAllCarsAvailableForLease();
    return new ResponseEntity<>(cars, HttpStatus.OK);
  }
  /**
   * This method handles the incoming request to retrieve a cars and its details
   * by calling car-info-api on the basis of carId.
   *  @param carId
   * @return ResponseEntity<CarDetailsResponse>
   */
  @GetMapping(value = "/{carId}")
  public ResponseEntity<SingleCarDetailsResponse> getcar(@PathVariable("carId") long carId) {
    final SingleCarDetailsResponse singleCarDetailsResponse = carLeaseService.getCarInformationByCarId(carId);
    return new ResponseEntity<>(singleCarDetailsResponse, HttpStatus.OK);
  }

  /**
   * This method handles the incoming request to calculate lease rate of the car
   *  @param leaseInformationRequest
   * @return ResponseEntity<CarDetailsResponse>
   */
  @PostMapping (value = "/leaserates")
  public ResponseEntity<LeaseInformationResponse> calculateLeaseRate(
      @RequestBody LeaseInformationRequest leaseInformationRequest) {
    final Float leaseRate=carLeaseService.calculateLease(leaseInformationRequest);
    LeaseInformationResponse leaseInformationResponse= new LeaseInformationResponse();
    leaseInformationResponse.setCarId(leaseInformationRequest.getCarId());
    leaseInformationResponse.setLeaseRate(leaseRate);
    return new ResponseEntity<>(leaseInformationResponse,HttpStatus.OK);
  }
}
