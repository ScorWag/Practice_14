package ru.netology.manager;

import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Game {

    protected Map<String, Player> players;

    public Game() {
        this.players = new HashMap<>();
    }

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {

        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

        if (player1 == null && player2 == null) {
            throw new NotFoundException("Players with name: " + playerName1 + " and " + playerName2 + " not found");
        }
        if (player1 == null) {
            throw new NotFoundException("Player with name: " + playerName1 + " not found");
        }
        if (player2 == null) {
            throw new NotFoundException("Player with name: " + playerName2 + " not found");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
