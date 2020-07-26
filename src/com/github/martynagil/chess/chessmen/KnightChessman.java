package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Field;
import com.github.martynagil.chess.Move;

public class KnightChessman extends Chessman {

    public KnightChessman(Color color) {
        super(color, "H");
    }

    @Override
    public boolean canMakeMove(Move move) {
        return true;
    }
}
