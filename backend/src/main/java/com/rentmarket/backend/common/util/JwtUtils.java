//package com.rentmarket.backend.common.util;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//public class JwtUtils {
//
//
//    private static final String SECRET_KEY = "SpringBootJWTHelperTokenSecretKeyValue123!@#";
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .claim("username", username)
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//}
