package com.stackroute.cricket_players.service;

import com.stackroute.cricket_players.model.CricketPlayer;
import com.stackroute.cricket_players.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceDAOTest {

    private List<CricketPlayer> playerList;
    @Mock
    private PlayerRepository playerRepository;
    @InjectMocks
    private PlayerServiceIMPL playerService;
    @Test
    public void givenDataThenShouldSaveToPlayer(){
        CricketPlayer cricketPlayer=new CricketPlayer(1,"India","Sachin Tendulkar",
                "Right-hand bat","Right-arm offbreak, Legbreak googly",
                "September 18, 1984, Gurgaon, Haryana","Batsman",
                "India,Asia XI,Mumbai,Mumbai Indians,Yorkshire","ImageURL","12","200","463");
        when(playerRepository.save(any())).thenReturn(cricketPlayer);
        playerService.savePlayer(cricketPlayer);
        verify(playerRepository,times(1)).save(any());
    }
    @Test
    void givenDeleteThenShouldReturnDeleted() {
        CricketPlayer cricketPlayer = new CricketPlayer(1,"India","Sachin Tendulkar",
                "Right-hand bat","Right-arm offbreak, Legbreak googly",
                "September 18, 1984, Gurgaon, Haryana","Batsman",
                "India,Asia XI,Mumbai,Mumbai Indians,Yorkshire","ImageURL","12","200","463");
        playerRepository.findById(cricketPlayer.getId());
        playerService.deletePlayer(1);
    }
}