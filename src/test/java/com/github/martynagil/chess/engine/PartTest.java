package com.github.martynagil.chess.engine;

import com.github.martynagil.chess.chessmen.Color;
import com.github.martynagil.chess.chessmen.KingChessman;
import com.github.martynagil.chess.chessmen.QueenChessman;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class PartTest {

//    @Test
//    void shouldNotPlayWhiteAfterOneMove() {
//        Mockito.when(console.askForAction(any()))
//                .thenReturn(Action.move(new Move("A7 A6")))
//                .thenReturn(Action.save());
//
//        game.run();
//
//        assertThat(game.isWhitePlaying()).isFalse();
//    }

//    @Test
//    void shouldNotPlayBlackAfterTwoMoves() {
//        Mockito.when(console.askForAction(any()))
//                .thenReturn(Action.move(new Move("A1 B2")))
//                .thenReturn(Action.move(new Move("B2 C3")))
//                .thenReturn(Action.save());
//
//        game.run();
//
//        assertThat(game.isWhitePlaying()).isTrue();
//    }

    @Test
    void shouldNotMoveWhenFromFieldIsEmpty() {
        Move move = new Move("A3 A4");
        Part part = Part.newPart();

        boolean movePossible = part.isMovePossible(move);

        assertThat(movePossible).isFalse();
    }

    @Test
    void shouldMoveWhenFromFieldIsOccupied() {
        Move move = new Move("A7 A6");
        Part part = Part.newPart();

        boolean movePossible = part.isMovePossible(move);

        assertThat(movePossible).isTrue();
    }

    @Test
    void shouldNotMoveWhenChessmanIsBlackAndCurrentPlayerIsWhite() {
        Move move = new Move("A2 A3");
        Part part = Part.newPart();

        boolean movePossible = part.isMovePossible(move);

        assertThat(movePossible).isFalse();
    }

    @Test
    void shouldMoveWhenChessmanIsWhiteAndCurrentPlayerIsWhite() {
        Move move = new Move("A7 A6");
        Part part = Part.newPart();

        boolean movePossible = part.isMovePossible(move);

        assertThat(movePossible).isTrue();
    }

    @Test
    void shouldNotMoveWhenChessmanIsWhiteAndCurrentPlayerIsBlack() {
        Move move = new Move("A2 B1");
        Part part = Part.newPart();
        part.changePlayer();

        boolean movePossible = part.isMovePossible(move);

        assertThat(movePossible).isFalse();
    }

    @Test
    void shouldMoveWhenChessmanIsBlackAndCurrentPlayerIsBlack() {
        Move move = new Move("A2 A3");
        Part part = Part.newPart();
        part.changePlayer();

        boolean movePossible = part.isMovePossible(move);

        assertThat(movePossible).isTrue();
    }

    @Test
    void shouldMoveWhenToFieldIsEmpty() {
        Move move = new Move("A7 A6");
        Part part = Part.newPart();

        boolean movePossible = part.isMovePossible(move);

        assertThat(movePossible).isTrue();
    }

    @Test
    void shouldNotMoveWhenChessmanIsWhiteAndChessmanOnToFieldIsWhite() {
        Move move = new Move("A7 B7");
        Part part = Part.newPart();

        boolean movePossible = part.isMovePossible(move);

        assertThat(movePossible).isFalse();
    }

    @Test
    void shouldNotMoveWhenChessmanIsBlackAndChessmanOnToFieldIsBlack() {
        Move move = new Move("A1 A2");
        Part part = Part.newPart();
        part.changePlayer();

        boolean movePossible = part.isMovePossible(move);

        assertThat(movePossible).isFalse();
    }

    @Test
    void shouldMoveWhenChessmanIsWhiteAndChessmanOnToFieldIsBlack() {
        Move move = new Move("A2 A1");
        Part part = new Part(
                asList(
                        new KingChessman(Color.BLACK, new Field("A1")),
                        new KingChessman(Color.WHITE, new Field("A2"))
                ),
                true
        );

        boolean movePossible = part.isMovePossible(move);

        assertThat(movePossible).isTrue();
    }


    @Test
    void shouldMoveWhenChessmanIsBlackAndChessmanOnToFieldIsWhite() {
        Move move = new Move("A1 A2");
        Part part = new Part(
                asList(
                        new KingChessman(Color.BLACK, new Field("A1")),
                        new KingChessman(Color.WHITE, new Field("A2"))
                ),
                false
        );

        boolean movePossible = part.isMovePossible(move);

        assertThat(movePossible).isTrue();
    }

    @Test
    void shouldIndicateKingsAsAliveWhenTheyAreOnBoard() {
        Part part = Part.newPart();

        assertThat(part.areKingsAlive()).isTrue();
    }

    @Test
    void shouldNotIndicateKingsAsAliveWhenOnlyWhiteIsOnBoard() {
        Part part = new Part(
                asList(
                        new KingChessman(Color.BLACK, null),
                        new KingChessman(Color.WHITE, new Field("A2"))
                ),
                true
        );

        assertThat(part.areKingsAlive()).isFalse();
    }
}