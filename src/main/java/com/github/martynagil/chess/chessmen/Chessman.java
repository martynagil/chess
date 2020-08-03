package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Board;
import com.github.martynagil.chess.Move;

public abstract class Chessman {

    private Color color;
    private String symbol;

    public Chessman(Color color, String symbol) {
        this.color = color;

        if (color == Color.WHITE) {
            this.symbol = symbol.toUpperCase();
        } else {
            this.symbol = symbol.toLowerCase();
        }
    }

    public abstract boolean canMakeMove(Board board, Move move);

    public Color getColor() {
        return color;
    }

    public String getSymbol() {
        return symbol;
    }
}
