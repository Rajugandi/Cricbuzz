package com.example.Cricbuzz.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatsRequest {

    int runs;

    int wickets;

    double battingAvg;
    double bowlingAvg;
}
