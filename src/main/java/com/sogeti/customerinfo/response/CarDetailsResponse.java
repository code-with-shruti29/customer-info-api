package com.sogeti.customerinfo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * Class for sending response with List of Cars and car details
 *
 * @author Shruti Gautam
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDetailsResponse {
   private List<CarDetails> carDetails;
}
