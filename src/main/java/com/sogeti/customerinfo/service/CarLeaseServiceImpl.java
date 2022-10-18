package com.sogeti.customerinfo.service;

import com.sogeti.customerinfo.common.Constants;
import com.sogeti.customerinfo.request.LeaseInformationRequest;
import com.sogeti.customerinfo.response.CarDetailsResponse;
import com.sogeti.customerinfo.response.SingleCarDetailsResponse;
import com.sogeti.customerinfo.util.CarLeaseCalculater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
/**
 * Class providing method implementation of {@link CarLeaseService} interface
 *
 * @author Shruti Gautam
 */
@Service
public class CarLeaseServiceImpl implements CarLeaseService {
  @Value("${cars.api.endpoint}")
  private String carApiEndpoint;
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CarLeaseCalculater carleaseCalculater;
  /**
   * This method handles call to car-info-api to retrieve details of all cars
   *
   * @return CarDetailsResponse
   */
  @Override
  public CarDetailsResponse getAllCarsAvailableForLease() {
    return restTemplate.getForObject(carApiEndpoint,CarDetailsResponse.class);
  }
  /**
   * This method handles call to car-info-api to retrieve details of a car based on carId
   * @param carId
   * @return SingleCarDetailsResponse
   */
  @Override
  public SingleCarDetailsResponse getCarInformationByCarId(final long carId) {
    return restTemplate.getForObject(carApiEndpoint+ Constants.SLASH+carId,SingleCarDetailsResponse.class);
  }
  /**
   * This method handles calculates lease rate for a car
   * @param leaseInformationRequest
   * @return Float
   */
  @Override
  public Float calculateLease(LeaseInformationRequest leaseInformationRequest) {
    return carleaseCalculater.getLeaseRate(
            leaseInformationRequest.getMileage(),
            leaseInformationRequest.getDuration(),
            leaseInformationRequest.getNetPrice(),
            leaseInformationRequest.getInterestRate());
  }
}
