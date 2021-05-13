package com.stackroute.Recommendationservice.contoller;

import com.stackroute.Recommendationservice.model.Recommendation;
import com.stackroute.Recommendationservice.service.RecommendationService;
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

//@RestController is used as a request handler.
@RestController
//RequestMapping is used to map to path /api/v1
@RequestMapping("/api/v1")
//Cross origin is used work in all origin
@CrossOrigin(value = "*")
@Validated
public class RecommendationController {
    @Autowired
    //Autowire the service
    private RecommendationService service;
    //localhost:8083/api/v1/recommendation -get
    @GetMapping("/recommendations")
    public ResponseEntity<?> getAllRecommendation() {
        try {
            return new ResponseEntity<List<Recommendation>>(service.getAllRecommendation(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Request Not accepted", HttpStatus.CONFLICT);
        }
    }
    //localhost:8083/api/v1/recommendation -post
    @PostMapping("/recommendation")
    public ResponseEntity<String> saveToRecommendation(@Valid @RequestBody Recommendation recommendation) {
        try {
            if (service.saveToRecommendation(recommendation)) {
                return new ResponseEntity<String>("Recommendation Added Successfully", HttpStatus.CREATED);
            } else
                return new ResponseEntity<String>("Recommendation Not Added ", HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error", HttpStatus.NOT_FOUND);
        }
    }
    //localhost:8083/api/v1/recommendation/id -delete
    @DeleteMapping("/recommendation/{id}")
    public ResponseEntity<String> deleteRecommendation(@PathVariable int id) {
        try {
            if (service.deleteRecommendation(id)) {
                return new ResponseEntity<String>("Recommendation Deleted Successfully", HttpStatus.OK);
            } else
                return new ResponseEntity<String>("Recommendation Not Deleted", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error", HttpStatus.NOT_FOUND);

        }
    }
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
