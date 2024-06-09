package com.cricbuzz.Controller;

import com.cricbuzz.Dto.PlayerScoreDto;
import com.cricbuzz.Service.PlayerScoreService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/player-score")
public class PlayerScoreController {

    private final PlayerScoreService playerScoreService;

    @PostMapping
    @ApiOperation(value = "Create a New Player Score", response = PlayerScoreDto.class)
    public ResponseEntity<PlayerScoreDto> createPlayerScore(@RequestBody PlayerScoreDto playerScoreDto) {
        PlayerScoreDto savedPlayerScore = playerScoreService.addPlayerScore(playerScoreDto);
        return new ResponseEntity<>(savedPlayerScore, HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value = "Get All Player Score", response =  PlayerScoreDto.class)
    public ResponseEntity<List<PlayerScoreDto>> getAllPlayersScore() {
        List<PlayerScoreDto> allPlayerScores = playerScoreService.getAllPlayerScore();
        return new ResponseEntity<>(allPlayerScores, HttpStatus.OK);
    }

    @GetMapping("/match/{matchId}")
    @ApiOperation(value = "Get Player Scores By Match ID", response = PlayerScoreDto.class)
    public ResponseEntity<List<PlayerScoreDto>> getPlayerScoresByMatchId(@PathVariable long matchId) {
        List<PlayerScoreDto> playerScores = playerScoreService.getPlayerByMatchId(matchId);
        return new ResponseEntity<>(playerScores, HttpStatus.OK);
    }

    @GetMapping("/{matchId}/{playerId}")
    @ApiOperation(value = "Get Player Score By MatchId and Player Id", response = PlayerScoreDto.class)
    public ResponseEntity<PlayerScoreDto> getPlayerByMatchIdPlayerId(@PathVariable long matchId, @PathVariable long playerId) {
        PlayerScoreDto savedPlayer = playerScoreService.playerScoreByMatchIdAndPlayerId(matchId,playerId);
        return new ResponseEntity<>(savedPlayer, HttpStatus.OK);
    }

    @PutMapping("/{matchId}/{playerId}")
    @ApiOperation(value = "Update Player Score By MatchId and Player Id", response = PlayerScoreDto.class)
    public ResponseEntity<PlayerScoreDto> updatePlayerByMatchIdPlayerId(@PathVariable long matchId, @PathVariable long playerId, @RequestBody PlayerScoreDto playerScoreDto) {
        PlayerScoreDto updatedPlayerScore = playerScoreService.updatePlayerScoreByMatchIdAndPlayerId(matchId, playerId, playerScoreDto);
        return new ResponseEntity<>(updatedPlayerScore, HttpStatus.OK);
    }

    @DeleteMapping("/{matchId}/{playerId}")
    @ApiOperation(value = "Delete Player Score By MatchId and Player Id")
    public ResponseEntity<Void> deletePlayerByMatchIdPlayerId(@PathVariable long matchId, @PathVariable long playerId) {
        playerScoreService.deletePlayerScoreByMatchIdAndPlayerId(matchId, playerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/bulk")
    @ApiOperation(value = "Bulk Add Player Scores for a Match", response = List.class)
    public ResponseEntity<List<PlayerScoreDto>> bulkAddPlayerScores(@RequestBody List<PlayerScoreDto> playerScores) {
        List<PlayerScoreDto> savedPlayerScores = playerScoreService.bulkAddPlayerScores(playerScores);
        return new ResponseEntity<>(savedPlayerScores, HttpStatus.CREATED);
    }
}
