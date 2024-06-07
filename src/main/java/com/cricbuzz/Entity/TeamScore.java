package com.cricbuzz.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_score")
public class TeamScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teamScoreId;

    @ManyToOne
    @JoinColumn(name = "match_id", referencedColumnName = "matchId")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "teamId")
    private Team team;

    @Column(name = "score")
    private int score;

    @Column(name = "wicket")
    private int wicket;

    @Column(name = "overs")
    private float overs;
}
