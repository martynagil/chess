package com.github.martynagil.chess;

import com.github.martynagil.chess.engine.Field;
import com.github.martynagil.chess.engine.Move;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoveTest {

    private static final Field FROM = new Field("A1");
    private static final Field TO = new Field("B2");

    @Test
    void shouldProperlyParseMoveWithWhiteSpaces() {
        Move move = new Move("   A1 B2     ");

        assertThat(move.getFrom()).isEqualTo(FROM);
        assertThat(move.getTo()).isEqualTo(TO);
    }

    @Test
    void shouldProperlyParseMoveWithSpaceBetweenFields() {
        Move move = new Move("A1 B2");

        assertThat(move.getFrom()).isEqualTo(FROM);
        assertThat(move.getTo()).isEqualTo(TO);
    }

    @Test
    void shouldThrowExceptionWhenOneMoveConsistThreeParts() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Move("A1 B2 C3")
        );

    }

    @Test
    void shouldIdentifyMoveAsVertical() {
        Move move = new Move("A1 A2");

        assertThat(move.isVertical()).isTrue();
        assertThat(move.isDiagonal()).isFalse();
        assertThat(move.isHorizontal()).isFalse();
    }

    @Test
    void shouldIdentifyMoveAsDiagonal() {
        Move move = new Move("A1 B2");

        assertThat(move.isDiagonal()).isTrue();
        assertThat(move.isHorizontal()).isFalse();
        assertThat(move.isVertical()).isFalse();
    }

    @Test
    void shouldIdentifyMoveAsHorizontal() {
        Move move = new Move("A1 B1");

        assertThat(move.isDiagonal()).isFalse();
        assertThat(move.isHorizontal()).isTrue();
        assertThat(move.isVertical()).isFalse();
    }

    @Test
    void shouldCalculateHorizontalDistance() {
        Move move = new Move("C3 F3");

        assertThat(move.getDistance()).isEqualTo(3);
    }

    @Test
    void shouldCalculateVerticalDistance() {
        Move move = new Move("C3 C6");

        assertThat(move.getDistance()).isEqualTo(3);
    }

    @Test
    void shouldCalculateDiagonalDistance() {
        Move move = new Move("C3 F6");

        assertThat(move.getDistance()).isEqualTo(3);
    }

    @Test
    void shouldThrowExceptionWhenDistanceIsWrong() {
        assertThrows(
                IllegalStateException.class,
                () -> new Move("C3 F4").getDistance()
        );
    }
}
