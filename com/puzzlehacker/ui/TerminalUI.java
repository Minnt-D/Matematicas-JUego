// src/com/puzzlehacker/ui/TerminalUI.java
package com.puzzlehacker.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TerminalUI extends JPanel {
    private List<String> lines;
    private Font terminalFont;
    private Color backgroundColor;
    private Color textColor;
    private String currentInputLine = "";
    private int maxLines = 25;

    public TerminalUI() {
        lines = new ArrayList<>();
        setupUI();
        setTextColor("GREEN"); // Verde por defecto
    }

    private void setupUI() {
        setBackground(Color.BLACK);
        backgroundColor = Color.BLACK;

        // Fuente monospace para simular terminal
        try {
            terminalFont = new Font("Consolas", Font.PLAIN, 14);
        } catch (Exception e) {
            try {
                terminalFont = new Font("Courier New", Font.PLAIN, 14);
            } catch (Exception e2) {
                terminalFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
            }
        }

        setFocusable(false);
    }

    public void setTextColor(String colorName) {
        switch (colorName.toUpperCase()) {
            case "WHITE":
                textColor = Color.WHITE;
                break;
            case "GREEN":
                textColor = new Color(0, 255, 0); // Verde brillante estilo hacker
                break;
            case "BLUE":
                textColor = new Color(0, 150, 255); // Azul brillante
                break;
            case "RED":
                textColor = new Color(255, 50, 50); // Rojo brillante
                break;
            case "PINK":
                textColor = new Color(255, 100, 200); // Rosa brillante
                break;
            default:
                textColor = new Color(0, 255, 0); // Verde por defecto
        }
        repaint();
    }

    public void clearScreen() {
        lines.clear();
        currentInputLine = "";
        repaint();
    }

    public void printLine(String line) {
        lines.add(line);

        // Limitar número de líneas para evitar overflow
        while (lines.size() > maxLines) {
            lines.remove(0);
        }

        repaint();
    }

    public void print(String text) {
        if (lines.isEmpty()) {
            lines.add(text);
        } else {
            int lastIndex = lines.size() - 1;
            lines.set(lastIndex, lines.get(lastIndex) + text);
        }
        repaint();
    }

    public void updateInputLine(String inputLine) {
        currentInputLine = inputLine;
        repaint();
    }

    public void updateMenuCursor(int selectedOption, String[] options, boolean showCursor) {
        // Método para actualizar cursor del menú sin redibujar todo
        // Se podría optimizar más, pero para simplicidad redibujamos
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Antialiasing para texto más suave
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(textColor);
        g2d.setFont(terminalFont);

        FontMetrics fm = g2d.getFontMetrics();
        int lineHeight = fm.getHeight();
        int startY = 20;

        // Dibujar todas las líneas
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            int y = startY + (i * lineHeight);

            // Solo dibujar líneas visibles
            if (y > 0 && y < getHeight()) {
                g2d.drawString(line, 10, y);
            }
        }

        // Dibujar línea de entrada actual si existe
        if (!currentInputLine.isEmpty()) {
            int y = startY + (lines.size() * lineHeight);
            if (y > 0 && y < getHeight()) {
                g2d.drawString(currentInputLine, 10, y);
            }
        }

        // Efecto de escanlines opcional (comentado para rendimiento)
        /*
        g2d.setColor(new Color(0, 255, 0, 10));
        for (int y = 0; y < getHeight(); y += 2) {
            g2d.drawLine(0, y, getWidth(), y);
        }
        */
    }

    public Color getTextColor() {
        return textColor;
    }

    public int getMaxLines() {
        return maxLines;
    }

    public void setMaxLines(int maxLines) {
        this.maxLines = maxLines;
    }
}