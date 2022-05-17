package com.fullstr.FullStore.payload.response;

import java.util.List;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private int telephone;
    private String email;
    private List<String> roles;

    public JwtResponse(
            String accessToken,
            Long id, String name, String lastname, String username, int telephone, String email,
            List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.telephone = telephone;
        this.email = email;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

}
