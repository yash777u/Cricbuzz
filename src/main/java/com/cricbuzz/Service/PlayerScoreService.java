package com.cricbuzz.Service;

import com.cricbuzz.Dto.PlayerScoreDto;

public interface PlayerScoreService {

    // Add Player Score
    PlayerScoreDto addPlayerScore(PlayerScoreDto playerScoreDto);

    // Retrieve Player Score using Match Id & Player Id
    PlayerScoreDto playerScoreByMatchIdAndPlayerId(long matchId, long playerId);

    // Update Player Score using Match Id & Player Id
    PlayerScoreDto updatePlayerScoreByMatchIdAndPlayerId(long matchId, long playerId, PlayerScoreDto playerScoreDto);

    // Delete Player Score using Match Id & Player Id
    void deletePlayerScoreByMatchIdAndPlayerId(long matchId, long playerId);
}
