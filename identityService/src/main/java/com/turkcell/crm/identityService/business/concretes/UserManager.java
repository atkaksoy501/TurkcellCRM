package com.turkcell.crm.identityService.business.concretes;

import com.turkcell.crm.identityService.business.abstracts.UserService;
import com.turkcell.crm.identityService.business.dtos.requests.RegisterRequest;
import com.turkcell.crm.identityService.business.messages.AuthMessages;
import com.turkcell.crm.identityService.core.utilities.exceptions.types.BusinessException;
import com.turkcell.crm.identityService.core.utilities.mapping.ModelMapperService;
import com.turkcell.crm.identityService.dataAccess.abstracts.UserRepository;
import com.turkcell.crm.identityService.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.turkcell.crm.common.events.customer.CreateCustomerRequest;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(User user) {
        // TODO: Business Rule, Validation
//        User user = modelMapperService.forRequest().map(request,User.class);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setCreatedDate(LocalDateTime.now());

        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByEmail(username).orElseThrow();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findUserByEmail(username)
                .orElseThrow(() -> new BusinessException(AuthMessages.LOGIN_FAILED));
    }
}
