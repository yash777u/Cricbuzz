package com.cricbuzz.Respository;

import com.cricbuzz.Entity.TeamScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamScoreRepository extends JpaRepository<TeamScore, Long> {

    @Query("SELECT ts FROM TeamScore ts WHERE ts.match.matchId = :matchId AND ts.team.teamId = :teamId")
    Optional<TeamScore> findByMatchIdAndTeamId(@Param("matchId") long matchId, @Param("teamId") long teamId);
}
