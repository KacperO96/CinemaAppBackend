package com.cinemaapp.backend.security;

import org.springframework.beans.factory.annotation.Value;

public class JwtConfig {

    @Value("Authorization")
    private String header;

    @Value("Bearer")
    private String prefix;

    @Value("#{24*60*60}")
    private int expiration;

    @Value("JwtSecretKey")
    private String secret;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
