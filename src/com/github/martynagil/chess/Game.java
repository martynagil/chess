package com.github.martynagil.chess;

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
        Chessman chessman = board.getFieldValue(move.getFrom());
        if (chessman == null) {
            return false;
        }

        if (whitePlaying && chessman.getColor() == Color.BLACK) {
            return false;
        }

        if (!whitePlaying && chessman.getColor() == Color.WHITE) {
            return false;
        }

        chessman = board.getFieldValue(move.getTo());
        if (whitePlaying && chessman.getColor() == Color.WHITE) {
            return false;
        }

        if (!whitePlaying && chessman.getColor() == Color.BLACK) {
            return false;
        }

        //TODO: check for chessman move
        return true;
    }

    private boolean isFinished() {
        return false;
    }
}
