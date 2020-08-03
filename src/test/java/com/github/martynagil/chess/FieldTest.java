package com.github.martynagil.chess;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void shouldProperlyParseField() {
        Field field = new Field("A1");

        assertThat(field.getX()).isEqualTo(0);
        assertThat(field.getY()).isEqualTo(0);
    }

    @Test
    void shouldProperlyParseFieldWithWhiteSpaces() {
        Field field = new Field("    D7  ");

        assertThat(field.getX()).isEqualTo(3);
        assertThat(field.getY()).isEqualTo(6);
    }

    @Test
    void shouldThrowExceptionWhenFieldsLengthIsOne() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Field("1")
        );
    }

    @Test
    void shouldThrowExceptionWhenFieldsLengthIsThree() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Field("A12")
        );
    }

    @Test
    void shouldThrowExceptionWhenFieldDoesNotContainsLetter() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Field("12")
        );
    }

    @Test
    void shouldThrowExceptionWhenFieldDoesNotContainsNumber() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Field("AB")
        );
    }

    @Test
    void shouldThrowExceptionWhenNumberIsOutOfRange() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Field("A0")
        );
    }

    @Test
    void shouldThrowExceptionWhenLetterIsOutOfRange() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Field("J5")
        );
    }

    @Test
    void shouldProperlyParseFieldWithLowerCase() {
        Field field = new Field("d3");

        assertThat(field.getX()).isEqualTo(3);
        assertThat(field.getY()).isEqualTo(2);
    }
}
