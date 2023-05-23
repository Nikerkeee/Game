package com.game.controller;

import com.game.controller.exception.UnknownResultException;

public interface GameController {
    void runGame() throws UnknownResultException;
}
