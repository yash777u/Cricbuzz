package com.cricbuzz.Service.impl;

import com.cricbuzz.Dto.MatchDto;
import com.cricbuzz.Entity.Match;
import com.cricbuzz.Enum.MatchStatus;
import com.cricbuzz.Enum.MatchType;
import com.cricbuzz.Mapper.MatchMapper;
import com.cricbuzz.Respository.MatchRepository;
import com.cricbuzz.Service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;


    @Override
    public MatchDto createMatch(MatchDto matchDto) {
        Match match = MatchMapper.mapToMatch(matchDto);
        Match savedMatch = matchRepository.save(match);
        return MatchMapper.mapToMatchDto(savedMatch);
    }

    @Override
    public MatchDto getMatchById(Long matchId) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found with id: " + matchId));

        // Map Match entity to MatchDto
        return MatchMapper.mapToMatchDto(match);
    }

    @Override
    public List<MatchDto> getAllMatches() {
        List<Match> listAllMatches = matchRepository.findAll();
        return listAllMatches.stream().map(MatchMapper::mapToMatchDto).collect(Collectors.toList());
    }

    @Override
    public void deleteMatchesByID(long matchId) {
        matchRepository.deleteById(matchId);
    }

    @Override
    public void updateMatchById(long matchId, MatchDto matchDto) {
        Match match = matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found with id: " + matchId));
        match.setMatchType(MatchType.valueOf(matchDto.getMatchType()));
        match.setVenue(matchDto.getVenue());
        match.setStatus(MatchStatus.valueOf(matchDto.getStatus()));
        match.setStartTime(matchDto.getStartTime());
        match.setEndTime(matchDto.getEndTime());

        matchRepository.save(match);
    }


}
