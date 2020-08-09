package com.github.martynagil.chess.save;

import java.util.List;

public class GameState {

    private boolean whitePlaying;
    private List<ChessmanState> chessmen;

    public GameState(boolean whitePlaying, List<ChessmanState> chessmen) {
        this.whitePlaying = whitePlaying;
        this.chessmen = chessmen;
    }

    public boolean isWhitePlaying() {
        return whitePlaying;
    }

    public List<ChessmanState> getChessmen() {
        return chessmen;
    }
}
