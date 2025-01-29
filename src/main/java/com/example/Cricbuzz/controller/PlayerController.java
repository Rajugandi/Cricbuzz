package com.example.Cricbuzz.controller;


import com.example.Cricbuzz.dto.request.PlayerRequest;
import com.example.Cricbuzz.dto.response.PlayerResponse;
import com.example.Cricbuzz.exception.PlayerNotFoundException;
import com.example.Cricbuzz.model.Enum.Gender;
import com.example.Cricbuzz.model.Enum.Speciality;
import com.example.Cricbuzz.model.Player;
import com.example.Cricbuzz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {


    @Autowired
    PlayerService playerService;
    @PostMapping
    public ResponseEntity<PlayerResponse> addPlayer(@RequestBody PlayerRequest playerRequest){
        return new ResponseEntity<>( playerService.addPlayer(playerRequest), HttpStatus.CREATED);

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity getPlayerById(@PathVariable int id){
        try{
            return new ResponseEntity<>( playerService.getPlayerById(id),HttpStatus.OK);
        }catch (PlayerNotFoundException p){
            return new ResponseEntity<>(p.getMessage(),HttpStatus.BAD_REQUEST);
        }
//        return playerService.getPlayerById(id);

    }

    //get all by Gender and age>= 35 -> need to return all players whose gender and age =>35
    @GetMapping("/gender/{gender}/age/{age}")
    public List<PlayerResponse> getByGenderAndAgeGreaterThan(@PathVariable Gender gender, @PathVariable int age){
        return playerService.getByGenderAndAgeGreaterThan(gender,age);
    }

    // get by gender and speciality -> need to return all players with same speciality and gender with custom query

    @GetMapping("/gender/{gender}/speciality/{speciality}")
    public List<PlayerResponse> getByGenderAndSpeciality(@PathVariable Gender gender, @PathVariable Speciality speciality){
        return playerService.getByGenderAndSpeciality(gender,speciality);

    }

}
