package com.game.controller;

import com.game.model.Warrior;
import com.game.model.Wizard;
import com.game.view.Printer;

import java.util.Optional;
import java.util.Random;

import static com.game.view.Printer.FIELD_EMPTY;
import static com.game.view.Printer.FIELD_FIGHT;
import static com.game.view.Printer.FIELD_WARRIOR;
import static com.game.view.Printer.FIELD_WIZARD;

public class GameController {
    private final Random random = new Random();
    private final Warrior warrior;
    private final Wizard wizard;

    private final Printer printer;
    private String[] board = new String[]{FIELD_WARRIOR, FIELD_EMPTY, FIELD_WIZARD};

    public GameController(Warrior warrior, Wizard wizard, Printer printer) {
        this.warrior = warrior;
        this.wizard = wizard;
        this.printer = printer;
        printer.printPosition(board, warrior, wizard);
    }

    public void runGame() {
        while (warrior.getLife() > 0 && wizard.getLife() > 0) {
            iterateNextRound();
        }
        if (warrior.getLife() <= 0 && wizard.getLife() <= 0) {
            printer.printResult(Optional.empty());
        } else if (warrior.getLife() <= 0) {
            printer.printResult(Optional.of("Varázsló"));
        } else {
            printer.printResult(Optional.of("Harcos"));
        }
    }

    private void iterateNextRound() {
        calculateNewPositions();
        if (warrior.getPosition() == wizard.getPosition()) {
            fight();
        } else {
            move();
        }
    }

    private void calculateNewPositions() {
        board = new String[]{FIELD_EMPTY, FIELD_EMPTY, FIELD_EMPTY};
        warrior.setPosition(random.nextInt(3));
        wizard.setPosition(random.nextInt(3));
    }

    private void fight() {
        board[warrior.getPosition()] = FIELD_FIGHT;
        warrior.setLife(warrior.getLife() - calculateDamage());
        wizard.setLife(wizard.getLife() - calculateDamage());
        printer.printFight(board, warrior, wizard);
    }

    private void move() {
        board[warrior.getPosition()] = FIELD_WARRIOR;
        board[wizard.getPosition()] = FIELD_WIZARD;
        printer.printPosition(board, warrior, wizard);
    }

    private int calculateDamage() {
        return random.nextInt(6) + 1;
    }
}
