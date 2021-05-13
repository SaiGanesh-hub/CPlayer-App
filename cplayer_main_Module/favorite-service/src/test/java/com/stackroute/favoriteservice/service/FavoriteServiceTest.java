package com.stackroute.favoriteservice.service;

import com.stackroute.favoriteservice.model.Favorite;
import com.stackroute.favoriteservice.repository.FavoriteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FavoriteServiceTest {

    private List<Favorite> playerList;
    @Mock
    private FavoriteRepository favoriteRepository;
    @InjectMocks
    private FavoriteServiceImpl favoriteService;

    @Test
    public void givenFavoriteThenShouldSaveFavorite() {
        Favorite cricketPlayer = new Favorite("DEEPAK", "India", 3, "Sachin Tendulkar",
                "Right-hand bat", "Right-arm offbreak, Legbreak googly",
                "September 18, 1984, Gurgaon, Haryana", "Batsman",
                "India,Asia XI,Mumbai,Mumbai Indians,Yorkshire", "ImageURL", "12", "200", "463");
        when(favoriteRepository.save(any())).thenReturn(cricketPlayer);
        favoriteService.addFavorite(cricketPlayer);
        verify(favoriteRepository, times(1)).save(any());
    }

    @Test
    void givenDeleteThenShouldReturnFavorite() {
        Favorite cricketPlayer = new Favorite("DEEPAK", "India", 3, "Sachin Tendulkar",
                "Right-hand bat", "Right-arm offbreak, Legbreak googly",
                "September 18, 1984, Gurgaon, Haryana", "Batsman",
                "India,Asia XI,Mumbai,Mumbai Indians,Yorkshire", "ImageURL", "12", "200", "463");
        favoriteRepository.findById(cricketPlayer.getId());
        favoriteService.removeFavorite("1");
    }
}