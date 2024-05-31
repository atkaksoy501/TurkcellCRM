package com.turkcell.crm.cartService.clients;

import com.turkcell.crm.common.core.config.feign.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "localhost:9002",configuration = FeignClientConfiguration.class)
public interface ProductServiceClient {
    @GetMapping("/api/v1/products/isExist/{id}")
    boolean isExist(@PathVariable int id);

}
