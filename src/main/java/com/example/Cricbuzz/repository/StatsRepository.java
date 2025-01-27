package com.example.Cricbuzz.repository;


import com.example.Cricbuzz.model.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Stack;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Integer> {
}
