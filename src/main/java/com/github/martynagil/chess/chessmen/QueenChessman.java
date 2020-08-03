package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Board;
import com.github.martynagil.chess.Move;

public class QueenChessman extends Chessman {

    public QueenChessman(Color color) {
        super(color, "Q");
    }

    @Override
    public boolean canMakeMove(Board board, Move move) {
        return move.isVertical() || move.isDiagonal() || move.isHorizontal();
    }
}