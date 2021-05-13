package com.stackroute.UserAuthentication.model;

import lombok.Getter;

import java.io.Serializable;
@Getter
public class jwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwttoken;

    public jwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
}
