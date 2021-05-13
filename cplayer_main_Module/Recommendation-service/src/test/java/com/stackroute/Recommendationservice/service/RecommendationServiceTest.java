package com.stackroute.Recommendationservice.service;

import com.stackroute.Recommendationservice.model.Recommendation;
import com.stackroute.Recommendationservice.repository.RecommendationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
//Test Case for Recommendation Service
@ExtendWith(MockitoExtension.class)
class RecommendationServiceTest {
    private List<Recommendation> recommendationList;
    @Mock
    private RecommendationRepository recommendationRepository;
    @InjectMocks
    private RecommendationServiceImpl recommendationService;
    @Test
    public void givenRecommendationThenShouldSaveToRecommendation(){
        Recommendation recommendation=new Recommendation(1,"India","Sachin Tendulkar","Right-hand bat","Right-arm offbreak, Legbreak googly","September 18, 1984, Gurgaon, Haryana","Batsman","India,Asia XI,Mumbai,Mumbai Indians,Yorkshire","ImageURL",1,200,463,0);
        when(recommendationRepository.save(any())).thenReturn(recommendation);
        recommendationService.saveToRecommendation(recommendation);
        verify(recommendationRepository,times(1)).save(any());
    }
    @Test
    void givenDeleteThenShouldReturnDeleted() {
        Recommendation recommendation=new Recommendation(1,"India","Sachin Tendulkar","Right-hand bat","Right-arm offbreak, Legbreak googly","September 18, 1984, Gurgaon, Haryana","Batsman","India,Asia XI,Mumbai,Mumbai Indians,Yorkshire","ImageURL",1,200,463,0);
        recommendationRepository.findById(recommendation.getId());
        recommendationService.deleteRecommendation(1);

    }

}