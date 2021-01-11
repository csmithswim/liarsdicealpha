package com.csmithswim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LiarsDice {
    private List<Player> players;
    private Console console = new Console();
    private int[] claim;

    public LiarsDice(int numPlayers) {
        players = new ArrayList<>();
        for (int count = 0; count < numPlayers; count++) {
            players.add(new Player(console.getString("Player " + (count + 1) + "'s Name")));
        }
    }

    public void runRound() {
        shakeAllCups();
        System.out.println(players.get(0).getName() + "'s turn");
        players.get(0).peek();
        claim = players.get(0).getClaim();
        int activePlayer = 1;
        while (true) {
            //runTurn(players.get(activePlayer));
        }
        // lie called.
        // confirm if claim is a lie
        // remove die from loser
        // remove player if out.
        // determine if there are enough players to continue.
    }

    public void runTurn(Player player) {
        console.getString(player.getName() + "'s turn press enter to continue");
        player.peek();
        boolean decision = player.getDecision();
        if (decision) {
            // called lie end turns.
            return;
        }
        int[] newClaim = players.get(0).getClaim();
        isValidClaim(newClaim);
        //validate claim if invalid ask for new claim
        //new claim must increment either the value or the count of the previous claim.
        //if the value is raised the count can be any number.
        //if only the count is raised it must be higher then previous count.
    };

    private boolean isValidClaim(int[] newClaim) {
        return false;
    }

    private void shakeAllCups() {
        for (var player : players) {
            player.roll();
        }
    }
}