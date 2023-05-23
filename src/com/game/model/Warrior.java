package com.game.model;

public class Warrior extends DefaultGameCharacter {

    private static final int START_POSITION = 0;
    private static final String TYPE = "Harcos";
    private static final String TYPE_SHORTNAME = "H";

    public Warrior() {
        super(START_POSITION, TYPE, TYPE_SHORTNAME);
    }
}
