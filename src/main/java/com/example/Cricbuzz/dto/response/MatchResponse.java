package com.example.Cricbuzz.dto.response;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchResponse {

    String title;
    String venue;
    Date created;

    List<TeamResponse> teams;

}
