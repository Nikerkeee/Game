package com.game.model;

import java.util.Random;

public class DefaultGameCharacter implements GameCharacter {
    private int life;
    private int position;

    private final String type;
    private final String typeShortName;

    public DefaultGameCharacter(int position, String type, String typeShortName) {
        this.life = initLife();
        this.position = position;
        this.type = type;
        this.typeShortName = typeShortName;
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getStatus() {
        return typeShortName + ": " + getLife();
    }

    private int initLife() {
        return new Random().nextInt(6) + 1 + 3;
    }
}
