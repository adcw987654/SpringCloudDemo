package com.ray.springcloud.utils;

import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.gson.io.GsonSerializer;

import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.security.Key;


public class JwtTokenUtils {

    private static final Long EXPIRATIONTIME = 432_000_000L;

    public static String generateToken(String username, String keyStr) throws NoSuchAlgorithmException {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", username);
        SecretKeySpec key = new SecretKeySpec(base64Decode(keyStr), "HmacSHA256");
        return Jwts.builder()
                .addClaims(claims)
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .serializeToJsonWith(new GsonSerializer<>(new Gson()))
                .signWith(key).compact();
    }

    public static String getTokenInfo(String token, String keyStr) {
        SecretKeySpec key = new SecretKeySpec(base64Decode(keyStr), "HS256");
        JwtParser parser = Jwts.parserBuilder().setSigningKey(key).build();
        Claims claims = parser
                .parseClaimsJws(token)
                .getBody();
        return (String) claims.get("userName");
    }

    private static byte[] base64Decode(String key){
        return Base64.getDecoder().decode(key);
    }


}
