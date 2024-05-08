package com.turkcell.crm.customerService.dataAccess.abstracts;

import com.turkcell.crm.customerService.entities.concretes.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Integer> {
    boolean existsByNationalityId(String nationalityId);
}
