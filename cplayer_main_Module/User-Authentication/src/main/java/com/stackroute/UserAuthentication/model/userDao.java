package com.stackroute.UserAuthentication.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cplayer_Users")
public class userDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "FirstName is mandatory")
    private String firstName;
    @NotBlank(message = "LastName is mandatory")
    private String lastName;
    @NotNull
    @Min(18)
    @Max(150)
    private int age;


    @Column(name = "email", unique = true)
    @Email
    @NotNull(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    @NotEmpty

    private String email;

    @NotBlank
    //@Size(min = 5,max = 15)
    private String password;
    @NotBlank
    //@Size(min = 10,max = 15)
    private String phoneNo;

}
