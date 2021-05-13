package com.stackroute.Recommendationservice.service;
import com.stackroute.Recommendationservice.model.Recommendation;
import com.stackroute.Recommendationservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//service implementation class
@Service
public class RecommendationServiceImpl implements RecommendationService{
    // Repository Autowired to get injected and use the crud methods.
    private RecommendationRepository repository;
    @Autowired
    public RecommendationServiceImpl(RecommendationRepository repository) {
        this.repository = repository;
    }
    //service for getting all recommendations
    @Override
    public List<Recommendation> getAllRecommendation() {
        List<Recommendation> recommendation_list = repository.findAll();
        recommendation_list.removeIf(e -> (e.getCounter() < 1));
        return recommendation_list;
    }
    //service for adding data to recommendation list by using counter
    @Override
    public boolean saveToRecommendation(Recommendation recommendation) {
        int id = recommendation.getId();
        // list for getting all data from DB
        List<Recommendation> addRecommendationList = repository.findAll();
        //iterating through recommendation list in db
        for (Recommendation item : addRecommendationList) {
            //check if the player is already in the list
            if (item.getId()== id) {
                // counter for incrementing the count
                int counter = repository.findById(id).get().getCounter();
                repository.deleteById(id);
                //if the recommended player is in the list then increment the counter
                recommendation.setCounter(counter + 1);
                //save it to DB
                repository.save(recommendation);
                return true;
            }
        }
        //set counter to 1
        recommendation.setCounter(1);
        repository.save(recommendation);
        return true;
    }
    //service for deleting data from recommendation list
    @Override
    public boolean deleteRecommendation(int id) {
        //deleteList used to store all the data from db
        List<Recommendation> deleteList = repository.findAll();
        //iterating through the list to check if item to delete from recommendation is present
        for (Recommendation item : deleteList) {
            //check if player id matches
            if (item.getId() == id) {
                //if id matches save data of that id to recommendation object
                Recommendation recommendation = repository.findById(id).get();
                repository.deleteById(id);
                //decrement the counter by 1 if a person delete the id
                recommendation.setCounter(recommendation.getCounter() - 1);
                repository.save(recommendation);
            }
            //if the count of recommendation reaches zero delete item from db
            if(item.getCounter()==0){
                repository.deleteById(id);
            }
        }
        return true;
    }
}
