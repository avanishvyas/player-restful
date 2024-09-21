package com.example.PlayerDetails.Repo;

import com.example.PlayerDetails.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, String> {
}