package com.sogeti.customerinfo.repository;

import com.sogeti.customerinfo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository for {@link Customer}
 *
 * @author Shruti Gautam
 */
@Repository
public interface CustomerRespository extends JpaRepository<Customer,Long> {
}
