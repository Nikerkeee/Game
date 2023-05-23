package com.game.controller.exception;

public class UnknownResultException extends RuntimeException {
    public UnknownResultException() {
        super("Hiba: nem lehet meghatározni a nyertest");
    }
}
