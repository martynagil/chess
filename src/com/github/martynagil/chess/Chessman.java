package com.github.martynagil.chess;

public enum Chessman {
    WHITE_ROOK("R"),
    WHITE_KNIGHT("H"), //horse
    WHITE_BISHOP("B"),
    WHITE_QUEEN("Q"),
    WHITE_KING("K"),
    WHITE_PAWN("P"),

    BLACK_ROOK("r"),
    BLACK_KNIGHT("h"),
    BLACK_BISHOP("b"),
    BLACK_QUEEN("q"),
    BLACK_KING("k"),
    BLACK_PAWN("p");

    private String symbol;

    Chessman(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
