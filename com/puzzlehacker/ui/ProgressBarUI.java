// src/com/puzzlehacker/ui/ProgressBarUI.java
package com.puzzlehacker.ui;

public class ProgressBarUI {

    public String getProgressBar(int percentage, int width) {
        if (percentage < 0) percentage = 0;
        if (percentage > 100) percentage = 100;

        int filled = (percentage * width) / 100;
        int empty = width - filled;

        StringBuilder bar = new StringBuilder();
        bar.append("  [");

        // Parte llena
        for (int i = 0; i < filled; i++) {
            bar.append("█");
        }

        // Parte vacía
        for (int i = 0; i < empty; i++) {
            bar.append("░");
        }

        bar.append("] ");
        bar.append(String.format("%3d%%", percentage));

        return bar.toString();
    }

    public String getProgressBarAnimated(int percentage, int width, long time) {
        if (percentage < 0) percentage = 0;
        if (percentage > 100) percentage = 100;

        int filled = (percentage * width) / 100;
        int empty = width - filled;

        StringBuilder bar = new StringBuilder();
        bar.append("  [");

        // Parte llena
        for (int i = 0; i < filled; i++) {
            // Animación con diferentes caracteres según el tiempo
            char fillChar = getAnimatedFillChar(time, i);
            bar.append(fillChar);
        }

        // Parte vacía
        for (int i = 0; i < empty; i++) {
            bar.append("░");
        }

        bar.append("] ");
        bar.append(String.format("%3d%%", percentage));

        return bar.toString();
    }

    private char getAnimatedFillChar(long time, int position) {
        // Crear efecto de "flujo" en la barra de progreso
        char[] chars = {'█', '▉', '▊', '▋', '▌', '▍', '▎', '▏'};
        int index = (int)((time / 100 + position) % chars.length);
        return chars[index];
    }

    public String getLoadingSpinner(long time) {
        char[] spinner = {'|', '/', '-', '\\'};
        int index = (int)((time / 200) % spinner.length);
        return String.valueOf(spinner[index]);
    }

    public String getDotsAnimation(long time, int maxDots) {
        int dots = (int)((time / 500) % (maxDots + 1));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dots; i++) {
            result.append(".");
        }
        return result.toString();
    }
}