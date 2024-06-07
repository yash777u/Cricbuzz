package com.cricbuzz.Service;

import com.cricbuzz.Dto.PlayerDto;
import java.util.List;

public interface PlayerService {
    PlayerDto createPlayer(PlayerDto playerDto);
    PlayerDto getPlayerByID(long playerId);
    List<PlayerDto> getAllPlayers();
    void deletePlayerById(long playerId);
    void updatePlayer(long playerId, PlayerDto playerDto);
    List<PlayerDto> createPlayers(List<PlayerDto> playerDtos);
}
