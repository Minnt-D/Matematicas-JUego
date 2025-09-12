package com.puzzlehacker.core;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * ThemeManager - Gestiona idioma y colores para todo el juego.
 */
public class ThemeManager {

    // Singleton
    private static ThemeManager instance;

    public static ThemeManager getInstance() {
        if (instance == null) {
            instance = new ThemeManager();
        }
        return instance;
    }

    // Idiomas disponibles
    public enum Language {
        SPANISH, ENGLISH
    }

    // Colores disponibles
    public enum TextColor {
        WHITE(Color.WHITE),
        GREEN(new Color(0, 255, 70)),  // verde hacker
        BLUE(Color.CYAN),
        RED(Color.RED),
        PINK(Color.PINK);

        private final Color color;

        TextColor(Color c) {
            this.color = c;
        }

        public Color getColor() {
            return color;
        }
    }

    // Estado actual
    private Language currentLanguage = Language.SPANISH;
    private TextColor currentColor = TextColor.GREEN;
    private Font currentFont = new Font("Monospaced", Font.PLAIN, 16);

    // Diccionario simple para traducciones
    private final Map<String, String> spanishMap = new HashMap<>();
    private final Map<String, String> englishMap = new HashMap<>();

    private ThemeManager() {
        loadTranslations();
    }

    /**
     * Traducciones base
     */
    private void loadTranslations() {
        // Español
        spanishMap.put("menu.continue", "Continuar");
        spanishMap.put("menu.newMission", "Nueva Misión");
        spanishMap.put("menu.settings", "Ajustes");
        spanishMap.put("menu.credits", "Créditos");
        spanishMap.put("menu.exit", "Salir");
        spanishMap.put("settings.title", "Configuración");
        spanishMap.put("credits.title", "Créditos");

        // Inglés
        englishMap.put("menu.continue", "Continue");
        englishMap.put("menu.newMission", "New Mission");
        englishMap.put("menu.settings", "Settings");
        englishMap.put("menu.credits", "Credits");
        englishMap.put("menu.exit", "Exit");
        englishMap.put("settings.title", "Settings");
        englishMap.put("credits.title", "Credits");
    }

    /**
     * Devuelve un texto traducido según idioma actual
     */
    public String t(String key) {
        if (currentLanguage == Language.SPANISH) {
            return spanishMap.getOrDefault(key, key);
        } else {
            return englishMap.getOrDefault(key, key);
        }
    }

    public Language getCurrentLanguage() {
        return currentLanguage;
    }

    public void setCurrentLanguage(Language lang) {
        this.currentLanguage = lang;
    }

    public TextColor getCurrentTextColor() {
        return currentColor;
    }

    public void setCurrentTextColor(TextColor color) {
        this.currentColor = color;
    }

    public Color getColor() {
        return currentColor.getColor();
    }

    public Font getFont() {
        return currentFont;
    }

    public void setFont(Font font) {
        this.currentFont = font;
    }
}
