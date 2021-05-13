package com.stackroute.favoriteservice.controller;

import com.stackroute.favoriteservice.model.Favorite;
import com.stackroute.favoriteservice.service.FavoriteServiceImpl;
import lombok.AllArgsConstructor;
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

@AllArgsConstructor
@RestController                 //Takes care of mapping request data to the defined request handler method.
@RequestMapping("/api/v1")     //maps HTTP requests to handler methods of MVC and REST controllers.
@CrossOrigin(value = "*")
@Validated
public class FavoriteController {
    @Autowired
    private FavoriteServiceImpl favouritesService;
    @GetMapping("players")  //GET requests onto specific handler methods.
    public ResponseEntity<?> getAllPlayers(@RequestParam("username") String username) {
        try {
            return new ResponseEntity<List<Favorite>>(favouritesService.getAllFavorite(username),HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<String>("Error",HttpStatus.CONFLICT);
        }
    }
    @PostMapping("player")        //POST requests matched with given URL expression
    public ResponseEntity<?> addData(@Valid @RequestBody Favorite favorite) {
        if(favouritesService.addFavorite(favorite)) {
            return new ResponseEntity<String>("Favorite Added Successfully", HttpStatus.CREATED);
        }
        else return new ResponseEntity<String>("Error", HttpStatus.CONFLICT);
    }
    @DeleteMapping("player")             // maps  HTTP DELETE requests onto specific handler methods
    public ResponseEntity<String> removeFavorite(@RequestParam("username") String username){
        favouritesService.removeFavorite(username);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @DeleteMapping("player/{id}")      // maps  HTTP DELETE requests onto specific handler methods
    public ResponseEntity<String> deleteData( @RequestBody Map<String, String> json){
        favouritesService.removeUser(json.get("username"), Integer.parseInt(json.get("id")));
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    //for exception handling in validations
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
