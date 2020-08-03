package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Board;
import com.github.martynagil.chess.Field;
import com.github.martynagil.chess.Move;

public class BishopChessman extends Chessman {

    public BishopChessman(Color color, Field position) {
        super(color, "B", position);
    }

    @Override
    public boolean canMakeMove(Board board, Move move) {
       return move.isDiagonal();
    }
}
