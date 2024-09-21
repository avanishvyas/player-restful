package com.example.PlayerDetails.Controllers;

import com.example.PlayerDetails.Model.Player;
import com.example.PlayerDetails.Repo.PlayerRepo;
import com.example.PlayerDetails.Service.CSVService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/player")
public class CSVApiController {

        @Autowired
        private CSVService csvService;
        @Autowired
        private PlayerRepo playerRepo;

        // API to get all players
        @GetMapping
        public List<Player> getAllPeople() {
            return csvService.getAllPlayer();
        }
        // API to get player by ID
        @GetMapping("/{playerID}")
        public Player getPersonById(@PathVariable String playerID) {
            return csvService.getPlayerById(playerID);
        }

        @PutMapping("/update/{playerID}")
        public String updatePlayer(@PathVariable String playerID, @RequestBody Player player) {
                Player updatedPlayer = csvService.getPlayerById(playerID);
                updatedPlayer.setBirthCity(player.getBirthCity());
                csvService.updateInMemory(updatedPlayer);
                return "Updated";
        }
}