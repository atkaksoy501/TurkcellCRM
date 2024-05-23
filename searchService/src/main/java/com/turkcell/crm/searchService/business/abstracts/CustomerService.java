package com.turkcell.crm.searchService.business.abstracts;

import com.turkcell.crm.searchService.entities.concretes.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void add(Customer customer);

   // burda genel arama yapıyoruz istere göre bir durum söz konusu değil
    void searchByNationalityId(String nationalityId);

    Page<Customer> searchCustomers(
            Optional<String> nationalityId,
            Optional<String> customerId,
            Optional<Long> accountNumber,
            Optional<Long> gsmNumber,
            Optional<String> firstName,
            Optional<String> middleName,
            Optional<String> lastName,
            Optional<Long> orderNumber,
            Pageable pageable);

}
