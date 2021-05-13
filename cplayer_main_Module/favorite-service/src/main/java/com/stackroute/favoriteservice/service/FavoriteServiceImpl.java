package com.stackroute.favoriteservice.service;


import com.stackroute.favoriteservice.model.Favorite;
import com.stackroute.favoriteservice.repository.FavoriteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FavoriteServiceImpl implements FavoriteService{
    @Autowired
    private FavoriteRepository repository;

    @Override
    public List<Favorite> getAllFavorite(String username) {
        return (List<Favorite>) repository.findByUsername(username);
    }
    //adding to favorite based on username
    @Override
    public boolean addFavorite(Favorite favorite) {
        try {
            int id = favorite.getPlayer_id() ;
            String usernamenew = favorite.getUsername();
            List<Favorite> list = (List<Favorite>) repository.findAll();
            for (Favorite temp : list) {
                if((temp.getPlayer_id() == id) && (temp.getUsername().equalsIgnoreCase(usernamenew))) {
                    return true;
                }
            }
            repository.save(favorite);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Removing all favorites of username
    @Override
    public boolean removeFavorite(String username) {
        try {
            List<Favorite> list = repository.findByUsername(username);
            for (Favorite temp : list) {
                repository.deleteById(temp.getId());
            }
            return true;
        } catch (Exception e) {
            System.out.println("no");
            return false;
        }
    }

    //Removing favorites based on player_id
    @Override
    public boolean removeUser(String username, int player_id) {
        try {
            List<Favorite> list = repository.findByUsername(username);
            for(Favorite temp : list ) {
                if(temp.getPlayer_id() == player_id) {
                    repository.deleteById(temp.getId());
                    return true;
                }
            }
            return false;
        }catch (Exception e) {
            return false;
        }
    }

}
