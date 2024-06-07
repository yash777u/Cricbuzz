package com.cricbuzz.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamScoreDto {
    private long teamScoreId;
    private long matchId;
    private long teamId;
    private int score;
    private int wicket;
    private float overs;
}
