package com.stackroute.Recommendationservice.service;

import com.stackroute.Recommendationservice.model.Recommendation;

import java.util.List;

public interface RecommendationService {
    public List<Recommendation> getAllRecommendation();

    public boolean saveToRecommendation(Recommendation recommendation);

    public boolean deleteRecommendation(int id);
}
