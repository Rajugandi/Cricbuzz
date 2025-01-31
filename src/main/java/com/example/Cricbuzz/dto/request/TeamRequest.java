package com.example.Cricbuzz.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TeamRequest {

    String name;
    int ranking;
    int iccPoints;
    String coach;
}
