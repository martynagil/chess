package com.github.martynagil.chess.engine;

import com.github.martynagil.chess.chessmen.Chessman;
import com.github.martynagil.chess.chessmen.ChessmanType;
import com.github.martynagil.chess.chessmen.Color;

import java.util.Arrays;
import java.util.List;

public class Part {

    private List<Chessman> chessmen;
    private boolean whitePlaying;
    private Board board;

    public Part(List<Chessman> chessmen, boolean whitePlaying) {
        this.chessmen = chessmen;
        this.whitePlaying = whitePlaying;
        this.board = new Board(chessmen);
    }

    public static Part newPart() {
        return new Part(ChessmanFactory.defaultSetup(), true);
    }

    public void changePlayer() {
        whitePlaying = !whitePlaying;
    }

    public boolean isMovePossible(Move move) {
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

        if (toChessman == null) {
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

    public Board getBoard() {
        return board;
    }

    public void makeMove(Move move) {
        board.move(move);
    }

    public boolean isWhitePlaying() {
        return whitePlaying;
    }

    public List<Chessman> getChessmen() {
        return chessmen;
    }

    public boolean areKingsAlive() {
        return chessmen.stream()
                .filter(chessman -> chessman.getType() == ChessmanType.KING)
                .allMatch(Chessman::isAlive);
    }
}
