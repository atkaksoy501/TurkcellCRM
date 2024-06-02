package com.turkcell.crm.orderService.dataAccess;

import com.turkcell.crm.orderService.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    boolean existsByAccountIdAndProductIdsIsNotEmpty(int accountId);
}
