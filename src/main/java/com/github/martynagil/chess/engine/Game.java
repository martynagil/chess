package com.github.martynagil.chess.engine;

import com.github.martynagil.chess.chessmen.*;
import com.github.martynagil.chess.saveManager.ChessmanState;
import com.github.martynagil.chess.saveManager.ChessmanStateMapper;
import com.github.martynagil.chess.saveManager.GameManager;
import com.github.martynagil.chess.saveManager.GameState;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    private GameManager gameManager = new GameManager();

    private List<Chessman> chessmen = new ArrayList<>();
    private boolean whitePlaying = true;
    private Board board;
    private boolean gameLasting = true;

    public void run() {
        if (!tryToLoadGame()) {
            assignPlaces();
            gameManager.deleteSaveIfExists();
        }
        board = new Board(chessmen);

        do {
            board.print();
            Action action = askForAction();
            if (action.isMove()) {
                board.move(action.getMove());
            } else {
                saveGame();
                gameLasting = false;
            }
            changePlayer();
        } while (!isFinished());

        printWinner();
    }

    private void saveGame() {
        gameManager.save(whitePlaying, chessmen);
    }

    private void printWinner() {
        if (whitePlaying) {
            System.out.println("The winner is BLACK");
        } else {
            System.out.println("The winner is WHITE");
        }
    }

    private void changePlayer() {
        whitePlaying = !whitePlaying;
    }

    private Action askForAction() {
        while (true) {
            try {
                System.out.print("Action: ");
                String action = scanner.nextLine().trim();
                if (action.equalsIgnoreCase("save")) {
                    return Action.save();
                }

                Move move = new Move(action);
                if (isMovePossible(move)) {
                    return Action.move(move);
                } else {
                    System.out.println("This move is not possible");
                }
            } catch (Exception e) {
                e.printStackTrace();
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

        if (toChessman == null){
            return fromChessman.canMakeMove(board, move);
        }

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
       return !gameLasting || !chessmen.stream()
                .filter(chessman -> chessman.getType() == ChessmanType.KING)
                .allMatch(Chessman::isAlive);
    }

    private boolean tryToLoadGame() {
        if (gameManager.saveExist()) {
            if (askForLoad()) {
                ChessmanStateMapper chessmanStateMapper = new ChessmanStateMapper();
                GameState gameState = gameManager.loadGame();
                chessmen = gameState.getChessmen().stream()
                        .map(chessmanStateMapper::mapToChessman)
                        .collect(toList());
                whitePlaying = gameState.isWhitePlaying();
                return true;
            }
        }
        return false;
    }

    private boolean askForLoad() {
        System.out.println("Do you want to load the save?");
        return scanner.nextLine().equals("yes");
    }
}
