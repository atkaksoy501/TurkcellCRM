package com.turkcell.crm.cartService.repositories;

import com.turkcell.crm.cartService.entities.concretes.Cart;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RedisRepository {

    public static final String KEY = "CART";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String,String, Cart> hashOperations;

    public RedisRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public Map<String,Cart> getAllItems(){
        return this.hashOperations.entries(KEY);
    }

    public void addItem(Cart cart){
        this.hashOperations.put(KEY,cart.getId() + "_" + cart.getAccountId(),cart);
    }

    public Cart getCartByAccountId(String accountId) {
        return hashOperations.entries(KEY).values().stream()
                .filter(cart -> accountId.equals(cart.getAccountId()))
                .findFirst()
                .orElse(null);
    }

    public void deleteItem(String id){
        this.hashOperations.delete(KEY,id);
    }
}
