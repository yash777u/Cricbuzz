package com.cricbuzz.Mapper;

import com.cricbuzz.Dto.TeamScoreDto;
import com.cricbuzz.Entity.Match;
import com.cricbuzz.Entity.Team;
import com.cricbuzz.Entity.TeamScore;

public class TeamScoreMapper {

    public static TeamScoreDto mapToTeamScoreDto(TeamScore teamScore) {
        return new TeamScoreDto(
                teamScore.getTeamScoreId(),
                teamScore.getMatch().getMatchId(),
                teamScore.getTeam().getTeamId(),
                teamScore.getScore(),
                teamScore.getWicket(),
                teamScore.getOvers()
        );
    }

    public static TeamScore mapToTeamScore(TeamScoreDto teamScoreDto, Match match, Team team) {
        TeamScore teamScore = new TeamScore();
        teamScore.setTeamScoreId(teamScoreDto.getTeamScoreId());
        teamScore.setMatch(match);
        teamScore.setTeam(team);
        teamScore.setScore(teamScoreDto.getScore());
        teamScore.setWicket(teamScoreDto.getWicket());
        teamScore.setOvers(teamScoreDto.getOvers());
        return teamScore;
    }
}
