package com.game;

import com.game.controller.DefaultGameController;
import com.game.controller.exception.UnknownResultException;
import com.game.model.GameCharacter;
import com.game.model.Warrior;
import com.game.model.Wizard;
import com.game.view.DefaultPrinter;
import com.game.view.Printer;

public class Main {
    public static void main(String[] args) {
        GameCharacter warrior = new Warrior();
        GameCharacter wizard = new Wizard();
        Printer defaultPrinter = new DefaultPrinter();

        DefaultGameController defaultGameController = new DefaultGameController(warrior, wizard, defaultPrinter);
        try {
            defaultGameController.runGame();
        } catch (UnknownResultException ex) {
            System.out.println(ex.getMessage());
        }
    }
}