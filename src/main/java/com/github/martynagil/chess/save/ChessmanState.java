package com.github.martynagil.chess.save;

import com.github.martynagil.chess.chessmen.ChessmanType;
import com.github.martynagil.chess.chessmen.Color;
import com.github.martynagil.chess.engine.Field;

public class ChessmanState {

    private Color color;
    private Field field;
    private ChessmanType type;

    public ChessmanState(Color color, Field field, ChessmanType type) {
        this.color = color;
        this.field = field;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public Field getField() {
        return field;
    }

    public ChessmanType getType() {
        return type;
    }
}
