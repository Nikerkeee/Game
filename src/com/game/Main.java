package com.game;

import com.game.controller.GameController;
import com.game.controller.exception.UnknownResultException;
import com.game.model.GameCharacter;
import com.game.model.Warrior;
import com.game.model.Wizard;
import com.game.view.Printer;

public class Main {
    public static void main(String[] args) {
        GameCharacter warrior = new Warrior();
        GameCharacter wizard = new Wizard();
        Printer printer = new Printer();

        GameController gameController = new GameController(warrior, wizard, printer);
        try {
            gameController.runGame();
        } catch (UnknownResultException ex) {
            System.out.println(ex.getMessage());
        }
    }
}