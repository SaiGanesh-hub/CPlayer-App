package com.stackroute.Recommendationservice.repository;

import com.stackroute.Recommendationservice.model.Recommendation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//Recommendation Repository using Mongo Repository
@Repository
public interface RecommendationRepository extends MongoRepository<Recommendation,Integer> {
}
