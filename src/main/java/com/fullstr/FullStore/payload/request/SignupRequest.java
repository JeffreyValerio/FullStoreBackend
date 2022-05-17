package com.fullstr.FullStore.payload.request;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

    private String name;
    private String lastname;
    private String username;
    private int telephone;
    private String email;
    private String password;
    private Set<String> role;
}
