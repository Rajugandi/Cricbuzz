package com.example.Cricbuzz.dto.request;


import com.example.Cricbuzz.dto.response.TeamResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MatchRequest {

    String title;
    String venue;

    List<TeamResponse> teams;
}
