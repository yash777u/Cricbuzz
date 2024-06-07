package com.cricbuzz.Service.impl;

import com.cricbuzz.Dto.PlayerDto;
import com.cricbuzz.Entity.Player;
import com.cricbuzz.Mapper.PlayerMapper;
import com.cricbuzz.Respository.PlayerRepository;
import com.cricbuzz.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerDto createPlayer(PlayerDto playerDto) {
        Player player = PlayerMapper.mapToPlayer(playerDto);
        Player savedPlayer = playerRepository.save(player);
        return PlayerMapper.mapToPlayerDto(savedPlayer);
    }

    @Override
    public PlayerDto getPlayerByID(long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        return PlayerMapper.mapToPlayerDto(player);
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(PlayerMapper::mapToPlayerDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePlayerById(long playerId) {
        if (!playerRepository.existsById(playerId)) {
            throw new RuntimeException("Player not found");
        }
        playerRepository.deleteById(playerId);
    }

    @Override
    public void updatePlayer(long playerId, PlayerDto playerDto) {
        Player existingPlayer = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        existingPlayer.setPlayerName(playerDto.getPlayerName());
        playerRepository.save(existingPlayer);
    }

    @Override
    public List<PlayerDto> createPlayers(List<PlayerDto> playerDtos) {
        List<Player> players = playerDtos.stream()
                .map(PlayerMapper::mapToPlayer)
                .collect(Collectors.toList());
        List<Player> savedPlayers = playerRepository.saveAll(players);
        return savedPlayers.stream()
                .map(PlayerMapper::mapToPlayerDto)
                .collect(Collectors.toList());
    }
}
