package com.game.view;

import com.game.model.GameCharacter;

public interface Printer {
    void printPosition(String[] board, GameCharacter... characters);

    void printFight(String[] board, GameCharacter... characters);

    void printResult(GameCharacter character);
}
