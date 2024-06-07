package com.cricbuzz.Mapper;

import com.cricbuzz.Dto.TeamDto;
import com.cricbuzz.Entity.Team;

public class TeamMapper {

    public static Team maptToTeam(TeamDto teamDto){
        return new Team(
          teamDto.getTeamId(),
          teamDto.getTeamName()
        );
    }

    public static TeamDto mapToTeamDto(Team team){

        return new TeamDto(
          team.getTeamId(),
          team.getTeamName()
        );
    }
}
