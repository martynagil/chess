package com.github.martynagil.chess.save;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.martynagil.chess.chessmen.Chessman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class GameSaver {

    private static final String SAVE_FILENAME = "saveChess.json";

    private ObjectMapper objectMapper = new ObjectMapper();

    public void save(boolean whitePlaying, List<Chessman> chessmen) {
        GameState gameState = new GameState(
                whitePlaying,
                chessmen.stream()
                        .map(chessman -> new ChessmanState(
                                chessman.getColor(), chessman.getPosition(), chessman.getType()
                        ))
                        .collect(toList())
        );

        try {
            String json = objectMapper.writeValueAsString(gameState);
            Files.write(Paths.get(SAVE_FILENAME), json.getBytes());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
