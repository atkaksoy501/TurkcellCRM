package com.turkcell.crm.orderService.dataAccess;

import com.turkcell.crm.orderService.entities.concretes.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItems,Integer> {
}
