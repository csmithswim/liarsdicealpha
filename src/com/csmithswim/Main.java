package com.csmithswim;
// Assignments:
// [x]Print out end of round info. Call out liar and declare who lost a die.
// [x]declare when a player is removed from game.
//[x] clear console at start of next player turn.
//[x]allow user to enter how many players.
// [x]each round should start with a new player.

// TODO:
// clean code.
// improve overall print outs.


public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        LiarsDice game = new LiarsDice(console.getInt(2,100,"Enter How many players are playing:"));
    }
}