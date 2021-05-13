package com.stackroute.UserAuthentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class jwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;

    private  String email;
    private String password;
}
