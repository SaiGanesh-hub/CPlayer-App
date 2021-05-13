package com.stackroute.Recommendationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Document(collection = "cplayers_recommendation")
public class Recommendation {
//    Data of Cricket players
    @Id
    @NotNull(message = "Id must Not be null")
    private int id;

    @NotNull
    @NotBlank(message = "Country is mandatory")
    private String country;

    @NotNull
    @NotBlank(message="Name is mandatory")
    private String fullName;

    @NotNull
    @NotBlank(message="Batting Style is mandatory")
    private String battingStyle;

    @NotNull
    @NotBlank(message="Bowling Style is mandatory")
    private String bowlingStyle;

    @NotNull
    @NotBlank(message="Born  is mandatory")
    private String born;

    @NotNull
    @NotBlank(message="Playing Role  is mandatory")
    private String playingRole;

    @NotNull
    @NotBlank(message="Major Teams  is mandatory")
    private String majorTeams;
    @NotNull
    @NotBlank(message="imageURL  is mandatory")
    private String imageURL;

    @NotNull
    private int t20_matchesplayed;

    @NotNull
    private int test_matchesplayed;

    @NotNull
    private int odi_matchesplayed;

    private int counter;

}
