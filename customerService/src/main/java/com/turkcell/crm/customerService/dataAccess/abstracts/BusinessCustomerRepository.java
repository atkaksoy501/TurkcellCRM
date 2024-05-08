package com.turkcell.crm.customerService.dataAccess.abstracts;

import com.turkcell.crm.customerService.entities.concretes.BusinessCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessCustomerRepository extends JpaRepository<BusinessCustomer, Integer> {
}
