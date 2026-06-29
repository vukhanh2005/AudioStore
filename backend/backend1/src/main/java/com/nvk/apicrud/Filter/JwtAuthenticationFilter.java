package com.nvk.apicrud.Filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    public SecretKey secretKey = Keys.hmacShaKeyFor(
            "a88751eae73bac5768b531cea1033b9c0ef633f00b8799936ed69022c3e4c361".getBytes(StandardCharsets.UTF_8)
    );
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request, response);
    }

    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .claim("role", "role-admin")
                .issuedAt(new Date()) //Thoi diem tao token
                .expiration(new Date(System.currentTimeMillis() + 3600000)) //ngay het han
                .signWith(secretKey)
                .compact();
    }
    public Claims readToken(String token){
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
