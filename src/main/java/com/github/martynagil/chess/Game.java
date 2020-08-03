package com.github.martynagil.chess;

import com.github.martynagil.chess.chessmen.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Chessman> chessmen = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private boolean whitePlaying = true;
    private Board board;

    public Game() {
        assignPlaces();
        this.board = new Board(chessmen);
    }

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

        return fromChessman.canMakeMove(board, move);

    }

    private void assignPlaces() {
        chessmen.add(new RookChessman(Color.BLACK, new Field (0,0)));
        chessmen.add(new KnightChessman(Color.BLACK, new Field (1,0)));
        chessmen.add(new BishopChessman(Color.BLACK, new Field (2,0)));
        chessmen.add(new QueenChessman(Color.BLACK, new Field (3,0)));
        chessmen.add(new KingChessman(Color.BLACK, new Field (4,0)));
        chessmen.add(new BishopChessman(Color.BLACK, new Field (5,0)));
        chessmen.add(new KnightChessman(Color.BLACK, new Field (6,0)));
        chessmen.add(new RookChessman(Color.BLACK, new Field (7,0)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field (0,1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field (1,1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field (2,1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field (3,1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field (4,1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field (5,1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field (6,1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field (7,1)));
        chessmen.add(new RookChessman(Color.WHITE, new Field (0,7)));
        chessmen.add(new KnightChessman(Color.WHITE, new Field (1,7)));
        chessmen.add(new BishopChessman(Color.WHITE, new Field (2,7)));
        chessmen.add(new QueenChessman(Color.WHITE, new Field (3,7)));
        chessmen.add(new KingChessman(Color.WHITE, new Field (4,7)));
        chessmen.add(new BishopChessman(Color.WHITE, new Field (5,7)));
        chessmen.add(new KnightChessman(Color.WHITE, new Field (6,7)));
        chessmen.add(new RookChessman(Color.WHITE, new Field (7,7)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field (0,6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field (1,6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field (2,6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field (3,6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field (4,6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field (5,6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field (6,6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field (7,6)));
    }

    private boolean isFinished() {
       return false;
    }
}
