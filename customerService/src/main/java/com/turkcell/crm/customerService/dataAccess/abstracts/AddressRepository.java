package com.turkcell.crm.customerService.dataAccess.abstracts;

import com.turkcell.crm.customerService.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    boolean existsById(int id);
    List<Address> findByCustomerId(int customerId);
    Address findByCustomerIdAndIsDefault(int customerId, boolean isDefault);

    long countByCustomerId(int customerId);
}
