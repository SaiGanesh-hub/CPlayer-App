package com.stackroute.favoriteservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.favoriteservice.model.Favorite;
import com.stackroute.favoriteservice.service.FavoriteService;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class FavoriteControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private FavoriteService service;
    private Favorite favorite;
    private List<Favorite> list;
    @InjectMocks
    private FavoriteController favoriteController;
    @BeforeEach
    public void setUp() {
        favorite=new Favorite("DEEPAK","India",3,"Sachin Tendulkar",
                "Right-hand bat","Right-arm offbreak, Legbreak googly",
                "September 18, 1984, Gurgaon, Haryana","Batsman",
                "India,Asia XI,Mumbai,Mumbai Indians,Yorkshire","ImageURL","12","200","463");
        mockMvc= standaloneSetup(favoriteController).build();
    }

    //    test case for adding favorite
//    @Test
//    void givenGetAllFavoriteThenShouldReturnListOfAllFavorite() throws Exception {
//        when(service.getAllFavorite(any())).thenReturn(list);
//        mockMvc.perform(get("/api/v1/players")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(favorite)))
//                .andDo(MockMvcResultHandlers.print());
//        verify(service).getAllFavorite(any());
//        verify(service, times(1)).getAllFavorite(any());
//
//    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}