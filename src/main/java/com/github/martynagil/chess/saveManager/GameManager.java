package com.github.martynagil.chess.saveManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.martynagil.chess.chessmen.Chessman;
import com.github.martynagil.chess.engine.Game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class GameManager {

    private static final Path SAVE_PATH = Paths.get("saveChess.json");

    private ObjectMapper objectMapper = new ObjectMapper();

    Scanner scanner = new Scanner(System.in);

    public void save(boolean whitePlaying, List<Chessman> chessmen) {
        GameState gameState = new GameState(
                whitePlaying,
                chessmen.stream()
                        .map(chessman -> new ChessmanState(
                                chessman.getColor(), chessman.getPosition().asString(), chessman.getType()
                        ))
                        .collect(toList())
        );

        try {
            String json = objectMapper.writeValueAsString(gameState);
            Files.write(SAVE_PATH, json.getBytes());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean saveExist() {
        return Files.exists(SAVE_PATH);
    }

    public void deleteSaveIfExists() {
        try {
            Files.deleteIfExists(SAVE_PATH);
        } catch (IOException e) {
        }
    }

    public GameState loadGame() {
        try {
            byte[] bytes = Files.readAllBytes(SAVE_PATH);
            return objectMapper.readValue(bytes, GameState.class);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
