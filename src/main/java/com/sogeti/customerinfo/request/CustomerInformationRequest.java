package com.sogeti.customerinfo.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
/**
 * Class for incoming request for adding Customer Information
 *
 * @author Shruti Gautam
 */
@Data
public class CustomerInformationRequest {
    @NotBlank(message = "Name of the customer can not be blank or null!")
    private String name;
    @NotBlank(message = "Name of the customer can not be blank or null!")
    private String street;
    @NotBlank(message = "Name of the customer can not be blank or null!")
    private String houseNumber;
    @NotBlank(message = "Name of the customer can not be blank or null!")
    private String zipCode;
    @NotBlank(message = "Name of the customer can not be blank or null!")
    private String place;
    @NotBlank(message = "Name of the customer can not be blank or null!")
    @Email
    private String emailAddress;
    @NotBlank(message = "Phone number of the customer can not be blank or null!")
    private String phoneNumber;
}
