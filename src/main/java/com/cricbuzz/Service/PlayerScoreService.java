package com.cricbuzz.Service;

import com.cricbuzz.Dto.PlayerScoreDto;

import java.util.List;

public interface PlayerScoreService {

    // Add Player Score
    PlayerScoreDto addPlayerScore(PlayerScoreDto playerScoreDto);

    // Bulk Add Player Scores
    List<PlayerScoreDto> bulkAddPlayerScores(List<PlayerScoreDto> playerScoreDtos);

    // Retrieve Player Score using Match Id & Player Id
    PlayerScoreDto playerScoreByMatchIdAndPlayerId(long matchId, long playerId);

    // Reterive all player Score
    public List<PlayerScoreDto> getAllPlayerScore();

    // Update Player Score using Match Id & Player Id
    PlayerScoreDto updatePlayerScoreByMatchIdAndPlayerId(long matchId, long playerId, PlayerScoreDto playerScoreDto);

    // Delete Player Score using Match Id & Player Id
    void deletePlayerScoreByMatchIdAndPlayerId(long matchId, long playerId);
}
