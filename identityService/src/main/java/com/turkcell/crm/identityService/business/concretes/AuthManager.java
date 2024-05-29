package com.turkcell.crm.identityService.business.concretes;

import com.turkcell.crm.core.util.JwtService;
import com.turkcell.crm.identityService.business.abstracts.AuthService;
import com.turkcell.crm.identityService.business.abstracts.UserService;
import com.turkcell.crm.identityService.business.dtos.requests.LoginRequest;
import com.turkcell.crm.identityService.business.messages.AuthMessages;
import com.turkcell.crm.identityService.core.utilities.exceptions.types.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public String login(LoginRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        if(!authentication.isAuthenticated())
            throw new BusinessException(AuthMessages.LOGIN_FAILED);

        UserDetails user = userService.loadUserByUsername(request.getEmail());

        return jwtService.generateToken(user.getUsername(), user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
    }
}
