package com.cricbuzz.Controller;

import com.cricbuzz.Dto.TeamDto;
import com.cricbuzz.Service.TeamService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    @ApiOperation(value = "Create a new team", response = TeamDto.class)
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto) {
        TeamDto savedTeam = teamService.createTeam(teamDto);
        return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
    }

    @GetMapping("/{teamId}")
    @ApiOperation(value = "Get a team by ID", response = TeamDto.class)
    public ResponseEntity<TeamDto> getTeamByID(@PathVariable long teamId) {
        TeamDto teamDto = teamService.getTeamByID(teamId);
        return new ResponseEntity<>(teamDto, HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get all teams", response = TeamDto.class, responseContainer = "List")
    public ResponseEntity<List<TeamDto>> getAllTeams() {
        List<TeamDto> teams = teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @DeleteMapping("/{teamId}")
    @ApiOperation(value = "Delete a team by ID")
    public ResponseEntity<Void> deleteTeamById(@PathVariable long teamId) {
        teamService.deleteTeamById(teamId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{teamId}")
    @ApiOperation(value = "Update a team by ID", response = TeamDto.class)
    public ResponseEntity<TeamDto> updateTeam(@PathVariable long teamId, @RequestBody TeamDto teamDto) {
        teamService.updateTeam(teamId, teamDto);
        return new ResponseEntity<>(teamDto, HttpStatus.OK);
    }
}
