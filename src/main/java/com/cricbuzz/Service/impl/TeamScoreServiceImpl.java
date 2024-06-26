package com.cricbuzz.Service.impl;

import com.cricbuzz.Dto.TeamScoreDto;
import com.cricbuzz.Entity.Match;
import com.cricbuzz.Entity.Team;
import com.cricbuzz.Entity.TeamScore;
import com.cricbuzz.Respository.MatchRepository;
import com.cricbuzz.Respository.*;
import com.cricbuzz.Service.TeamScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamScoreServiceImpl implements TeamScoreService {

    @Autowired
    private TeamScoreRepository teamScoreRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public TeamScoreDto addTeamScore(TeamScoreDto teamScoreDto) {
        TeamScore teamScore = new TeamScore();
        teamScore.setMatch(getMatchById(teamScoreDto.getMatchId()));
        teamScore.setTeam(getTeamById(teamScoreDto.getTeamId()));
        teamScore.setScore(teamScoreDto.getScore());
        teamScore.setWicket(teamScoreDto.getWicket());
        teamScore.setOvers(teamScoreDto.getOvers());

        teamScore = teamScoreRepository.save(teamScore);

        return convertToDto(teamScore);
    }

    @Override
    public List<TeamScoreDto> getAllTeamScores() {
        List<TeamScore> allTeamScores = teamScoreRepository.findAll();
        return allTeamScores.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TeamScoreDto> getTeamScoresByMatchId(long matchId) {
        List<TeamScore> teamScores = teamScoreRepository.findByMatchMatchId(matchId);
        return teamScores.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeamScoreDto teamScoreMatchId(long matchId, long teamId) {
        Optional<TeamScore> teamScore = teamScoreRepository.findByMatchIdAndTeamId(matchId, teamId);
        return teamScore.map(this::convertToDto).orElse(null);
    }

    @Override
    public void updateTeamScoreMatchId(long matchId, long teamId, TeamScoreDto teamScoreDto) {
        Optional<TeamScore> optionalTeamScore = teamScoreRepository.findByMatchIdAndTeamId(matchId, teamId);
        if (optionalTeamScore.isPresent()) {
            TeamScore teamScore = optionalTeamScore.get();
            teamScore.setScore(teamScoreDto.getScore());
            teamScore.setWicket(teamScoreDto.getWicket());
            teamScore.setOvers(teamScoreDto.getOvers());
            teamScoreRepository.save(teamScore);
        }
    }

    @Override
    public void deleteTeamScoreMatchId(long matchId, long teamId) {
        Optional<TeamScore> optionalTeamScore = teamScoreRepository.findByMatchIdAndTeamId(matchId, teamId);
        optionalTeamScore.ifPresent(teamScoreRepository::delete);
    }

    @Override
    public List<TeamScoreDto> bulkAddTeamScores(List<TeamScoreDto> teamScores) {
        List<TeamScore> teamsScore  = teamScores.stream().map((TeamScoreDto teamScoreDto) -> {
            TeamScore teamScore = new TeamScore();
            teamScore.setMatch(getMatchById(teamScoreDto.getMatchId()));
            teamScore.setTeam(getTeamById(teamScoreDto.getTeamId()));
            teamScore.setScore(teamScoreDto.getScore());
            teamScore.setWicket(teamScoreDto.getWicket());
            teamScore.setOvers(teamScoreDto.getOvers());
            return teamScore;
        }).toList();

        teamsScore = teamScoreRepository.saveAll(teamsScore);
        return teamsScore.stream().map(this::convertToDto).collect(Collectors.toList());
    }


    private TeamScoreDto convertToDto(TeamScore teamScore) {
        return new TeamScoreDto(
                teamScore.getTeamScoreId(),
                teamScore.getMatch().getMatchId(),
                teamScore.getTeam().getTeamId(),
                teamScore.getScore(),
                teamScore.getWicket(),
                teamScore.getOvers()
        );
    }

    private Match getMatchById(long matchId) {
        return matchRepository.findById(matchId).orElseThrow(() -> new RuntimeException("Match not found"));
    }

    private Team getTeamById(long teamId) {
        return teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
    }
}
