package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Board;
import com.github.martynagil.chess.Move;

public class BishopChessman extends Chessman {

    public BishopChessman(Color color) {
        super(color, "B");
    }

    @Override
    public boolean canMakeMove(Board board, Move move) {
       return move.isDiagonal();
    }
}
