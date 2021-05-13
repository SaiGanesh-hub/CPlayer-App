package com.stackroute.favoriteservice.service;

import com.stackroute.favoriteservice.model.Favorite;

import java.util.List;

public interface FavoriteService {

    public List<Favorite> getAllFavorite(String username);

    public boolean addFavorite(Favorite favorite);

    public boolean removeFavorite(String username);

    public boolean removeUser(String username, int player_id);
}
