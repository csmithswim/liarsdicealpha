package com.csmithswim;

public class Player {
    static int DICE_NUMBER = 7;
    private Cup cup;
    private String name;

    public Player(String name) {
        this.name = name;
        cup = new Cup(DICE_NUMBER);
    };

    // shake cup
    public void roll() {
        cup.roll();
    }
    // peek
    public void peek() {
        cup.peek();
    }
    // make claim
    // get from user two ints one for die value 1 - 6 and one for amount 1 - 14
    // decide if call or play


}
