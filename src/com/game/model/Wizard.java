package com.game.model;

public class Wizard extends DefaultGameCharacter {
    private static final int START_POSITION = 2;
    private static final String TYPE = "Varázsló";
    private static final String TYPE_SHORTNAME = "V";

    public Wizard() {
        super(START_POSITION, TYPE, TYPE_SHORTNAME);
    }
}
