package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Field;
import com.github.martynagil.chess.Move;

public class QueenChessman extends Chessman {

    public QueenChessman(Color color) {
        super(color, "Q");
    }

    @Override
    public boolean canMakeMove(Move move) {
        return true;
    }
}