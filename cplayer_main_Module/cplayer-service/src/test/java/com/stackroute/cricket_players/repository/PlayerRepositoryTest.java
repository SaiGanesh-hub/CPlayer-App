package com.stackroute.cricket_players.repository;


import com.stackroute.cricket_players.model.CricketPlayer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class PlayerRepositoryTest {
    @Autowired
    private PlayerRepository repository;
    @Test
    public void givenDataToShouldSavePlayer(){
        CricketPlayer cricketPlayer=new CricketPlayer(1,"India","Sachin Tendulkar",
                "Right-hand bat","Right-arm offbreak, Legbreak googly",
                "September 18, 1984, Gurgaon, Haryana","Batsman",
                "India,Asia XI,Mumbai,Mumbai Indians,Yorkshire","ImageURL","12","200","463");
        repository.save(cricketPlayer);
        CricketPlayer cricketPlayer1=repository.findById(cricketPlayer.getId()).get();
        assertEquals("Sachin Tendulkar",cricketPlayer1.getFullName());
    }



}