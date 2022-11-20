package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.security.UserPrincipal;
import com.sha.springbootbookseller.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {  /*AuthenticationService bir IAuthenticationService dir
IAuthenticationService tasidigi tum ozellikler ve fonksiyonlar AuthenticationService icinde gecerlidir*/
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IJwtProvider jwtProvider;

    @Override
    public User signInAndReturnJWT(User signInRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        User signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);

        return  signInUser;
    }
}
