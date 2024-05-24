package com.turkcell.crm.cartService.dataAccess;

import com.turkcell.crm.cartService.entities.concretes.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
