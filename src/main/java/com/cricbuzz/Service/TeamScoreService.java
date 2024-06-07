package com.cricbuzz.Service;

import com.cricbuzz.Dto.TeamScoreDto;

public interface TeamScoreService {

    // Add Team Score For First Time
    TeamScoreDto addTeamScore(TeamScoreDto teamScoreDto);

    // Retrieve Team Score using Match Id & Team Id
    TeamScoreDto teamScoreMatchId(long matchId, long teamId);

    // Update Team Score using Match Id & Team ID
    void updateTeamScoreMatchId(long matchId, long teamId, TeamScoreDto teamScoreDto);

    // Delete Team Score related to Match & Team ID
    void deleteTeamScoreMatchId(long matchId, long teamId);
}
