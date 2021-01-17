package com.csmithswim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LiarsDice {
    private List<Player> players;
    private Console console = new Console();
    final int CLAIM_VALUE = 0, CLAIM_COUNT = 1;
    private int[] claim;
    private int round = 1;
    private int playerNumber = 0;

    public LiarsDice(int numPlayers) {
        players = new ArrayList<>();
        for (int count = 0; count < numPlayers; count++) {
            players.add(new Player(console.getString("Enter Player " + (count + 1) + "'s Name")));
        }
        while (true) {
            boolean continueGame = runRound();
            if (!continueGame) break;
        }
    }

    public boolean runRound() {
        System.out.println("Start of round "+round);
        shakeAllCups();
        //Where the program determines who goes first
        System.out.println(players.get(playerNumber % players.size()).getName() + "'s turn:");
        players.get(playerNumber).peek();
        claim = players.get(playerNumber).getClaim();
        playerNumber++;
        int activePlayer = playerNumber;
        while (true) {
            boolean continueRound = runTurn(players.get(activePlayer % players.size()));
            if (!continueRound) break;
            activePlayer++;
        }
        if (isLie()) {
            activePlayer -= 1;
            System.out.println(players.get(activePlayer% players.size()).getName() + " is a big fat LIAR!");
            System.out.println(players.get(activePlayer% players.size()).getName() + " has lost one die.");
        }
        int affectedPlayer = activePlayer % players.size();
        players.get(affectedPlayer).removeDie();
        if (players.get(affectedPlayer).isOut()) {
            System.out.println(players.get(affectedPlayer).getName()+"Has lost all their dice and is out of the game.");
            players.remove(affectedPlayer);
        }
        // determine if there are enough players to continue.
        if (players.size() == 1) {
            System.out.println("Game over " + players.get(0).getName() + " Wins!");
            return false;
        }
        playerNumber=activePlayer+1;
        if(playerNumber>=players.size()){
            playerNumber=0;
        }
        round++;
        return true;
    }

    public boolean runTurn(Player player) {
//        System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
        console.getString(player.getName() + "'s turn press enter to continue");
//        System.out.println(player.getName() + "'s cup: "+player.peek(););
        player.peek();
        System.out.println("The current claim is: " + claim[CLAIM_COUNT] + " " + claim[CLAIM_VALUE] + "s" );
        boolean decision = player.getDecision();
        //If lie?
        if (decision) {
            return false;
        }
        int [] newClaim;
        while (true) {
            newClaim = player.getClaim();
            if (isValidClaim(newClaim)) break;
        }
        claim = newClaim;
        return true;
    };
    private boolean isValidClaim(int[] newClaim) {
        if (newClaim[CLAIM_COUNT] == claim[CLAIM_COUNT] && newClaim[CLAIM_VALUE] == claim[CLAIM_VALUE]) {
            System.out.println("Error: must be a new claim");
            return false;
        }
        if (newClaim[CLAIM_VALUE] < claim[CLAIM_VALUE]) {
            System.out.println("Error: Die value must be same or increased");
            return false;
        }
        if (newClaim[CLAIM_VALUE] == claim[CLAIM_VALUE] && claim[CLAIM_COUNT] > newClaim[CLAIM_COUNT]) {
            System.out.println("Error: Must increment at least one item");
            return false;
        }
        return true;
    }
    private void shakeAllCups() {
        for (var player : players) {
            player.roll();
        }
    }
    private boolean isLie() {
        int count = 0;
        for (var player : players) {
            count += player.countValue(claim[CLAIM_VALUE]);
        }
        return count < claim[CLAIM_COUNT];
    }
}