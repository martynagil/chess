package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.engine.Board;
import com.github.martynagil.chess.engine.Field;
import com.github.martynagil.chess.engine.Move;

public class BishopChessman extends Chessman {

    public BishopChessman(Color color, Field position) {
        super(color, "B", position);
    }

    @Override
    public boolean canMakeMove(Board board, Move move) {
       return move.isDiagonal();
    }
}
