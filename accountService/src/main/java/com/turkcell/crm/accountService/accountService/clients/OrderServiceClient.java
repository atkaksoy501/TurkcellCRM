package com.turkcell.crm.accountService.accountService.clients;

import org.springframework.cloud.openfeign.FeignClient;
import com.turkcell.crm.common.core.config.feign.FeignClientConfiguration;

@FeignClient(name = "localhost:9002",configuration = FeignClientConfiguration.class)
public interface OrderServiceClient {

}
