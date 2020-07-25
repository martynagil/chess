package com.github.martynagil.chess;

public class Movement {

    private Field from;
    private Field to;

    public Movement(String movement) {
        movement = movement.trim();
        String[] parts = movement.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Movement must be in format [field][ ][field]");
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
