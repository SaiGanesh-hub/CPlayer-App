package com.stackroute.Recommendationservice.contoller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.Recommendationservice.model.Recommendation;
import com.stackroute.Recommendationservice.service.RecommendationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class RecommendationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private RecommendationService recommendationService;
    private Recommendation recommendation;
    private List<Recommendation> list;
    @InjectMocks
    private RecommendationController recommendationController;
    @BeforeEach
    public void setUp() {
        recommendation=new Recommendation(1,"India","Sachin Tendulkar","Right-hand bat","Right-arm offbreak, Legbreak googly","September 18, 1984, Gurgaon, Haryana","Batsman","India,Asia XI,Mumbai,Mumbai Indians,Yorkshire","ImageURL",1,200,463,0);
        mockMvc= standaloneSetup(recommendationController).build();
    }
    //test case for adding recommendation
    @Test
    public void givenRecommendationToSaveThenShouldReturnSavedRecommendation() throws Exception {
        when(recommendationService.saveToRecommendation(any())).thenReturn(true);
        mockMvc.perform(post("/api/v1/recommendation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(recommendation)))
                .andExpect(status().isCreated());
        verify(recommendationService,times(1)).saveToRecommendation(any());
    }
    //test case for deleting recommendation
    @Test
    public void givenGetAllRecommendationThenShouldReturnListOfAllRecommendations() throws Exception {
        when(recommendationService.getAllRecommendation()).thenReturn(list);
        mockMvc.perform(get("/api/v1/recommendations").contentType(MediaType.APPLICATION_JSON).content(asJsonString(recommendation)))
                .andExpect(status().isOk());
        verify(recommendationService).getAllRecommendation();
        verify(recommendationService, times(1)).getAllRecommendation();
    }
//    @Test
//    public void givenRecommendationIdToDeleteThenShouldNotReturnDeletedRecommendation() throws Exception{
//        //verify(soulmateServiceDAO).deleteSoulmate(1);
//        mockMvc.perform(delete("/api/v1/recommendation/1").contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(recommendation))).andExpect(status().isOk());
//
//        verify(recommendationService, times(1)).deleteRecommendation(recommendation.getId());
//    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}