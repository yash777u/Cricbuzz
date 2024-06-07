package com.cricbuzz.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerScoreDto {
    private long playerScoreId;
    private long playerId;
    private long matchId;
    private long teamId;
    private int runs;
    private int balls;
    private int fours;
    private int sixes;
    private int wickets;
}
