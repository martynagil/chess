package com.github.martynagil.chess.saveManager;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GameState {

    private boolean whitePlaying;
    private List<ChessmanState> chessmen;

    @JsonCreator
    public GameState(
            @JsonProperty("whitePlaying") boolean whitePlaying,
            @JsonProperty("chessmen") List<ChessmanState> chessmen) {
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
