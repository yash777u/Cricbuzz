package com.cricbuzz.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "player_score")
public class PlayerScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long playerScoreId;

    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "playerId")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "match_id", referencedColumnName = "matchId")
    private Match match;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "teamId")
    private Team team;

    @Column(name = "runs")
    private int runs;

    @Column(name = "balls")
    private int balls;

    @Column(name = "fours")
    private int fours;

    @Column(name = "sixes")
    private int sixes;

    @Column(name = "wickets")
    private int wickets;

}
