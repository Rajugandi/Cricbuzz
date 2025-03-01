package com.example.Cricbuzz.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int runs;

    int wickets;

    double battingAvg;
    double bowlingAvg;

    @OneToOne
    @JoinColumn
    @JsonBackReference
    Player player;

}
