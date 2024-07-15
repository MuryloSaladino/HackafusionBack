package com.greenteam.schoolmanager.filters;

import com.greenteam.schoolmanager.enums.UserRole;
import com.greenteam.schoolmanager.interfaces.JwtTokenManager;
import com.greenteam.schoolmanager.sessions.UserSession;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ValidateTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenManager jwtTokenManager;

    @Autowired
    private UserSession userSession;

    @Override
    public void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if(token != null) {
            try {
                token = token.replace("Bearer ", "");
                Claims claims = jwtTokenManager.extractClaims(token);

                userSession.setId(Long.parseLong(claims.getId()));
                userSession.setUserRole( UserRole.integerToRole( claims.get("role", Integer.class) ) );
            }
            catch (RuntimeException e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            }
        }

        filterChain.doFilter(request, response);
    }
}
