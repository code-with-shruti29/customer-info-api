package com.sogeti.customerinfo.request;

import lombok.Data;
import javax.validation.constraints.Email;
/**
 * Class for incoming request for updating email of a customer
 *
 * @author Shruti Gautam
 */
@Data
public class UpdateCustomerEmailRequest {
    @Email
    private String email;
}
