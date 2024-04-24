package com.turkcell.crm.identityService.business.concretes;

import com.turkcell.crm.identityService.business.abstracts.AuthService;
import com.turkcell.crm.identityService.business.abstracts.UserService;
import com.turkcell.crm.identityService.business.dtos.requests.LoginRequest;
import com.turkcell.crm.identityService.business.messages.AuthMessages;
import com.turkcell.crm.identityService.core.services.JwtService;
import com.turkcell.crm.identityService.core.utilities.exceptions.types.BusinessException;
import com.turkcell.crm.identityService.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {
    private final UserService userService;
    private final  AuthenticationManager authenticationManager;
    private final JwtService jwtService;



    @Override
    public String login(LoginRequest request) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        if(!authentication.isAuthenticated())
            throw new BusinessException(AuthMessages.LOGIN_FAILED);

        User user = userService.findByUsername(request.getEmail());
        String jwt = generateJwt(user);


        return jwt;
    }

    private String generateJwt(User user)
    {
        Map<String,Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        claims.put("id",user.getId());
        return jwtService.generateToken(claims, user.getEmail());
    }
}
