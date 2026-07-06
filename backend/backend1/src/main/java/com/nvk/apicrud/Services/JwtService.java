package com.nvk.apicrud.Services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtService {
    public static long timeExpireMilisecond = 60 * 1000; //60 phut
    public static SecretKey secretKey = Keys.hmacShaKeyFor("Ijet22lj6BhJJN9Zc7xxk0ZINJf55GLYBTOKhau2ved".getBytes());
    public static String generateToken(String username, String role){
        return Jwts.builder()
                .subject(username)
                .claim("role", role)
                .issuedAt(new Date()) //Thoi diem tao token
                .expiration(new Date(System.currentTimeMillis() + timeExpireMilisecond)) //ngay het han
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
