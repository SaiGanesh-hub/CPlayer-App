package com.stackroute.favoriteservice.repository;

import com.stackroute.favoriteservice.model.Favorite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends CrudRepository<Favorite,Integer> {
    @Query("select f from Favorite f where f.username= ?1")
    List<Favorite> findByUsername(String username);
}
