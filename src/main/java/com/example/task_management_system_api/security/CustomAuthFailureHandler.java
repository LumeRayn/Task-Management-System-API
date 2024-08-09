package com.example.task_management_system_api.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


import java.io.IOException;

public class CustomAuthFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        if (exception instanceof UsernameNotFoundException) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), Constants.USER_NOT_FOUND_MESSAGE);
        } else if (exception instanceof BadCredentialsException) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), Constants.BAD_CREDENTIALS_MESSAGE);
        }
    }
}
