package com.csmithswim;

public class Player {
    static int DICE_NUMBER = 7;
    private Cup cup;
    private String name;
    Console console = new Console();

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

    public int countValue(int value) { return cup.countValue(value);}

    public void removeDie() { cup.removeDie();}

    public String getName() {return name;}

    // make claim
    // get from user two ints one for die value 1 - 6 and one for amount 1 - 14
    public int[] getClaim() {
        int dieValue, dieCount;
        dieValue = console.getInt(1, 6, "What die value: 1-6");
        dieCount = console.getInt(1, 14, "How many " + dieValue + " dice: (1 - 14)");
        return new int[] {dieValue, dieCount};
    }

    // decide if call or play
    public boolean getDecision() {
        return console.getYN("l", "p", "Do you call the previous claim? (l)iar or (p)lay");
    }

    public boolean isOut() {
        return cup.size() <= 0;
    }


}
