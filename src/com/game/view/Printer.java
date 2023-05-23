package com.game.view;

import com.game.model.Warrior;
import com.game.model.Wizard;

import java.util.Arrays;
import java.util.Optional;

public class Printer {

    public static final String FIELD_WARRIOR = "H";
    public static final String FIELD_WIZARD = "V";
    public static final String FIELD_FIGHT = "X";
    public static final String FIELD_EMPTY = "_";

    public void printPosition(String[] board, Warrior warrior, Wizard wizard) {
        System.out.println(getBoardDetails(board) + getStatuses(warrior, wizard));
    }

    public void printFight(String[] board, Warrior warrior, Wizard wizard) {
        System.out.println(getBoardDetails(board) + "harc:" + getStatuses(warrior, wizard));
    }

    public void printResult(Optional<String> winner) {
        winner
            .ifPresentOrElse(
                (value) -> System.out.println(value + " nyert"),
                () -> System.out.println("Nem lehet meghatározni a nyertest"));
    }

    private String getBoardDetails(String[] board) {
        return Arrays.toString(board) + "--> ";
    }

    private String getStatuses(Warrior warrior, Wizard wizard) {
        return warrior.toString() + ", " + wizard.toString();
    }
}
