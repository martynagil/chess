package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Board;
import com.github.martynagil.chess.Field;
import com.github.martynagil.chess.Move;

public abstract class Chessman {

    private Color color;
    private String symbol;
    private Field position;

    public Chessman(Color color, String symbol, Field position) {
        this.color = color;

        if (color == Color.WHITE) {
            this.symbol = symbol.toUpperCase();
        } else {
            this.symbol = symbol.toLowerCase();
        }

        this.position = position;
    }

    public abstract boolean canMakeMove(Board board, Move move);

    public boolean isAlive(){
        return position != null;
    }

    public Color getColor() {
        return color;
    }

    public String getSymbol() {
        return symbol;
    }

    public Field getPosition() {
        return position;
    }

    public void setPosition(Field position) {
        this.position = position;
    }
}
