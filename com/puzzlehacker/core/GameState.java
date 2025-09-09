// src/com/puzzlehacker/core/GameState.java
package com.puzzlehacker.core;

import java.awt.event.KeyEvent;

public abstract class GameState {
    protected StateManager stateManager;

    public GameState(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public abstract void enter();
    public abstract void update();
    public abstract void render();
    public abstract void exit();

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}