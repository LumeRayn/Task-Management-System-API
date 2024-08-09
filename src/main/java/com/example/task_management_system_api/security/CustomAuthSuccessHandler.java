package com.example.task_management_system_api.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        if (authentication.getAuthorities().stream()
                .anyMatch(e -> e.getAuthority().equals(Constants.Roles.ROLE_ADMIN_NAME))) {
            redirectStrategy.sendRedirect(request, response, Constants.ADMIN_PAGE_URL);
        } else if (authentication.getAuthorities().stream()
                .anyMatch(e -> e.getAuthority().equals(Constants.Roles.ROLE_MODERATOR_NAME))){

        } else {
            redirectStrategy.sendRedirect(request, response, Constants.USER_PAGE_URL);
        }
    }
}
