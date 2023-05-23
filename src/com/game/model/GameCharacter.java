package com.game.model;

import java.util.Random;

public class GameCharacter {
    private int life;
    private int position;

    public GameCharacter(int position) {
        this.life = initLife();
        this.position = position;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int initLife() {
        return new Random().nextInt(6) + 1 + 3;
    }
}
