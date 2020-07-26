package com.github.martynagil.chess.chessmen;

import com.github.martynagil.chess.Move;

public class BishopChessman extends Chessman {

    public BishopChessman(Color color) {
        super(color, "B");
    }

    @Override
    public boolean canMakeMove(Move move) {

        int fromX = move.getFrom().getX();
        int fromY = move.getFrom().getY();
        int toX = move.getTo().getX();
        int toY = move.getTo().getY();

        int x = fromX;
        int y = fromY;

        while (x < 8 && y < 8) {
            if (toX == fromX && toY == fromY) {
                return true;
            }

            x++;
            y++;
        }

        x = fromX;
        y = fromY;

        while (x < 8 && y >= 0) {
            if (toX == fromX && toY == fromY) {
                return true;
            }

            x++;
            y--;
        }

        x = fromX;
        y = fromY;

        while (x >= 0 && y >= 0) {
            if (toX == fromX && toY == fromY) {
                return true;
            }

            x--;
            y--;
        }

        x = fromX;
        y = fromY;

        while (x >= 0 && y < 8) {
            if (toX == fromX && toY == fromY) {
                return true;
            }

            x--;
            y++;
        }

        return false;
    }
}
