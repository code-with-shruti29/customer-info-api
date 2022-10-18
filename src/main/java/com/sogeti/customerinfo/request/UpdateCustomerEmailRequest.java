package com.sogeti.customerinfo.request;

import lombok.Data;
import javax.validation.constraints.Email;

@Data
public class UpdateCustomerEmailRequest {
    @Email
    private String email;
}
