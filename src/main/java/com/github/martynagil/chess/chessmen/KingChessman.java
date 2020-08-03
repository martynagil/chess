package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Board;
import com.github.martynagil.chess.Field;
import com.github.martynagil.chess.Move;

public class KingChessman extends Chessman {

    public KingChessman(Color color, Field position) {
        super(color, "K", position);
    }

    @Override
    public boolean canMakeMove(Board board, Move move) {
        return move.getDistance() == 1;
    }
}
