package com.turkcell.crm.orderService.clients;

import com.turkcell.crm.common.core.config.feign.FeignClientConfiguration;
import com.turkcell.crm.orderService.business.dtos.responses.GetAddressResponseById;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "addressClient", url = "localhost:9002", configuration = FeignClientConfiguration.class)
public interface AddressServiceClient {

    @GetMapping("/customerservice/api/v1/addresses/getById/{id}")
    GetAddressResponseById getById(@PathVariable int id);
}
