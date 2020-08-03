package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Board;
import com.github.martynagil.chess.Move;

public class PawnChessman extends Chessman {

    public PawnChessman(Color color) {
        super(color, "p");
    }

    @Override
    public boolean canMakeMove(Board board, Move move) {
        if (move.isVertical() && move.getDistance() == 1) {
            return board.getFieldValue(move.getTo()) == null;
        } else if (move.isDiagonal() && move.getDistance() == 1) {
            return board.getFieldValue(move.getTo()) != null;
        } else {
            return false;
        }

    }
}
