package com.example.Cricbuzz.dto.request;

import com.example.Cricbuzz.model.Enum.Gender;
import com.example.Cricbuzz.model.Enum.Speciality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PlayerRequest {
    String name;
    String email;
    int age;
    Speciality speciality;
    Gender gender;
}
