package com.github.martynagil.chess;

public class Move {

    private Field from;
    private Field to;

    public Move(String move) {
        move = move.trim();
        String[] parts = move.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Move must be in format [field][ ][field]");
        }

        this.from = new Field(parts[0]);
        this.to = new Field(parts[1]);
    }

    public Field getFrom() {
        return from;
    }

    public Field getTo() {
        return to;
    }
}
