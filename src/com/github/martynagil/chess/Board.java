package com.github.martynagil.chess;

import com.github.martynagil.chess.chessmen.*;

public class Board {

    private Chessman[][] board = new Chessman[8][8];

    public Board() {
        board[0][0] = new RookChessman(Color.BLACK);
        board[1][0] = new KnightChessman(Color.BLACK);
        board[2][0] = new BishopChessman(Color.BLACK);
        board[3][0] = new QueenChessman(Color.BLACK);
        board[4][0] = new KingChessman(Color.BLACK);
        board[5][0] = new BishopChessman(Color.BLACK);
        board[6][0] = new KnightChessman(Color.BLACK);
        board[7][0] = new RookChessman(Color.BLACK);
        board[0][1] = new PawnChessman(Color.BLACK);
        board[1][1] = new PawnChessman(Color.BLACK);
        board[2][1] = new PawnChessman(Color.BLACK);
        board[3][1] = new PawnChessman(Color.BLACK);
        board[4][1] = new PawnChessman(Color.BLACK);
        board[5][1] = new PawnChessman(Color.BLACK);
        board[6][1] = new PawnChessman(Color.BLACK);
        board[7][1] = new PawnChessman(Color.BLACK);

        board[0][7] = new RookChessman(Color.WHITE);
        board[1][7] = new KnightChessman(Color.WHITE);
        board[2][7] = new BishopChessman(Color.WHITE);
        board[3][7] = new QueenChessman(Color.WHITE);
        board[4][7] = new KingChessman(Color.WHITE);
        board[5][7] = new BishopChessman(Color.WHITE);
        board[6][7] = new KnightChessman(Color.WHITE);
        board[7][7] = new RookChessman(Color.WHITE);
        board[0][6] = new PawnChessman(Color.WHITE);
        board[1][6] = new PawnChessman(Color.WHITE);
        board[2][6] = new PawnChessman(Color.WHITE);
        board[3][6] = new PawnChessman(Color.WHITE);
        board[4][6] = new PawnChessman(Color.WHITE);
        board[5][6] = new PawnChessman(Color.WHITE);
        board[6][6] = new PawnChessman(Color.WHITE);
        board[7][6] = new PawnChessman(Color.WHITE);
    }

    public void print() {
        System.out.println("  A B C D E F G H");
        for (int y = 0; y < board.length; y++) {
            System.out.print(y + 1 + " ");
            for (int x = 0; x < board[y].length; x++) {
                Chessman chessman = board[x][y];
                if (chessman == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(chessman.getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }

    public void move(Move move) {
        Chessman chessman = getFieldValue(move.getFrom());
        setFieldValue(move.getTo(), chessman);
        setFieldValue(move.getFrom(), null);
    }

    public Chessman getFieldValue(Field field) {
        return board[field.getX()][field.getY()];
    }

    private void setFieldValue(Field field, Chessman chessman) {
        board[field.getX()][field.getY()] = chessman;
    }
}
