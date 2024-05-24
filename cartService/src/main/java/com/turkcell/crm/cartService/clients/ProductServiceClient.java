package com.turkcell.crm.cartService.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "localhost:9002")
public interface ProductServiceClient {
    @GetMapping("/catalogservice/api/v1/products/isExist/{id}")
    boolean isExist(int id);
}
