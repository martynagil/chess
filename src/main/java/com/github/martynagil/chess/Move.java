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

    public boolean isVertical() {
        return to.getY() != from.getY() && to.getX() == from.getX();
    }

    public boolean isDiagonal() {
        return Math.abs(to.getX() - from.getX()) == Math.abs(to.getY() - from.getY());
    }

    public boolean isHorizontal() {
        return to.getY() == from.getY() && to.getX() != from.getX();
    }

    public int getDistance() { //compromise because we wont use it with knight
        if (isHorizontal()) {
            return Math.abs(from.getX() - to.getX());
        } else if (isVertical() || isDiagonal()) {
            return Math.abs(from.getY() - to.getY());
        } else {
            throw new IllegalStateException();
        }
    }

    public Field getFrom() {
        return from;
    }

    public Field getTo() {
        return to;
    }
}

// TODO: 03.08.2020 testy MOVE - wszystkie metody, konstruktor, kompromis, zakładam, ze field działa