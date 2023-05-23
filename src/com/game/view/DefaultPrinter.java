package com.game.view;

import com.game.model.GameCharacter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DefaultPrinter implements Printer {

    public static final String FIELD_WARRIOR = "H";
    public static final String FIELD_WIZARD = "V";
    public static final String FIELD_FIGHT = "X";
    public static final String FIELD_EMPTY = "_";

    @Override
    public void printPosition(String[] board, GameCharacter... characters) {
        System.out.println(getBoardDetails(board) + getStatuses(characters));
    }

    @Override
    public void printFight(String[] board, GameCharacter... characters) {
        System.out.println(getBoardDetails(board) + "harc: " + getStatuses(characters));
    }

    @Override
    public void printResult(GameCharacter character) {
        System.out.println(character.getType() + " nyert");
    }

    private String getBoardDetails(String[] board) {
        return Arrays.toString(board) + "--> ";
    }

    private String getStatuses(GameCharacter... characters) {
        return Arrays.stream(characters).map(GameCharacter::getStatus).collect(Collectors.joining(", "));
    }
}
