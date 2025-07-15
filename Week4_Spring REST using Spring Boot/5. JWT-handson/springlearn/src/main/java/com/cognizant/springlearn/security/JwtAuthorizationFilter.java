package com.cognizant.springlearn.security;

import io.jsonwebtoken.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.slf4j.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.*;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);
    private static final String SECRET_KEY = "secretkey";

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        LOGGER.info("JWT Filter Start");
        String header = request.getHeader("Authorization");
        LOGGER.debug("Header: {}", header);

        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null) {
            try {
                Jws<Claims> jws = Jwts.parser()
                        .setSigningKey(SECRET_KEY)
                        .parseClaimsJws(token.replace("Bearer ", ""));
                String user = jws.getBody().getSubject();

                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                }
            } catch (JwtException e) {
                LOGGER.error("Invalid JWT token: {}", e.getMessage());
            }
        }
        return null;
    }
}
