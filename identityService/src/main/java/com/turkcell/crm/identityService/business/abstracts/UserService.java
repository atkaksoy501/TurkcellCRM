package com.turkcell.crm.identityService.business.abstracts;

import com.turkcell.crm.identityService.business.dtos.requests.RegisterRequest;
import com.turkcell.crm.identityService.entities.concretes.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void register(User user);
    User findByUsername(String username);
}
