package com.AppDisney.AppDisney.Security;

import com.AppDisney.AppDisney.Exception.DisneyAppException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date actualDate = new Date();
        Date expirationDate = new Date(actualDate.getTime() + jwtExpirationInMs);

        String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

        return token;
    }

    public String getJwtUsername(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            throw new DisneyAppException(HttpStatus.BAD_REQUEST, "Firma JWT no valida");
        } catch (MalformedJwtException ex) {
            throw new DisneyAppException(HttpStatus.BAD_REQUEST, "Token JWT no valido");
        } catch (ExpiredJwtException ex) {
            throw new DisneyAppException(HttpStatus.BAD_REQUEST, "Token JWT caducado");
        } catch (UnsupportedJwtException ex) {
            throw new DisneyAppException(HttpStatus.BAD_REQUEST, "Token JWT no compatible");
        } catch (IllegalArgumentException ex) {
            throw new DisneyAppException(HttpStatus.BAD_REQUEST, "Cadena claims JWT esta vacia");
        }
    }
}
