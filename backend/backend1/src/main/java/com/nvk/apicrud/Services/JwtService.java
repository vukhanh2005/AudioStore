package com.nvk.apicrud.Services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtService {
    public static SecretKey secretKey = Keys.hmacShaKeyFor("NguyenVuKhanh24112005".getBytes());
    public static String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .claim("role", "role-admin")
                .issuedAt(new Date()) //Thoi diem tao token
                .expiration(new Date(System.currentTimeMillis() + 3600000)) //ngay het han
                .signWith(secretKey)
                .compact();
    }
    public static Claims readToken(String token){
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
