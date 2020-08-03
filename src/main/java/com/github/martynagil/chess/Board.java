package com.github.martynagil.chess;

import com.github.martynagil.chess.chessmen.*;

import java.util.List;

public class Board {

    private Chessman[][] board = new Chessman[8][8];

    public Board(List<Chessman> chessmen) {
        chessmen.forEach(chessman -> {
            board[chessman.getPosition().getX()][chessman.getPosition().getY()] = chessman;
        });
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
        chessman.setPosition(move.getTo());
    }

    public Chessman getFieldValue(Field field) {
        return board[field.getX()][field.getY()];
    }

    private void setFieldValue(Field field, Chessman chessman) {
        board[field.getX()][field.getY()] = chessman;
    }
}
