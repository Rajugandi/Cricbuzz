package com.example.Cricbuzz.dto.response;


import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamResponse {

        String name;

        int ranking;
        String coach;

}
