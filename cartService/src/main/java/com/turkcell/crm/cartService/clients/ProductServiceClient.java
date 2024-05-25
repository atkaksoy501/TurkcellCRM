package com.turkcell.crm.cartService.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "localhost:56644")
public interface ProductServiceClient {
    @GetMapping("/catalogservice/api/v1/products/isExist/{id}")
    boolean isExist(@PathVariable int id);
}
