package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.engine.Board;
import com.github.martynagil.chess.engine.Field;
import com.github.martynagil.chess.engine.Move;

public class RookChessman extends Chessman {

    public RookChessman(Color color, Field position) {
        super(color, "R", position);
    }

    @Override
    public boolean canMakeMove(Board board, Move move) {
        return move.isVertical() || move.isHorizontal();
    }

    @Override
    public ChessmanType getType() {
        return ChessmanType.ROOK;
    }
}
