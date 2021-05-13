package com.stackroute.Recommendationservice.repository;


import com.stackroute.Recommendationservice.model.Recommendation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class RecommendationRepositoryTest {
    @Autowired
    private RecommendationRepository recommendationRepository;
    @Test
    public void givenRecommendationToShouldSaveRecommendation(){
        Recommendation recommendation=new Recommendation(1,"India","Sachin Tendulkar","Right-hand bat","Right-arm offbreak, Legbreak googly","September 18, 1984, Gurgaon, Haryana","Batsman","India,Asia XI,Mumbai,Mumbai Indians,Yorkshire","ImageURL",1,200,463,0);
        recommendationRepository.save(recommendation);
        Recommendation recommendation1=recommendationRepository.findById(recommendation.getId()).get();
        assertNotNull(recommendation1);
        assertEquals("Sachin Tendulkar",recommendation1.getFullName());
    }
    @Test
    public void givenGetAllRecommendationShouldReturnListOfAllRecommendation(){
        Recommendation recommendation=new Recommendation(1,"India","Sachin Tendulkar","Right-hand bat","Right-arm offbreak, Legbreak googly","September 18, 1984, Gurgaon, Haryana","Batsman","India,Asia XI,Mumbai,Mumbai Indians,Yorkshire","ImageURL",1,200,463,0);
        Recommendation recommendation1=new Recommendation(2,"India","Sachin Tendulkar","Right-hand bat","Right-arm offbreak, Legbreak googly","September 18, 1984, Gurgaon, Haryana","Batsman","India,Asia XI,Mumbai,Mumbai Indians,Yorkshire","ImageURL",1,200,463,0);
        recommendationRepository.save(recommendation);
        recommendationRepository.save(recommendation1);
        List<Recommendation> list= (List<Recommendation>) recommendationRepository.findAll();
        assertEquals(recommendation1.getId(),list.get(1).getId());


    }

}