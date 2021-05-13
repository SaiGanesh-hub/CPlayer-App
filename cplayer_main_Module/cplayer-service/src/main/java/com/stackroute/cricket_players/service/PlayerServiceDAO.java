package com.stackroute.cricket_players.service;

import com.stackroute.cricket_players.model.CricketPlayer;

import java.util.List;

public interface PlayerServiceDAO {
    CricketPlayer savePlayer(CricketPlayer player);
    public List<CricketPlayer> getAllPlayer();
    public CricketPlayer updatePlayer(CricketPlayer player);
    public void deletePlayer(int id);
}
