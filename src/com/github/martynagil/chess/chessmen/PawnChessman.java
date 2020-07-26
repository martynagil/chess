package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Field;
import com.github.martynagil.chess.Move;

public class PawnChessman extends Chessman {

    public PawnChessman(Color color) {
        super(color, "p");
    }

    @Override
    public boolean canMakeMove(Move move) {

        return true;
    }
}
