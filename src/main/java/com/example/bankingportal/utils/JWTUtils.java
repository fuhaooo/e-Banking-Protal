package com.example.bankingportal.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * JWTUtils
 * JWT工具类
 *
 * @author fuhao
 * @date 2022/5/22
 */
public class JWTUtils {

    /**
     * 创建JWT
     * @param id        唯一ID
     * @param subject   主题
     * @param ttlMillis 过期时间
     * @param secretKey 密钥
     * @return
     */
    public static String createJWT(String id, String subject, Long ttlMillis, SecretKey secretKey){
        //指定签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //获取当前系统时间
        long nowMillis = System.currentTimeMillis();
        //token签发时间
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuer("user")
                .setIssuedAt(now)
                .signWith(secretKey,signatureAlgorithm);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            //设置token过期时间
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }

    /**
     * 解析JWT
     * @param jwt
     * @param keySpec
     * @return
     */
    public static Claims parseJWT(String jwt,SecretKey keySpec){
        return Jwts.parser()
                .setSigningKey(keySpec)
                .parseClaimsJws(jwt)
                .getBody();
    }

    /**
     * 校验token是否正确
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }


    public static void main(String[] args) {
        //生成密匙
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jwt = JWTUtils.createJWT("1","test", 10000L,key);
        System.out.println(jwt);
        System.out.println(JWTUtils.parseJWT(jwt,key));
    }



}
