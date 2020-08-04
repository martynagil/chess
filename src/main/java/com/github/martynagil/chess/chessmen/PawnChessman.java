package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.engine.Board;
import com.github.martynagil.chess.engine.Field;
import com.github.martynagil.chess.engine.Move;

public class PawnChessman extends Chessman {

    public PawnChessman(Color color, Field position) {
        super(color, "p", position);
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
