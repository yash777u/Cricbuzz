package com.cricbuzz.Mapper;

import com.cricbuzz.Dto.PlayerDto;
import com.cricbuzz.Entity.Player;

public class PlayerMapper {

    public static Player mapToPlayer(PlayerDto playerDto) {
        return new Player(
                playerDto.getPlayerId(),
                playerDto.getPlayerName()
        );
    }

    public static PlayerDto mapToPlayerDto(Player player){
        return new PlayerDto(
                (int) player.getPlayerId(),
          player.getPlayerName()
        );
    }
}
