package com.mediavault.security;

import com.mediavault.entity.Session;
import com.mediavault.entity.User;
import com.mediavault.repository.SessionRepository;
import com.mediavault.security.ApiKeyAuthentication;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {
    private final SessionRepository sessionRepository;

    public ApiKeyAuthenticationFilter(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apiKey = request.getHeader("X-MediaVault-Token");

        if (apiKey != null) {
            Optional<Session> sessionOpt = sessionRepository.findByAccessToken(apiKey);

            if (sessionOpt.isPresent()) {
                Session session = sessionOpt.get();
                User user = session.getUser();

                if (user != null) {
                    SecurityContextHolder.getContext().setAuthentication(new ApiKeyAuthentication(user));
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}

