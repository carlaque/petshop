package com.fatec.petshop.demo.utils;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

    private static final String SECRET_KEY = "LAB ENG DE SW 1/2021";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hora


    

    public static String generateToken(String usuario) {
        return Jwts.builder()
                .setSubject(usuario)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public static String getAuthentication(String token) {
        String user = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return user;
    }
}

