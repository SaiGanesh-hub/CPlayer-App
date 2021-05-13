package com.stackroute.UserAuthentication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class userDto {
    @NotNull
    private String email;
    private String password;
}
