package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Board;
import com.github.martynagil.chess.Field;
import com.github.martynagil.chess.Move;

public class RookChessman extends Chessman {

    public RookChessman(Color color, Field position) {
        super(color, "R", position);
    }

    @Override
    public boolean canMakeMove(Board board, Move move) {
        return move.isVertical() || move.isHorizontal();
    }
}