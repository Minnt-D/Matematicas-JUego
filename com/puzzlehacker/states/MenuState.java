package com.puzzlehacker.states;

import com.puzzlehacker.core.StateManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class MenuState extends GameState implements KeyListener {

    private final String[] options = {"Continuar", "Nueva misión", "Ajustes", "Créditos", "Salir"};
    private int currentChoice = 0;

    public MenuState(StateManager stateManager) {
        super(stateManager);

        // Añadimos un listener de teclado global
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(event -> {
            if (event.getID() == KeyEvent.KEY_PRESSED) {
                handleKeyPressed(event.getKeyCode());
            }
            return false;
        });
    }

    @Override
    public String getName() {
        return "Menu";
    }

    @Override
    public void enter() {
        currentChoice = 0;
    }

    @Override
    public void update() {
        // Aquí no hay lógica pesada, solo navegación de menú
    }

    @Override
    public void render(Graphics2D g2d) {
        // Fondo oscuro
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 700, 500);

        // Título
        g2d.setColor(Color.GREEN);
        g2d.setFont(new Font("Monospaced", Font.BOLD, 36));
        g2d.drawString("PuzzleHacker", 200, 120);

        // Opciones
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 20));
        for (int i = 0; i < options.length; i++) {
            if (i == currentChoice) {
                g2d.setColor(Color.GREEN);
                g2d.drawString("> " + options[i], 260, 220 + i * 40);
            } else {
                g2d.setColor(Color.WHITE);
                g2d.drawString("  " + options[i], 260, 220 + i * 40);
            }
        }
    }

    @Override
    public void handleInput(String input) {
        // El menú no usa input de texto, solo teclado
    }

    private void handleKeyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_UP) {
            currentChoice--;
            if (currentChoice < 0) currentChoice = options.length - 1;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            currentChoice++;
            if (currentChoice >= options.length) currentChoice = 0;
        } else if (keyCode == KeyEvent.VK_ENTER) {
            selectOption();
        }
    }

    private void selectOption() {
        String choice = options[currentChoice];
        switch (choice) {
            case "Continuar" -> stateManager.setState("Play");
            case "Nueva misión" -> stateManager.setState("Play"); // Aquí se reinicia la partida
            case "Ajustes" -> stateManager.setState("Settings");
            case "Créditos" -> stateManager.setState("Credits");
            case "Salir" -> System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }
}
