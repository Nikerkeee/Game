package com.game.model;

public class Wizard extends GameCharacter {
    private static final int START_POSITION = 2;

    public Wizard() {
        super(START_POSITION);
    }

    @Override
    public String toString() {
        return "V:" + getLife();
    }
}
