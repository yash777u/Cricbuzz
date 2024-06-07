package com.cricbuzz.Service.impl;

import com.cricbuzz.Dto.TeamDto;
import com.cricbuzz.Entity.Team;
import com.cricbuzz.Mapper.TeamMapper;
import com.cricbuzz.Respository.TeamRepository;
import com.cricbuzz.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public TeamDto createTeam(TeamDto teamDto) {
        Team team = TeamMapper.maptToTeam(teamDto);
        Team savedTeam = teamRepository.save(team);
        return TeamMapper.mapToTeamDto(savedTeam);
    }

    @Override
    public TeamDto getTeamByID(long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + teamId));
        return TeamMapper.mapToTeamDto(team);
    }

    @Override
    public List<TeamDto> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(TeamMapper::mapToTeamDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTeamById(long teamId) {
        if (!teamRepository.existsById(teamId)) {
            throw new RuntimeException("Team not found with id: " + teamId);
        }
        teamRepository.deleteById(teamId);
    }

    @Override
    public void updateTeam(long teamId, TeamDto teamDto) {
        Team existingTeam = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found with id: " + teamId));

        existingTeam.setTeamName(teamDto.getTeamName());
        teamRepository.save(existingTeam);
    }
}
