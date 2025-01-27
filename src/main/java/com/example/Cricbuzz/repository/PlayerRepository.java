package com.example.Cricbuzz.repository;

import com.example.Cricbuzz.model.Enum.Gender;
import com.example.Cricbuzz.model.Enum.Speciality;
import com.example.Cricbuzz.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player , Integer> {


    List<Player> getByGenderAndAgeGreaterThanEqual(Gender gender, int age);

//    for non - native Query ->
    @Query(value = "SELECT p from Player p where p.gender =:gender AND p.speciality= :speciality" )
//    @Query(nativeQuery = true , value = "SELECT * FROM player where gender= :gender AND speciality = :speciality")
    List<Player> getByGenderAndSpeciality(Gender gender, Speciality speciality);
}
