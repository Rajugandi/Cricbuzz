package com.example.Cricbuzz.repository;

import com.example.Cricbuzz.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team ,Integer> {
}
