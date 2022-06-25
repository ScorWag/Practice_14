package ru.netology.manager;

import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    protected Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null && findByName(playerName2) == null) {
            throw new NotFoundException("Players with name: " + playerName1 + " and " + playerName2 + " not found");
        }
        if (findByName(playerName1) == null) {
            throw new NotFoundException("Player with name: " + playerName1 + " not found");
        }
        if (findByName(playerName2) == null) {
            throw new NotFoundException("Player with name: " + playerName2 + " not found");
        }
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
