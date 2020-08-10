package com.github.martynagil.chess.saveManager;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.martynagil.chess.chessmen.ChessmanType;
import com.github.martynagil.chess.chessmen.Color;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ChessmanState {

    private Color color;
    private String field;
    private ChessmanType type;

    @JsonCreator
    public ChessmanState(
            @JsonProperty("color") Color color,
            @JsonProperty("field") String field,
            @JsonProperty("type") ChessmanType type) {
        this.color = color;
        this.field = field;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public String getField() {
        return field;
    }

    public ChessmanType getType() {
        return type;
    }
}
