package com.sogeti.customerinfo.repository;

import com.sogeti.customerinfo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends JpaRepository<Customer,Long> {
}
