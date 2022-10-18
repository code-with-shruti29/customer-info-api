package com.sogeti.customerinfo.service;

import com.sogeti.customerinfo.request.LeaseInformationRequest;
import com.sogeti.customerinfo.response.CarDetailsResponse;
import com.sogeti.customerinfo.util.CarLeaseCalculater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarLeaseServiceImpl implements CarLeaseService {
  @Value("${car.api.endpoint}")
  private String carApiEndpoint;
  private static int TWELVE = 12;
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CarLeaseCalculater carleaseCalculater;

  @Override
  public CarDetailsResponse getAllCarsAvailableForLease() {
    return restTemplate.getForObject(carApiEndpoint,CarDetailsResponse.class);
  }

  @Override
  public Float calculateLease(LeaseInformationRequest request) {
    return carleaseCalculater.getLeaseRate(
        request.getMileage(),
        request.getDuration(),
        request.getNetPrice(),
        request.getInterestRate());
  }
}
