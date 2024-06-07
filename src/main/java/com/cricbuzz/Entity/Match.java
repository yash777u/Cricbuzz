package com.cricbuzz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import com.cricbuzz.Enum.MatchType;
import com.cricbuzz.Enum.MatchStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matchId;

    @Enumerated(EnumType.STRING)
    @Column(name = "match_Type")
    private MatchType matchType;

    @Column(name = "match_Venue")
    private String venue;

    @Enumerated(EnumType.STRING)
    @Column(name = "match_Status")
    private MatchStatus status;

    @Column(name = "start_Time")
    private LocalDateTime startTime;

    @Column(name = "end_Time")
    private LocalDateTime endTime;
}
