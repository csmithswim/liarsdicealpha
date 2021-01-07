package com.csmithswim;

public class Main {
    public static void main(String[] args) {
        Cup player1Cup = new Cup(7);
        player1Cup.peek();
        player1Cup.roll();
        player1Cup.peek();
        player1Cup.addDie();player1Cup.addDie();
        player1Cup.roll();
        player1Cup.peek();
        player1Cup.roll();
        player1Cup.peek();
        player1Cup.removeDie();
        player1Cup.removeDie();
        player1Cup.removeDie();
        player1Cup.peek();
    }
}
