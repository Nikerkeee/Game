package com.game;

public class Warrior {
    private int life;
    private int position;

    public Warrior(int life, int position) {
        this.life = life;
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

    @Override
    public String toString() {
        return "H:" + life;
    }
}
