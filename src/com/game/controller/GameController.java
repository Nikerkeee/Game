package com.game.controller;

import com.game.controller.exception.UnknownResultException;
import com.game.model.GameCharacter;
import com.game.view.Printer;

import java.util.Random;

import static com.game.view.Printer.FIELD_EMPTY;
import static com.game.view.Printer.FIELD_FIGHT;
import static com.game.view.Printer.FIELD_WARRIOR;
import static com.game.view.Printer.FIELD_WIZARD;

public class GameController {
    private final Random random = new Random();
    private final GameCharacter warrior;
    private final GameCharacter wizard;

    private final Printer printer;
    private String[] board = new String[]{FIELD_WARRIOR, FIELD_EMPTY, FIELD_WIZARD};

    public GameController(GameCharacter warrior, GameCharacter wizard, Printer printer) {
        this.warrior = warrior;
        this.wizard = wizard;
        this.printer = printer;
        printer.printPosition(board, warrior, wizard);
    }

    public void runGame() throws UnknownResultException {
        while (warrior.getLife() > 0 && wizard.getLife() > 0) {
            iterateNextRound();
        }
        if (warrior.getLife() <= 0 && wizard.getLife() <= 0) {
            throw new UnknownResultException();
        } else if (warrior.getLife() <= 0) {
            printer.printResult("Varázsló");
        } else {
            printer.printResult("Harcos");
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
