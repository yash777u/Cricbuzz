package com.cricbuzz.Service.impl;

import com.cricbuzz.Dto.PlayerScoreDto;
import com.cricbuzz.Entity.Match;
import com.cricbuzz.Entity.Player;
import com.cricbuzz.Entity.PlayerScore;
import com.cricbuzz.Entity.Team;
import com.cricbuzz.Respository.*;
import com.cricbuzz.Service.PlayerScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerScoreServiceImpl implements PlayerScoreService {

    @Autowired
    private PlayerScoreRepository playerScoreRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public PlayerScoreDto addPlayerScore(PlayerScoreDto playerScoreDto) {
        PlayerScore playerScore = new PlayerScore();
        playerScore.setPlayer(getPlayerById(playerScoreDto.getPlayerId()));
        playerScore.setMatch(getMatchById(playerScoreDto.getMatchId()));
        playerScore.setTeam(getTeamById(playerScoreDto.getTeamId()));
        playerScore.setRuns(playerScoreDto.getRuns());
        playerScore.setBalls(playerScoreDto.getBalls());
        playerScore.setFours(playerScoreDto.getFours());
        playerScore.setSixes(playerScoreDto.getSixes());
        playerScore.setWickets(playerScoreDto.getWickets());

        playerScore = playerScoreRepository.save(playerScore);

        return convertToDto(playerScore);
    }

    @Override
    public PlayerScoreDto playerScoreByMatchIdAndPlayerId(long matchId, long playerId) {
        Optional<PlayerScore> playerScore = playerScoreRepository.findByMatchIdAndPlayerId(matchId, playerId);
        return playerScore.map(this::convertToDto).orElse(null);
    }

    @Override
    public List<PlayerScoreDto> getAllPlayerScore() {
        List<PlayerScore> allPlayerScores = playerScoreRepository.findAll();
        return allPlayerScores.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PlayerScoreDto updatePlayerScoreByMatchIdAndPlayerId(long matchId, long playerId, PlayerScoreDto playerScoreDto) {
        Optional<PlayerScore> optionalPlayerScore = playerScoreRepository.findByMatchIdAndPlayerId(matchId, playerId);
        if (optionalPlayerScore.isPresent()) {
            PlayerScore playerScore = optionalPlayerScore.get();
            playerScore.setRuns(playerScoreDto.getRuns());
            playerScore.setBalls(playerScoreDto.getBalls());
            playerScore.setFours(playerScoreDto.getFours());
            playerScore.setSixes(playerScoreDto.getSixes());
            playerScore.setWickets(playerScoreDto.getWickets());
            playerScoreRepository.save(playerScore);
        }
        return playerScoreDto;
    }
    @Override
    public List<PlayerScoreDto> bulkAddPlayerScores(List<PlayerScoreDto> playerScoreDtos) {
        List<PlayerScore> playerScores = playerScoreDtos.stream().map(playerScoreDto -> {
            PlayerScore playerScore = new PlayerScore();
            playerScore.setPlayer(getPlayerById(playerScoreDto.getPlayerId()));
            playerScore.setMatch(getMatchById(playerScoreDto.getMatchId()));
            playerScore.setTeam(getTeamById(playerScoreDto.getTeamId()));
            playerScore.setRuns(playerScoreDto.getRuns());
            playerScore.setBalls(playerScoreDto.getBalls());
            playerScore.setFours(playerScoreDto.getFours());
            playerScore.setSixes(playerScoreDto.getSixes());
            playerScore.setWickets(playerScoreDto.getWickets());
            return playerScore;
        }).collect(Collectors.toList());

        playerScores = playerScoreRepository.saveAll(playerScores);
        return playerScores.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void deletePlayerScoreByMatchIdAndPlayerId(long matchId, long playerId) {
        Optional<PlayerScore> optionalPlayerScore = playerScoreRepository.findByMatchIdAndPlayerId(matchId, playerId);
        optionalPlayerScore.ifPresent(playerScoreRepository::delete);
    }

    private PlayerScoreDto convertToDto(PlayerScore playerScore) {
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

    private Player getPlayerById(long playerId) {
        return playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player not found"));
    }

    private Match getMatchById(long matchId) {
        return matchRepository.findById(matchId).orElseThrow(() -> new RuntimeException("Match not found"));
    }

    private Team getTeamById(long teamId) {
        return teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
    }
}
