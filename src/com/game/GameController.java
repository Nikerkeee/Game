package com.game;

import java.util.Arrays;
import java.util.Random;

public class GameController {
    private static final String FIELD_WARRIOR = "H";
    private static final String FIELD_WIZARD = "V";
    private static final String FIELD_FIGHT = "X";
    private static final String FIELD_EMPTY = "_";
    private final Random random = new Random();
    private final Warrior warrior;
    private final Wizard wizard;
    private String[] board = new String[]{FIELD_WARRIOR, FIELD_EMPTY, FIELD_WIZARD};

    public GameController() {
        warrior = new Warrior(initLife(), 0);
        wizard = new Wizard(initLife(), 2);
        printDetails();
    }

    public void runGame() {
        while (warrior.getLife() > 0 && wizard.getLife() > 0) {
            iterateNextRound();
        }
        if (warrior.getLife() <= 0 && wizard.getLife() <= 0) {
            System.out.println("Nem lehet meghatározni a nyertest");
        } else if (warrior.getLife() <= 0) {
            System.out.println("Varázsló nyert");
        } else {
            System.out.println("Harcos nyert");
        }
    }

    private void iterateNextRound() {
        board = new String[]{FIELD_EMPTY, FIELD_EMPTY, FIELD_EMPTY};
        warrior.setPosition(random.nextInt(3));
        wizard.setPosition(random.nextInt(3));

        if (warrior.getPosition() == wizard.getPosition()) {
            board[warrior.getPosition()] = FIELD_FIGHT;
            warrior.setLife(warrior.getLife() - calculateDamage());
            wizard.setLife(wizard.getLife() - calculateDamage());
        } else {
            board[warrior.getPosition()] = FIELD_WARRIOR;
            board[wizard.getPosition()] = FIELD_WIZARD;
        }
        printDetails();
    }

    private void printDetails() {
        System.out.println(Arrays.toString(board) + "--> " + (isFight() ? "harc:" : "") + getStatuses());
    }

    private String getStatuses() {
        return warrior.toString() + ", " + wizard.toString();
    }

    private boolean isFight() {
        return Arrays.asList(board).contains(FIELD_FIGHT);
    }

    private int calculateDamage() {
        return random.nextInt(6) + 1;
    }

    private int initLife() {
        return random.nextInt(6) + 1 + 3;
    }
}
