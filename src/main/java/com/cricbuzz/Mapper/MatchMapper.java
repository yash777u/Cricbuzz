package com.cricbuzz.Mapper;

import com.cricbuzz.Dto.MatchDto;
import com.cricbuzz.Entity.Match;
import com.cricbuzz.Enum.MatchStatus;
import com.cricbuzz.Enum.MatchType;

public class MatchMapper {

    public static MatchDto mapToMatchDto(Match match) {
        if (match == null) {
            return null;
        }
        return new MatchDto(
                match.getMatchId(),
                match.getMatchType() != null ? match.getMatchType().name() : null,
                match.getVenue(),
                match.getStatus() != null ? match.getStatus().name() : null,
                match.getStartTime(),
                match.getEndTime()
        );
    }

    public static Match mapToMatch(MatchDto matchDto) {
        if (matchDto == null) {
            return null;
        }
        return new Match(
                matchDto.getMatchId(),
                matchDto.getMatchType() != null ? MatchType.valueOf(matchDto.getMatchType()) : null,
                matchDto.getVenue(),
                matchDto.getStatus() != null ? MatchStatus.valueOf(matchDto.getStatus()) : null,
                matchDto.getStartTime(),
                matchDto.getEndTime()
        );
    }
}
