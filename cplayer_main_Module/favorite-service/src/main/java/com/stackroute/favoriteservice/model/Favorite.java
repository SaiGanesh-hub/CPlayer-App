package com.stackroute.favoriteservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name="players")
public class Favorite {
    @NotBlank(message = "Username is mandatory")
    private String username;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;                                      //player id is stored as private
    @NotBlank(message = "Country is mandatory")
    private String country;                         //player country is stored as private
    private int player_id;               //Getting player id to be stored as private
    @NotBlank(message = "FullName is mandatory")
    private String fullName;                      //player full name is stored as private
    @NotBlank(message = "Batting Style is mandatory")
    private String battingstyle;              //player batting style is stored as private
    @NotBlank(message = "Balling Style is mandatory")
    private String ballingstyle;              //player balling style is stored as private
    @NotBlank(message = "DOB is mandatory")
    private String born;                      //player date of birth is stored as private
    @NotBlank(message = "Playing Role is mandatory")
    private String playingRole;                //player playing role is stored as private
    private String majorTeams;                   //player major team is stored as private
    private String imageURL;                      //player image url is stored as private
    private String t20_matchesplayed;       //player t20 match count is stored as private
    private String test_matchesplayed;     //player test match count is stored as private
    private String odi_matchesplayed;       //player odi match count is stored as private

    public Favorite(@NotBlank(message = "Username is mandatory") String username, @NotBlank(message = "Country is mandatory") String country, int player_id, @NotBlank(message = "FullName is mandatory") String fullName, @NotBlank(message = "Batting Style is mandatory") String battingstyle, @NotBlank(message = "Balling Style is mandatory") String ballingstyle, @NotBlank(message = "DOB is mandatory") String born, @NotBlank(message = "Playing Role is mandatory") String playingRole, String majorTeams, String imageURL, String t20_matchesplayed, String test_matchesplayed, String odi_matchesplayed) {
        this.username = username;
        this.country = country;
        this.player_id = player_id;
        this.fullName = fullName;
        this.battingstyle = battingstyle;
        this.ballingstyle = ballingstyle;
        this.born = born;
        this.playingRole = playingRole;
        this.majorTeams = majorTeams;
        this.imageURL = imageURL;
        this.t20_matchesplayed = t20_matchesplayed;
        this.test_matchesplayed = test_matchesplayed;
        this.odi_matchesplayed = odi_matchesplayed;
    }
}
