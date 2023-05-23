package com.game.view;

import com.game.model.GameCharacter;

import java.util.Arrays;

public class Printer {

    public static final String FIELD_WARRIOR = "H";
    public static final String FIELD_WIZARD = "V";
    public static final String FIELD_FIGHT = "X";
    public static final String FIELD_EMPTY = "_";

    public void printPosition(String[] board, GameCharacter warrior, GameCharacter wizard) {
        System.out.println(getBoardDetails(board) + getStatuses(warrior, wizard));
    }

    public void printFight(String[] board, GameCharacter warrior, GameCharacter wizard) {
        System.out.println(getBoardDetails(board) + "harc:" + getStatuses(warrior, wizard));
    }

    public void printResult(String winner) {
        System.out.println(winner + " nyert");
    }

    private String getBoardDetails(String[] board) {
        return Arrays.toString(board) + "--> ";
    }

    private String getStatuses(GameCharacter warrior, GameCharacter wizard) {
        return warrior.toString() + ", " + wizard.toString();
    }
}
