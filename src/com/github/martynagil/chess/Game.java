package com.github.martynagil.chess;

import com.github.martynagil.chess.chessmen.Chessman;
import com.github.martynagil.chess.chessmen.Color;

import java.util.Scanner;

public class Game {

    private Board board = new Board();
    private Scanner scanner = new Scanner(System.in);
    private boolean whitePlaying = true;

    public void run() {
        do {
            board.print();
            Move move = askForMove();
            board.move(move);

            changePlayer();
        } while (!isFinished());
    }

    private void changePlayer() {
        whitePlaying = !whitePlaying;
    }

    private Move askForMove() {
        while (true) {
            try {
                System.out.print("Move: ");
                Move move = new Move(scanner.nextLine());

                if (isMovePossible(move)) {
                    return move;
                } else {
                    System.out.println("This move is not possible");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean isMovePossible(Move move) {
        Chessman fromChessman = board.getFieldValue(move.getFrom());
        if (fromChessman == null) {
            return false;
        }

        if (whitePlaying && fromChessman.getColor() == Color.BLACK) {
            return false;
        }

        if (!whitePlaying && fromChessman.getColor() == Color.WHITE) {
            return false;
        }

        Chessman toChessman = board.getFieldValue(move.getTo());
        if (whitePlaying && toChessman.getColor() == Color.WHITE) {
            return false;
        }

        if (!whitePlaying && toChessman.getColor() == Color.BLACK) {
            return false;
        }

        return fromChessman.canMakeMove(move);

    }

    private boolean isFinished() {
        return false;
    }
}
