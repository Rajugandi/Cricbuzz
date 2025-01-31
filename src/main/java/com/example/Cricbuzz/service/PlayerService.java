package com.example.Cricbuzz.service;


import com.example.Cricbuzz.convertor.PlayerConvertor;
import com.example.Cricbuzz.dto.request.PlayerRequest;
import com.example.Cricbuzz.dto.response.PlayerResponse;
import com.example.Cricbuzz.model.Enum.Gender;
import com.example.Cricbuzz.model.Enum.Speciality;
import com.example.Cricbuzz.model.Player;
import com.example.Cricbuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public PlayerResponse addPlayer(PlayerRequest playerRequest){
        Player player = PlayerConvertor.playerRequestToPlayer(playerRequest);
        Player savedPlayer =playerRepository.save(player);
        sendEmail(savedPlayer);

        return PlayerConvertor.playerToPlayerResponse(savedPlayer);
    }

    private void sendEmail(Player player) {

        String text = "Hi! " +player.getName() + ", you have been registered successfully to Cricbuzz";
        SimpleMailMessage message =new SimpleMailMessage();
        message.setFrom("springprojectmail7@gmail.com");
        message.setTo(player.getEmail());
        message.setSubject("Congrats !! you have been registered");
        message.setText(text);
        javaMailSender.send(message);

    }

    public PlayerResponse getPlayerById( int id){
        Optional<Player > playerOptional =playerRepository.findById(id);

        if(playerOptional.isEmpty()){
            throw new RuntimeException("player with id : " +id +" does not exist");
        }
        return PlayerConvertor.playerToPlayerResponse(playerOptional.get());
    }


    public List<PlayerResponse> getByGenderAndAgeGreaterThan(Gender gender, int age){
        List<Player> players = playerRepository.getByGenderAndAgeGreaterThanEqual(gender,age);

        List<PlayerResponse> playerResponses = new ArrayList<>();

        for(Player player: players){
            playerResponses.add(PlayerConvertor.playerToPlayerResponse(player));
        }
        return playerResponses;

    }

    public List<PlayerResponse> getByGenderAndSpeciality(Gender gender , Speciality speciality){
        List<Player> players =playerRepository.getByGenderAndSpeciality(gender,speciality);
        List<PlayerResponse> playerResponses = new ArrayList<>();

        for(Player player : players){
            playerResponses.add(PlayerConvertor.playerToPlayerResponse(player));
        }
        return playerResponses;

    }
}
