package com.example.Cricbuzz.controller;


import com.example.Cricbuzz.dto.request.PlayerRequest;
import com.example.Cricbuzz.dto.response.PlayerResponse;
import com.example.Cricbuzz.exception.PlayerNotFoundException;
import com.example.Cricbuzz.model.Enum.Gender;
import com.example.Cricbuzz.model.Enum.Speciality;
import com.example.Cricbuzz.model.Player;
import com.example.Cricbuzz.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {


    @Autowired
    PlayerService playerService;
    @PostMapping
    public PlayerResponse addPlayer(@RequestBody PlayerRequest playerRequest){
        return playerService.addPlayer(playerRequest);

    }

    @GetMapping("/getById/{id}")
    public PlayerResponse getPlayerById(@PathVariable int id){
//        try{
//            return playerService.getPlayerById(id);
//
//        }catch (PlayerNotFoundException p){
//            return p.getMessage();
//        }
        return playerService.getPlayerById(id);

    }

    //get all by Gender and age>= 35 -> need to return all players whose gender and age =>35
    @GetMapping("/gender/{gender}/age/{age}")
    public List<PlayerResponse> getByGenderAndAgeGreaterThan(@PathVariable Gender gender, @PathVariable int age){
        return playerService.getByGenderAndAgeGreaterThan(gender,age);
    }

    // get by gender and speciality -> need to return all players with same speciality and gender with custom query

    @GetMapping("/gender/{gender}/speciality/{speciality}")
    public List<PlayerResponse> getByGenderAndSpeciality(@PathVariable String gender, @PathVariable String speciality){
        return playerService.getByGenderAndSpeciality(gender,speciality);

    }

}
