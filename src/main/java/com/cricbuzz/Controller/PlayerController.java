package com.cricbuzz.Controller;

import com.cricbuzz.Dto.PlayerDto;
import com.cricbuzz.Service.PlayerService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    @ApiOperation(value = "Create a new player", response = PlayerDto.class)
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto) {
        PlayerDto savedPlayer = playerService.createPlayer(playerDto);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    @GetMapping("/{playerId}")
    @ApiOperation(value = "Get a player by ID", response = PlayerDto.class)
    public ResponseEntity<PlayerDto> getPlayerByID(@PathVariable long playerId) {
        PlayerDto playerDto = playerService.getPlayerByID(playerId);
        return new ResponseEntity<>(playerDto, HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get all players", response = PlayerDto.class, responseContainer = "List")
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        List<PlayerDto> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @DeleteMapping("/{playerId}")
    @ApiOperation(value = "Delete a player by ID")
    public ResponseEntity<Void> deletePlayerById(@PathVariable long playerId) {
        playerService.deletePlayerById(playerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{playerId}")
    @ApiOperation(value = "Update a player by ID", response = PlayerDto.class)
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable long playerId, @RequestBody PlayerDto playerDto) {
        playerService.updatePlayer(playerId, playerDto);
        return new ResponseEntity<>(playerDto, HttpStatus.OK);
    }

    @PostMapping("/bulk")
    @ApiOperation(value = "Create multiple players", response = PlayerDto.class, responseContainer = "List")
    public ResponseEntity<List<PlayerDto>> createPlayers(@RequestBody List<PlayerDto> playerDtos) {
        List<PlayerDto> savedPlayers = playerService.createPlayers(playerDtos);
        return new ResponseEntity<>(savedPlayers, HttpStatus.CREATED);
    }
}
