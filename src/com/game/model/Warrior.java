package com.game.model;

public class Warrior extends GameCharacter {

    private static final int START_POSITION = 0;

    public Warrior() {
        super(START_POSITION);
    }

    @Override
    public String toString() {
        return "H:" + getLife();
    }
}
