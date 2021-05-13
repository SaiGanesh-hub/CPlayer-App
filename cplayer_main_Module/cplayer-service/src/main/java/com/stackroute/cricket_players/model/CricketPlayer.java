package com.stackroute.cricket_players.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "cplayers")
public class CricketPlayer {
    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    //    player id is stored as private
    @NotNull
    private int id;
    //    player country is stored as private
    @NotBlank(message = "Country is mandatory")
    private String country;

    //    player full name is stored as private
    @NotBlank(message = "FullName is mandatory")
    private String fullName;

    //    player batting style is stored as private
    @NotBlank(message = "Batting Style is mandatory")
    private String battingstyle;

    //    player balling style is stored as private
    @NotBlank(message = "Balling Style is mandatory")
    private String ballingstyle;

    //    player date of birth is stored as private
    @NotBlank(message = "DOB is mandatory")
    private String born;

    //    player playing role is stored as private
    @NotBlank(message = "Playing Role is mandatory")
    private String playingRole;

    //    player major team is stored as private
    @NotBlank(message = "Major Teams is mandatory")
    private String majorTeams;

    //    player image url is stored as private
    @NotBlank(message = "imageURL is mandatory")
    private String imageURL;

    //    player t20 match count is stored as private
    @NotNull
    private String t20_matchesplayed;

    //    player test match count is stored as private
    @NotNull
    private String test_matchesplayed;

    //    player odi match count is stored as private
    @NotNull
    private String odi_matchesplayed;



//    GENERATING EMPTY CONSTRUCTOR
    public CricketPlayer() {

    }

//    GENERATING PARAMETRIZED CONSTRUCTOR

    public CricketPlayer(int id, String country, String fullName, String battingstyle, String ballingstyle, String born, String playingRole, String majorTeams, String imageURL, String t20_matchesplayed, String test_matchesplayed, String odi_matchesplayed) {
        this.id = id;
        this.country = country;
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


//    CREATING GETTER AND SETTER


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBattingstyle() {
        return battingstyle;
    }

    public void setBattingstyle(String battingstyle) {
        this.battingstyle = battingstyle;
    }

    public String getBallingstyle() {
        return ballingstyle;
    }

    public void setBallingstyle(String ballingstyle) {
        this.ballingstyle = ballingstyle;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getPlayingRole() {
        return playingRole;
    }

    public void setPlayingRole(String playingRole) {
        this.playingRole = playingRole;
    }

    public String getMajorTeams() {
        return majorTeams;
    }

    public void setMajorTeams(String majorTeams) {
        this.majorTeams = majorTeams;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getT20_matchesplayed() {
        return t20_matchesplayed;
    }

    public void setT20_matchesplayed(String t20_matchesplayed) {
        this.t20_matchesplayed = t20_matchesplayed;
    }

    public String getTest_matchesplayed() {
        return test_matchesplayed;
    }

    public void setTest_matchesplayed(String test_matchesplayed) {
        this.test_matchesplayed = test_matchesplayed;
    }

    public String getOdi_matchesplayed() {
        return odi_matchesplayed;
    }

    public void setOdi_matchesplayed(String odi_matchesplayed) {
        this.odi_matchesplayed = odi_matchesplayed;
    }
}

