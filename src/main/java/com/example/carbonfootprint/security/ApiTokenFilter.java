package com.example.carbonfootprint.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiTokenFilter extends OncePerRequestFilter {

    @Value("${app.api-token}")
    private String apiToken;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        // Public endpoints (history, docs, health)
        if (path.contains("/swagger") || path.contains("/api-docs") || path.equals("/api/v1/history")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Check Authorization header
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.equals("Bearer " + apiToken)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized: Invalid or missing API token");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
