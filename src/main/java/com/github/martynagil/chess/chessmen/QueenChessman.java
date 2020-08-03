package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Board;
import com.github.martynagil.chess.Field;
import com.github.martynagil.chess.Move;

public class QueenChessman extends Chessman {

    public QueenChessman(Color color, Field position) {
        super(color, "Q", position);
    }

    @Override
    public boolean canMakeMove(Board board, Move move) {
        return move.isVertical() || move.isDiagonal() || move.isHorizontal();
    }
}