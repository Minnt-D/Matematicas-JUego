package com.puzzlehacker.states;

import com.puzzlehacker.core.StateManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SettingsState extends GameState {

    private String[] colors = {"WHITE", "GREEN", "BLUE", "RED", "PINK"};
    private Color[] colorValues = {
            Color.WHITE,
            new Color(0, 255, 70), // verde hacker
            Color.CYAN,
            Color.RED,
            Color.PINK
    };

    private String[] languages = {"ESPAÑOL", "ENGLISH"};
    private int selectedColor = 0;
    private int selectedLanguage = 0;

    private int optionIndex = 0;
    private String[] options = {"Idioma / Language", "Color de Texto", "Volver"};

    public SettingsState(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    public String getName() {
        return "Settings";
    }

    @Override
    public void update() {
        // No hay lógica compleja, solo redibujar
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 700, 500);

        g2d.setFont(new Font("Monospaced", Font.BOLD, 20));
        g2d.setColor(colorValues[selectedColor]);
        g2d.drawString("=== CONFIGURACIÓN / SETTINGS ===", 180, 60);

        g2d.setFont(new Font("Monospaced", Font.PLAIN, 16));

        for (int i = 0; i < options.length; i++) {
            if (i == optionIndex) {
                g2d.setColor(Color.YELLOW);
            } else {
                g2d.setColor(colorValues[selectedColor]);
            }

            int y = 150 + i * 40;
            g2d.drawString(options[i], 100, y);

            if (i == 0) {
                g2d.drawString(": " + languages[selectedLanguage], 400, y);
            } else if (i == 1) {
                g2d.drawString(": " + colors[selectedColor], 400, y);
            }
        }
    }

    @Override
    public void handleCommand(String command) {
        switch (command) {
            case "UP":
                optionIndex = (optionIndex - 1 + options.length) % options.length;
                break;
            case "DOWN":
                optionIndex = (optionIndex + 1) % options.length;
                break;
            case "ENTER":
                if (optionIndex == 0) {
                    // Cambiar idioma
                    selectedLanguage = (selectedLanguage + 1) % languages.length;
                } else if (optionIndex == 1) {
                    // Cambiar color
                    selectedColor = (selectedColor + 1) % colors.length;
                } else if (optionIndex == 2) {
                    // Volver al menú
                    stateManager.setState("Menu");
                }
                break;
            default:
                break;
        }
    }

    public Color getSelectedColor() {
        return colorValues[selectedColor];
    }

    public String getSelectedLanguage() {
        return languages[selectedLanguage];
    }
}
