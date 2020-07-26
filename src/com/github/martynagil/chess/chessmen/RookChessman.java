package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Move;

public class RookChessman extends Chessman {

    public RookChessman(Color color) {
        super(color, "R");
    }

    @Override
    public boolean canMakeMove(Move move) {
        int fromX = move.getFrom().getX();
        int fromY = move.getFrom().getY();
        int toX = move.getTo().getX();
        int toY = move.getTo().getY();

        return fromX == toX || fromY == toY;
    }
}