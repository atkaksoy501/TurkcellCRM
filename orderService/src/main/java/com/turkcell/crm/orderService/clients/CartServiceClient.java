package com.turkcell.crm.orderService.clients;

import com.turkcell.crm.common.core.config.feign.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cartClient", url = "localhost:9002", configuration = FeignClientConfiguration.class)
public interface CartServiceClient {

    @GetMapping("/cartservice/api/v1/carts/getTotalPrice/{accountId}")
    double getTotalPriceByAccountId(@PathVariable int accountId);
}
