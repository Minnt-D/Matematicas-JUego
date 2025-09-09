// src/com/puzzlehacker/core/StateManager.java
package com.puzzlehacker.core;

import com.puzzlehacker.ui.TerminalUI;

public class StateManager {
    private GameState currentState;
    private Game game;
    private TerminalUI terminal;
    private int currentLevel = 1;
    private boolean[] levelsCompleted = new boolean[7]; // 6 niveles + índice 0

    public StateManager(Game game, TerminalUI terminal) {
        this.game = game;
        this.terminal = terminal;
    }

    public void setState(GameState newState) {
        if (currentState != null) {
            currentState.exit();
        }
        currentState = newState;
        if (currentState != null) {
            currentState.enter();
        }
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public Game getGame() {
        return game;
    }

    public TerminalUI getTerminal() {
        return terminal;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int level) {
        this.currentLevel = level;
    }

    public boolean isLevelCompleted(int level) {
        if (level < 1 || level > 6) return false;
        return levelsCompleted[level];
    }

    public void markLevelCompleted(int level) {
        if (level >= 1 && level <= 6) {
            levelsCompleted[level] = true;
        }
    }

    public boolean hasProgress() {
        for (int i = 1; i <= 6; i++) {
            if (levelsCompleted[i]) return true;
        }
        return false;
    }
}