package com.stackroute.cricket_players.controller;

import com.stackroute.cricket_players.model.CricketPlayer;
import com.stackroute.cricket_players.service.PlayerServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@Validated
public class PlayerController {

    private PlayerServiceDAO service;
    @Autowired

    public PlayerController(PlayerServiceDAO service) {
        this.service = service;
    }
    //    TO ADD NEW PLAYER
    @PostMapping("player")
    public ResponseEntity<CricketPlayer> savePlayer(@Valid @RequestBody CricketPlayer player){
        return new ResponseEntity<CricketPlayer>(service.savePlayer(player), HttpStatus.CREATED);
    }
    //    TO GET ALL PLAYERS
    @GetMapping("players")
    public List<CricketPlayer> getAllPlayers(){
        return service.getAllPlayer();
    }
    //        TO DELETE PLAYER by ID
    @DeleteMapping("player/{id}")
    public void deletePlayerById(@PathVariable int id){
        service.deletePlayer(id);
    }
    //    TO UPDATE PLAYER
    @PutMapping("player")
    public ResponseEntity<CricketPlayer> updatePlayer(@RequestBody CricketPlayer player){
        return new ResponseEntity<CricketPlayer>(service.updatePlayer(player),HttpStatus.OK);
    }
    //FOR HANDLING EXCEPTION
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
