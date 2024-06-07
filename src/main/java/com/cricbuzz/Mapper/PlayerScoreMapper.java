package com.cricbuzz.Mapper;

import com.cricbuzz.Dto.PlayerScoreDto;
import com.cricbuzz.Entity.Match;
import com.cricbuzz.Entity.Player;
import com.cricbuzz.Entity.PlayerScore;
import com.cricbuzz.Entity.Team;

public class PlayerScoreMapper {

    public static PlayerScoreDto mapToPlayerScoreDto(PlayerScore playerScore) {
        return new PlayerScoreDto(
                playerScore.getPlayerScoreId(),
                playerScore.getPlayer().getPlayerId(),
                playerScore.getMatch().getMatchId(),
                playerScore.getTeam().getTeamId(),
                playerScore.getRuns(),
                playerScore.getBalls(),
                playerScore.getFours(),
                playerScore.getSixes(),
                playerScore.getWickets()
        );
    }

    public static PlayerScore mapToPlayerScore(PlayerScoreDto playerScoreDto) {
        return new PlayerScore(
                playerScoreDto.getPlayerScoreId(),
                new Player(playerScoreDto.getPlayerId(), null),  // Assuming constructor or setter will handle it properly
                new Match(playerScoreDto.getMatchId(), null, null, null, null, null),  // Assuming constructor or setter will handle it properly
                new Team(playerScoreDto.getTeamId(), null),  // Assuming constructor or setter will handle it properly
                playerScoreDto.getRuns(),
                playerScoreDto.getBalls(),
                playerScoreDto.getFours(),
                playerScoreDto.getSixes(),
                playerScoreDto.getWickets()
        );
    }
}
