package com.game.model;

import java.util.Random;

public class Warrior {
    private int life = initLife();
    private int position = 0;

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

    @Override
    public String toString() {
        return "H:" + life;
    }
}
