package com.fullstr.FullStore.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String name;
    private String email;
    private String password;
}
