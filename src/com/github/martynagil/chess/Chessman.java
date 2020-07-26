package com.github.martynagil.chess;

public enum Chessman {
    WHITE_ROOK(Color.WHITE, "R"),
    WHITE_KNIGHT(Color.WHITE, "H"), //horse
    WHITE_BISHOP(Color.WHITE, "B"),
    WHITE_QUEEN(Color.WHITE, "Q"),
    WHITE_KING(Color.WHITE, "K"),
    WHITE_PAWN(Color.WHITE, "P"),

    BLACK_ROOK(Color.BLACK, "r"),
    BLACK_KNIGHT(Color.BLACK, "h"),
    BLACK_BISHOP(Color.BLACK, "b"),
    BLACK_QUEEN(Color.BLACK, "q"),
    BLACK_KING(Color.BLACK, "k"),
    BLACK_PAWN(Color.BLACK, "p");

    private Color color;
    private String symbol;

    Chessman(Color color, String symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public Color getColor() {
        return color;
    }
}
