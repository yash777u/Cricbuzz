package com.cricbuzz.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {
    private long matchId;
    private String matchType;
    private String venue;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
