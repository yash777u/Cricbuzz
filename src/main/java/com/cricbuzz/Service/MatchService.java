package com.cricbuzz.Service;


import com.cricbuzz.Dto.MatchDto;

import java.util.List;

public interface MatchService {
    MatchDto createMatch(MatchDto matchDto);
    MatchDto getMatchById(Long matchId);
    List<MatchDto> getAllMatches();
    public void deleteMatchesByID(long matchId);
    public void updateMatchById(long matchId ,MatchDto matchDto);
}
