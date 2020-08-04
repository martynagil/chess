package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.engine.Board;
import com.github.martynagil.chess.engine.Field;
import com.github.martynagil.chess.engine.Move;

public class KingChessman extends Chessman {

    public KingChessman(Color color, Field position) {
        super(color, "K", position);
    }

    @Override
    public boolean canMakeMove(Board board, Move move) {
        return move.getDistance() == 1;
    }
}
