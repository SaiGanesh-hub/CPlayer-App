package com.stackroute.cricket_players.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.cricket_players.model.CricketPlayer;
import com.stackroute.cricket_players.service.PlayerServiceDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class PlayerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private PlayerServiceDAO playerServiceDAO;
    private CricketPlayer cricketPlayer;
    private List<CricketPlayer> list;
    @InjectMocks
    private PlayerController playerController;
    @BeforeEach
    public void setUp() {
        cricketPlayer=new CricketPlayer(1,"India","Sachin Tendulkar",
                "Right-hand bat","Right-arm offbreak, Legbreak googly",
                "September 18, 1984, Gurgaon, Haryana","Batsman",
                "India,Asia XI,Mumbai,Mumbai Indians,Yorkshire","ImageURL","12","200","463");
        mockMvc= standaloneSetup(playerController).build();
    }

    //    test case for adding Player
    @Test
    public void givenDataToSaveThenShouldReturnSavedPlayer() throws Exception {
        when(playerServiceDAO.savePlayer(any())).thenReturn(cricketPlayer);
        mockMvc.perform(post("/api/v1/player")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(cricketPlayer)))
                .andExpect(status().isCreated());
        verify(playerServiceDAO,times(1)).savePlayer(any());
    }


    @Test
    void givenGetAllPlayersThenShouldReturnListOfAllPlayers() throws Exception {
        when(playerServiceDAO.getAllPlayer()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/players")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(cricketPlayer)))
                .andDo(MockMvcResultHandlers.print());
        verify(playerServiceDAO).getAllPlayer();
        verify(playerServiceDAO, times(1)).getAllPlayer();

    }

//    @Test
//    void givenBlogIdToPlayerThenShouldReturnDeletedPlayer() throws Exception {
//        when(playerServiceDAO.deletePlayer(cricketPlayer.getId())).thenReturn(cricketPlayer);
//        mockMvc.perform(delete("/api/v1/player/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(cricketPlayer)))
//                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
//    }

    @Test
    public void givenPlayerToUpdateThenShouldReturnUpdatedPlayer() throws Exception {
        when(playerServiceDAO.updatePlayer(any())).thenReturn(cricketPlayer);
        mockMvc.perform(put("/api/v1/player").contentType(MediaType.APPLICATION_JSON).content(asJsonString(cricketPlayer)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}