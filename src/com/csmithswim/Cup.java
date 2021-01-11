package com.csmithswim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cup {
    private List<Die> dice;

    public Cup(int diceNum) {
        dice = new ArrayList<>();
        for (int counter = 0; counter < diceNum; counter++) {
            dice.add(new Die());
        }
    }

    public void addDie() {
        dice.add(new Die());
    }

    public void removeDie() {
        dice.remove(dice.size() - 1);
    }

    public void peek() {
        String output = "";
        for (var die : dice) {
            output += die.getValue() + " ";
        }
        System.out.println(output.trim());
    }

    public void roll() {
        Random rand = new Random();
        for (var die : dice) {
            die.roll(rand);
        }
    }

    public int size() {
        return dice.size();
    }
}