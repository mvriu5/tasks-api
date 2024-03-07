package de.noque.taskapi.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    public String generateToken(String email) {
        Instant now = Instant.now();
        Instant expiration = now.plus(7, ChronoUnit.DAYS);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(expiration))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return generateToken(user.getUsername());
    }

    public String getEmailFromToken(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJwt(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
