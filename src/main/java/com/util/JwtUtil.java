package com.util;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public interface JwtUtil {

    String generateToken(String subject, long validityInMillis);

    public boolean validateToken(String token);
}
