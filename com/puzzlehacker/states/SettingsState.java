// src/com/puzzlehacker/states/SettingsState.java
package com.puzzlehacker.states;

import com.puzzlehacker.core.GameState;
import com.puzzlehacker.core.StateManager;

import java.awt.event.KeyEvent;

public class SettingsState extends GameState {
    private int selectedOption = 0;
    private final String[] settingsOptions = {"IDIOMA", "COLOR DE TEXTO", "VOLVER"};
    private final String[] languages = {"Español", "English"};
    private final String[] colors = {"BLANCO", "VERDE", "AZUL", "ROJO", "ROSA"};
    private int currentLanguageIndex;
    private int currentColorIndex;

    public SettingsState(StateManager stateManager) {
        super(stateManager);

        // Inicializar índices actuales
        String currentLang = stateManager.getGame().getCurrentLanguage();
        currentLanguageIndex = currentLang.equals("en") ? 1 : 0;

        String currentColor = stateManager.getGame().getCurrentTextColor();
        switch (currentColor) {
            case "WHITE": currentColorIndex = 0; break;
            case "GREEN": currentColorIndex = 1; break;
            case "BLUE": currentColorIndex = 2; break;
            case "RED": currentColorIndex = 3; break;
            case "PINK": currentColorIndex = 4; break;
            default: currentColorIndex = 1; // Verde por defecto
        }
    }

    @Override
    public void enter() {
        showSettings();
    }

    private void showSettings() {
        stateManager.getTerminal().clearScreen();
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  ╔══════════════════════════════════════════════════════════╗");
        stateManager.getTerminal().printLine("  ║                       AJUSTES                            ║");
        stateManager.getTerminal().printLine("  ╚══════════════════════════════════════════════════════════╝");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  Configuración del sistema:");
        stateManager.getTerminal().printLine("");

        for (int i = 0; i < settingsOptions.length; i++) {
            String prefix = (i == selectedOption) ? "  > " : "    ";
            String option = settingsOptions[i];
            String value = "";

            if (option.equals("IDIOMA")) {
                value = " [" + languages[currentLanguageIndex] + "]";
            } else if (option.equals("COLOR DE TEXTO")) {
                value = " [" + colors[currentColorIndex] + "]";
            }

            stateManager.getTerminal().printLine(prefix + option + value);
        }

        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  ┌────────────────────────────────────────────────────────┐");
        stateManager.getTerminal().printLine("  │ ↑↓ Navegar  ←→ Cambiar valor  ENTER Confirmar  ESC Salir │");
        stateManager.getTerminal().printLine("  └────────────────────────────────────────────────────────┘");
        stateManager.getTerminal().printLine("");

        // Mostrar información adicional según la opción seleccionada
        switch (selectedOption) {
            case 0: // IDIOMA
                stateManager.getTerminal().printLine("  Cambia el idioma de la interfaz del juego.");
                stateManager.getTerminal().printLine("  Disponible: Español, English");
                break;
            case 1: // COLOR DE TEXTO
                stateManager.getTerminal().printLine("  Personaliza el color del texto de la terminal.");
                stateManager.getTerminal().printLine("  Colores: Blanco, Verde hacker, Azul, Rojo, Rosa");
                break;
            case 2: // VOLVER
                stateManager.getTerminal().printLine("  Regresar al menú principal.");
                break;
        }
    }

    @Override
    public void update() {
        // Los ajustes no necesitan actualizaciones continuas
    }

    @Override
    public void render() {
        // La renderización se maneja en TerminalUI
    }

    @Override
    public void exit() {
        // Guardar configuraciones si fuera necesario
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                selectedOption = (selectedOption - 1 + settingsOptions.length) % settingsOptions.length;
                showSettings();
                break;

            case KeyEvent.VK_DOWN:
                selectedOption = (selectedOption + 1) % settingsOptions.length;
                showSettings();
                break;

            case KeyEvent.VK_LEFT:
                if (selectedOption == 0) { // IDIOMA
                    currentLanguageIndex = (currentLanguageIndex - 1 + languages.length) % languages.length;
                    updateLanguage();
                } else if (selectedOption == 1) { // COLOR
                    currentColorIndex = (currentColorIndex - 1 + colors.length) % colors.length;
                    updateTextColor();
                }
                showSettings();
                break;

            case KeyEvent.VK_RIGHT:
                if (selectedOption == 0) { // IDIOMA
                    currentLanguageIndex = (currentLanguageIndex + 1) % languages.length;
                    updateLanguage();
                } else if (selectedOption == 1) { // COLOR
                    currentColorIndex = (currentColorIndex + 1) % colors.length;
                    updateTextColor();
                }
                showSettings();
                break;

            case KeyEvent.VK_ENTER:
                if (selectedOption == 2) { // VOLVER
                    stateManager.setState(new MenuState(stateManager));
                }
                break;

            case KeyEvent.VK_ESCAPE:
                stateManager.setState(new MenuState(stateManager));
                break;
        }
    }

    private void updateLanguage() {
        String newLang = currentLanguageIndex == 0 ? "es" : "en";
        stateManager.getGame().setCurrentLanguage(newLang);
    }

    private void updateTextColor() {
        String[] colorCodes = {"WHITE", "GREEN", "BLUE", "RED", "PINK"};
        stateManager.getGame().setCurrentTextColor(colorCodes[currentColorIndex]);
    }
}