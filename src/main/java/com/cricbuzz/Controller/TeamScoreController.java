package com.cricbuzz.Controller;

import com.cricbuzz.Dto.TeamScoreDto;
import com.cricbuzz.Service.TeamScoreService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/team-score")
public class TeamScoreController {

    private final TeamScoreService teamScoreService;

    @PostMapping
    @ApiOperation(value = "Create a New Team Score", response = TeamScoreDto.class)
    public ResponseEntity<TeamScoreDto> createTeamScore(@RequestBody TeamScoreDto teamScoreDto) {
        TeamScoreDto savedTeamScore = teamScoreService.addTeamScore(teamScoreDto);
        return new ResponseEntity<>(savedTeamScore, HttpStatus.CREATED);
    }

    @GetMapping("/{matchId}/{teamId}")
    @ApiOperation(value = "Get Team Score By MatchId and Team Id", response = TeamScoreDto.class)
    public ResponseEntity<TeamScoreDto> getTeamScoreByMatchIdTeamId(@PathVariable long matchId, @PathVariable long teamId) {
        TeamScoreDto teamScore = teamScoreService.teamScoreMatchId(matchId, teamId);
        return teamScore != null ?
                new ResponseEntity<>(teamScore, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{matchId}/{teamId}")
    @ApiOperation(value = "Update Team Score By MatchId and Team Id", response = TeamScoreDto.class)
    public ResponseEntity<TeamScoreDto> updateTeamScoreByMatchIdTeamId(@PathVariable long matchId, @PathVariable long teamId, @RequestBody TeamScoreDto teamScoreDto) {
        teamScoreService.updateTeamScoreMatchId(matchId, teamId, teamScoreDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{matchId}/{teamId}")
    @ApiOperation(value = "Delete Team Score By MatchId and Team Id")
    public ResponseEntity<Void> deleteTeamScoreByMatchIdTeamId(@PathVariable long matchId, @PathVariable long teamId) {
        teamScoreService.deleteTeamScoreMatchId(matchId, teamId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    @ApiOperation(value = "Get All Team Scores", response = TeamScoreDto.class)
    public ResponseEntity<List<TeamScoreDto>> getAllTeamScores() {
        List<TeamScoreDto> allTeamScores = teamScoreService.getAllTeamScores();
        return new ResponseEntity<>(allTeamScores, HttpStatus.OK);
    }

    @GetMapping("/match/{matchId}")
    @ApiOperation(value = "Get Team Scores By Match Id", response = TeamScoreDto.class)
    public ResponseEntity<List<TeamScoreDto>> getTeamScoresByMatchId(@PathVariable long matchId) {
        List<TeamScoreDto> teamScores = teamScoreService.getTeamScoresByMatchId(matchId);
        return new ResponseEntity<>(teamScores, HttpStatus.OK);
    }

    @PostMapping("/bulk")
    @ApiOperation(value = "Bulk Add Team Scores for a Match", response = List.class)
    public ResponseEntity<List<TeamScoreDto>> bulkAddTeamScores(@RequestBody List<TeamScoreDto> teamScores) {
        List<TeamScoreDto> savedTeamScores = teamScoreService.bulkAddTeamScores(teamScores);
        return new ResponseEntity<>(savedTeamScores, HttpStatus.CREATED);
    }

}
