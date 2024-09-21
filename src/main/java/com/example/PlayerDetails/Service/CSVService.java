package com.example.PlayerDetails.Service;

import com.example.PlayerDetails.Model.Player;
import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CSVService {

    private Map<String, Player> playerMap = new HashMap<>();

    public CSVService () {
        loadCsvData();
    }

    // Load CSV data into a HashMap
    private void loadCsvData() {
        try (CSVReader csvReader = new CSVReader(
                new InputStreamReader(new ClassPathResource("Player.csv").getInputStream()))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                Player player = new Player(values[0], values[1], values[2],
                        values[3], values[4], values[5], values[6],
                        values[7],values[8], values[9],
                        values[10], values[11], values[12], values[13], values[14], values[15],
                        values[16], values[17], values[18], values[19], values[20], values[21],
                        values[22], values[23]);
                playerMap.put(values[0], player); // Assuming the first column is the primary key (id)
            }
        } catch (Exception e) {
//            e.printStackTrace();
            log.error("There's something wrong in the application", e);
        }
    }

    public List<Player> getAllPlayer() {
        return new ArrayList<>(playerMap.values());
    }

    public Player getPlayerById(String id) {
        return playerMap.get(id);
    }

    public void updateInMemory(Player updatedPlayer) {
        playerMap.put(updatedPlayer.getPlayerID(), updatedPlayer);
    }

}
