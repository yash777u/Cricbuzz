package com.cricbuzz.Respository;

import com.cricbuzz.Entity.PlayerScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerScoreRepository extends JpaRepository<PlayerScore, Long> {

    @Query("SELECT ps FROM PlayerScore ps WHERE ps.match.matchId = :matchId AND ps.player.playerId = :playerId")
    Optional<PlayerScore> findByMatchIdAndPlayerId(@Param("matchId") long matchId, @Param("playerId") long playerId);
    @Query("SELECT ps FROM PlayerScore ps WHERE ps.match.matchId = :matchId")
    List<PlayerScore> findByMatchId(@Param("matchId") long matchId);

}
