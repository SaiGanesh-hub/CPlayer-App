package com.stackroute.cricket_players.service;

import com.stackroute.cricket_players.model.CricketPlayer;
import com.stackroute.cricket_players.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceIMPL implements  PlayerServiceDAO{
    private PlayerRepository repository;
    //   AUTOWIRING THE CONSTRUCTOR
    @Autowired
    public PlayerServiceIMPL(PlayerRepository repository) {
        this.repository = repository;
    }


    //    IMPLEMENTING THE METHODS

    @Override
    public CricketPlayer savePlayer(CricketPlayer player) {
        return  repository.save(player);
    }

    @Override
    public List<CricketPlayer> getAllPlayer() {
        return repository.findAll();
    }

    @Override
    public CricketPlayer updatePlayer(CricketPlayer player) {
        return repository.save(player);
    }

    @Override
    public void deletePlayer(int id) {
        repository.deleteById(id);

    }
}
