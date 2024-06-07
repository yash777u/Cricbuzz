package com.cricbuzz.Service;

import com.cricbuzz.Dto.PlayerDto;
import com.cricbuzz.Dto.TeamDto;

import java.util.List;

public interface TeamService {
    TeamDto createTeam(TeamDto teamDto);
    TeamDto getTeamByID(long teamId);
    List<TeamDto> getAllTeams();
    void deleteTeamById(long teamId);
    void updateTeam(long teamID, TeamDto teamDto);
}
