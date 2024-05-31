package com.turkcell.crm.common.core.config.feign;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class FeignClientInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            String jwtToken = attributes.getRequest().getHeader("Authorization");
            if (jwtToken != null && jwtToken.startsWith("Bearer")) {
                jwtToken = jwtToken.substring(7);
                requestTemplate.header("Authorization", "Bearer " + jwtToken);
            }

        }
    }
}
