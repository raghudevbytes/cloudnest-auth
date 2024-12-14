package com.cloudnest.auth.providers;

import com.cloudnest.util.helper.KeyLoaderUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTokenProvider {

    public String generateToken(String username) {
        return Jwts.builder().claims()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()*1000*60))
                .and()
                .signWith(KeyLoaderUtil.loadSecretKey("aes"),Jwts.SIG.HS256)
                .compact();
    }
}
