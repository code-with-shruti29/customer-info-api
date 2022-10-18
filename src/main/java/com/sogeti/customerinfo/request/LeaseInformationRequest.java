package com.sogeti.customerinfo.request;
/**
 * Class for incoming request for calculating lease rate
 * @author Shruti Gautam
 */
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
@Data
public class LeaseInformationRequest {
    @NotBlank(message = "Car Id can not be blank or null!")
    @Positive
    private Long carId;
    @NotBlank(message = "Mileage can not be blank or null!")
    @Positive
    private Long mileage;
    @NotBlank(message = "Mileage can not be blank or null!")
    @Positive
    private Integer duration;
    @NotBlank(message = "Interest rate can not be blank or null!")
    @Positive
    private Float interestRate;
    @NotBlank(message = "Net price can not be blank or null!")
    @Positive
    private Float netPrice;
}
