package com.game;

import com.game.controller.GameController;
import com.game.model.Warrior;
import com.game.model.Wizard;
import com.game.view.Printer;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();
        Printer printer = new Printer();

        GameController gameController = new GameController(warrior, wizard, printer);
        gameController.runGame();
    }
}