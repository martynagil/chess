package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Board;
import com.github.martynagil.chess.Move;

public class RookChessman extends Chessman {

    public RookChessman(Color color) {
        super(color, "R");
    }

    @Override
    public boolean canMakeMove(Board board, Move move) {
        return move.isVertical() || move.isHorizontal();
    }
}