package com.stackroute.cricket_players.repository;

import com.stackroute.cricket_players.model.CricketPlayer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<CricketPlayer,Integer> {
}
