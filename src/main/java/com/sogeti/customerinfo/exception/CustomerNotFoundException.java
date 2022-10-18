package com.sogeti.customerinfo.exception;
/**
 * Custom Exception to handle scenarios when Customer
 *does not exist in database
 * @author Shruti Gautam
 *
 */
public class CustomerNotFoundException extends RuntimeException{
    private String message;

    public CustomerNotFoundException() {}

    public CustomerNotFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }

}
