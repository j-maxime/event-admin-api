package com.util;


import com.util.impl.JwtUtilImpl;
import com.util.JwtUtil;
import java.util.HashMap;
import java.util.Map;

public interface JwtTokenManager {
    static  Map<String, JwtUtil> tokens = new HashMap<>();
    static String generateToken(String subject, long validityInMillis) {
        JwtUtil jwtUtil = new JwtUtilImpl();
        String token = jwtUtil.generateToken(subject, validityInMillis);
        tokens.put(token, jwtUtil);
        return token;
    }

    static boolean validateToken(String token) {
        try {
            if (!tokens.containsKey(token)) {
                return false;
            }
            boolean valid = tokens.get(token).validateToken(token);
            if (!valid) {
                tokens.remove(token);
            }
            return valid;
        } catch (Exception e) {
            return false;
        }
    }
}
