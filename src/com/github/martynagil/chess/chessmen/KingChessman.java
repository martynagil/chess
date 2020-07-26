package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Move;

public class KingChessman extends Chessman {

    public KingChessman(Color color) {
        super(color, "K");
    }

    @Override
    public boolean canMakeMove(Move move) {

        int fromX = move.getFrom().getX();
        int fromY = move.getFrom().getY();
        int toX = move.getTo().getX();
        int toY = move.getTo().getY();

        for (int x = fromX - 1; x < fromX + 2; x++) {
            for (int y = fromY - 1; y < fromY + 2; y++) {
                if (toX == x && toY == y) {
                    return true;
                }
            }
        }
        return false;
    }
}
