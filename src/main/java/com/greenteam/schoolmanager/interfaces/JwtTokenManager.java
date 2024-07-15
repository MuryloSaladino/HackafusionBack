package com.greenteam.schoolmanager.interfaces;

import io.jsonwebtoken.Claims;

import java.util.Map;

public interface JwtTokenManager {
    Claims extractClaims(String token);
    String buildToken(Map<String, Object> claims, String subject, Long id);
}
