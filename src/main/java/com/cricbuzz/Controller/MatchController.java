package com.cricbuzz.Controller;

import com.cricbuzz.Dto.MatchDto;
import com.cricbuzz.Service.MatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/matches")
@Api(tags = "Match Controller", description = "Endpoints for managing matches")
public class MatchController {

    private MatchService matchService;

    @PostMapping
    @ApiOperation(value = "Create a new match", response = MatchDto.class)
    public ResponseEntity<MatchDto> createMatch(@RequestBody MatchDto matchDto) {
        MatchDto savedMatch = matchService.createMatch(matchDto);
        return new ResponseEntity<>(savedMatch, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a match by ID", response = MatchDto.class)
    public ResponseEntity<MatchDto> getMatchById(@PathVariable(value = "id") Long matchId) {
        MatchDto getMatch = matchService.getMatchById(matchId);
        return ResponseEntity.ok(getMatch);
    }

    @GetMapping
    @ApiOperation(value = "Get all matches", response = MatchDto.class, responseContainer = "List")
    public ResponseEntity<List<MatchDto>> getAllMatches() {
        List<MatchDto> savedMatches = matchService.getAllMatches();
        return ResponseEntity.ok(savedMatches);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a match by ID")
    public ResponseEntity<Void> deleteMatchById(@PathVariable(value = "id") Long matchId) {
        matchService.deleteMatchesByID(matchId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a match by ID")
    public ResponseEntity<Void> updateMatchById(@PathVariable(value = "id") Long matchId, @RequestBody MatchDto matchDto) {
        matchService.updateMatchById(matchId, matchDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
