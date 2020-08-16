package com.github.martynagil.chess.engine;

import com.github.martynagil.chess.chessmen.*;
import com.github.martynagil.chess.saveManager.ChessmanStateMapper;
import com.github.martynagil.chess.saveManager.GameManager;
import com.github.martynagil.chess.saveManager.GameState;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Game {

    private Console console;

    private GameManager gameManager = new GameManager();
    private boolean gameLasting = true;
    private Part part;

    public Game(Console console, Part part) {
        this.console = console;
        this.part = part;
    }

    public void run() {
        if (!tryToLoadGame()) {
            gameManager.deleteSaveIfExists();
        }

        do {
            part.changePlayer();
            part.getBoard().print();
            Action action = console.askForAction(part::isMovePossible);
            if (action.isMove()) {
                part.makeMove(action.getMove());
            } else {
                saveGame();
                gameLasting = false;
            }
        } while (!isFinished());

        console.printWinner(part.isWhitePlaying());
    }

    private void saveGame() {
        gameManager.save(part);
    }

    private boolean isFinished() {
        return !gameLasting || !part.areKingsAlive();
    }

    private boolean tryToLoadGame() {
        if (gameManager.saveExist()) {
            if (console.askForLoad()) {
                ChessmanStateMapper chessmanStateMapper = new ChessmanStateMapper();
                GameState gameState = gameManager.loadGame();
                List<Chessman> chessmen = gameState.getChessmen().stream()
                        .map(chessmanStateMapper::mapToChessman)
                        .collect(toList());
                boolean whitePlaying = gameState.isWhitePlaying();
                part = new Part(chessmen, whitePlaying);
                return true;
            }
        }
        return false;
    }
}
