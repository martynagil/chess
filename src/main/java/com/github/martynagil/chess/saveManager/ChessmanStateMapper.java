package com.github.martynagil.chess.saveManager;

import com.github.martynagil.chess.chessmen.*;
import com.github.martynagil.chess.engine.Field;

public class ChessmanStateMapper {

    public Chessman mapToChessman(ChessmanState chessmanState) {
        switch (chessmanState.getType()) {
            case KING:
                return new KingChessman(chessmanState.getColor(), new Field(chessmanState.getField()));
            case PAWN:
                return new PawnChessman(chessmanState.getColor(), new Field(chessmanState.getField()));
            case ROOK:
                return new RookChessman(chessmanState.getColor(), new Field(chessmanState.getField()));
            case QUEEN:
                return new QueenChessman(chessmanState.getColor(), new Field(chessmanState.getField()));
            case BISHOP:
                return new BishopChessman(chessmanState.getColor(), new Field(chessmanState.getField()));
            case KNIGHT:
                return new KnightChessman(chessmanState.getColor(), new Field(chessmanState.getField()));
            default:
                throw new IllegalStateException("Chessman not recognised");
        }

    }
}