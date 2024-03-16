package com.hrm.service;


import com.hrm.dto.SignUpRequest;
import com.hrm.dto.SigninRequest;
import com.hrm.dto.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
