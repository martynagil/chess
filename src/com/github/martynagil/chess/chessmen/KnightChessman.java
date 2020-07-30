package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Board;
import com.github.martynagil.chess.Move;

public class KnightChessman extends Chessman {

    public KnightChessman(Color color) {
        super(color, "H");
    }

    @Override
    public boolean canMakeMove(Board board, Move move) {
        int fromX = move.getFrom().getX();
        int fromY = move.getFrom().getY();
        int toX = move.getTo().getX();
        int toY = move.getTo().getY();

        if (toX == fromX + 1 && toY == fromY + 2 || toX == fromX - 1 && toY == fromY + 2) {
            return true;
        }
        if (toX == fromX + 1 && toY == fromY - 2 || toX == fromX - 1 && toY == fromY - 2) {
            return true;
        }
        if (toX == fromX + 2 && toY == fromY - 1 || toX == fromX - 2 && toY == fromY - 1) {
            return true;
        }
        return toX == fromX + 2 && toY == fromY + 1 || toX == fromX - 2 && toY == fromY + 1;
    }
}
