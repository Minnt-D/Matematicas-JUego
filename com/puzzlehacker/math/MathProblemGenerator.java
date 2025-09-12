// src/com/puzzlehacker/math/MathProblemGenerator.java
package com.puzzlehacker.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MathProblemGenerator {
    private Random random;

    public MathProblemGenerator() {
        random = new Random();
    }

    public Map<String, Object> generateProblem(int level) {
        Map<String, Object> problem = new HashMap<>();

        switch (level) {
            case 1:
                problem = generateBasicArithmetic();
                break;
            case 2:
                problem = generateSequences();
                break;
            case 3:
                problem = generateSummation();
                break;
            case 4:
                problem = generateLogarithms();
                break;
            case 5:
                problem = generateIntegrals();
                break;
            case 6:
                problem = generateSetTheory();
                break;
            default:
                problem = generateBasicArithmetic();
        }

        return problem;
    }

    private Map<String, Object> generateBasicArithmetic() {
        Map<String, Object> problem = new HashMap<>();

        // Problemas predefinidos para consistencia
        String[] problems = {
                "15 + 27 × 3 - 8",
                "(45 + 15) ÷ 4 × 2",
                "√(144) + 8 × 3",
                "2³ + 5² - 7"
        };

        int[] answers = {88, 30, 36, 26};

        int index = random.nextInt(problems.length);

        problem.put("problem", "Resuelve la siguiente operación:\n\n  " + problems[index]);
        problem.put("answer", String.valueOf(answers[index]));
        problem.put("hint", "Recuerda el orden de las operaciones: paréntesis, exponentes, multiplicación/división, suma/resta");

        return problem;
    }

    private Map<String, Object> generateSequences() {
        Map<String, Object> problem = new HashMap<>();

        String[] problems = {
                "¿Cuál es el siguiente número en la secuencia?\n\n  2, 6, 12, 20, 30, ?",
                "Encuentra el patrón:\n\n  1, 4, 9, 16, 25, ?",
                "Secuencia Fibonacci:\n\n  1, 1, 2, 3, 5, 8, 13, ?",
                "Progresión aritmética:\n\n  7, 12, 17, 22, ?"
        };

        String[] answers = {"42", "36", "21", "27"};
        String[] hints = {
                "Diferencias: 4, 6, 8, 10... (suma números pares)",
                "Son números cuadrados perfectos: 1², 2², 3², 4², 5²...",
                "Cada número es la suma de los dos anteriores",
                "La diferencia común es 5"
        };

        int index = random.nextInt(problems.length);

        problem.put("problem", problems[index]);
        problem.put("answer", answers[index]);
        problem.put("hint", hints[index]);

        return problem;
    }

    private Map<String, Object> generateSummation() {
        Map<String, Object> problem = new HashMap<>();

        String[] problems = {
                "Calcula la sumatoria:\n\n  ∑(i=1 to 5) i²",
                "Resuelve:\n\n  ∑(k=0 to 4) (2k + 1)",
                "Encuentra:\n\n  ∑(n=1 to 6) (3n - 1)",
                "Calcula:\n\n  ∑(i=2 to 6) i(i-1)"
        };

        String[] answers = {"55", "25", "63", "70"};
        String[] hints = {
                "1² + 2² + 3² + 4² + 5² = 1 + 4 + 9 + 16 + 25",
                "1 + 3 + 5 + 7 + 9 (números impares)",
                "2 + 5 + 8 + 11 + 14 + 17",
                "2×1 + 3×2 + 4×3 + 5×4 + 6×5"
        };

        int index = random.nextInt(problems.length);

        problem.put("problem", problems[index]);
        problem.put("answer", answers[index]);
        problem.put("hint", hints[index]);

        return problem;
    }

    private Map<String, Object> generateLogarithms() {
        Map<String, Object> problem = new HashMap<>();

        String[] problems = {
                "Resuelve la ecuación logarítmica:\n\n  log₂(x) = 4",
                "Calcula:\n\n  log₁₀(1000) + log₁₀(10)",
                "Si log₃(x) = 2, entonces x = ?",
                "Simplifica:\n\n  ln(e³) + ln(e²)"
        };

        String[] answers = {"16", "4", "9", "5"};
        String[] hints = {
                "Si log₂(x) = 4, entonces 2⁴ = x",
                "log₁₀(1000) = 3 y log₁₀(10) = 1",
                "Si log₃(x) = 2, entonces 3² = x",
                "ln(e³) = 3 y ln(e²) = 2"
        };

        int index = random.nextInt(problems.length);

        problem.put("problem", problems[index]);
        problem.put("answer", answers[index]);
        problem.put("hint", hints[index]);

        return problem;
    }

    private Map<String, Object> generateIntegrals() {
        Map<String, Object> problem = new HashMap<>();

        String[] problems = {
                "Resuelve la integral definida:\n\n  ∫₀² x dx",
                "Calcula:\n\n  ∫₁³ (2x + 1) dx",
                "Encuentra:\n\n  ∫₀¹ x² dx",
                "Integral básica:\n\n  ∫₋₁¹ (x³ + 1) dx"
        };

        String[] answers = {"2", "12", "0.33", "2"};
        String[] hints = {
                "∫x dx = x²/2, evalúa de 0 a 2",
                "∫(2x+1)dx = x² + x, evalúa de 1 a 3",
                "∫x²dx = x³/3, evalúa de 0 a 1",
                "La integral de x³ es simétrica y se cancela"
        };

        int index = random.nextInt(problems.length);

        problem.put("problem", problems[index]);
        problem.put("answer", answers[index]);
        problem.put("hint", hints[index]);

        return problem;
    }

    private Map<String, Object> generateSetTheory() {
        Map<String, Object> problem = new HashMap<>();

        String[] problems = {
                "Dados los conjuntos:\n  A = {1, 2, 3, 4, 5}\n  B = {4, 5, 6, 7}\n\n  |A ∩ B| = ?",
                "Si |A| = 12, |B| = 8, |A ∩ B| = 3\n\n  |A ∪ B| = ?",
                "Conjunto potencia:\n  Si A = {1, 2}\n\n  |P(A)| = ?",
                "Dados:\n  U = {1,2,3,4,5,6,7,8,9,10}\n  A = {2,4,6,8,10}\n\n  |A'| = ?"
        };

        String[] answers = {"2", "17", "4", "5"};
        String[] hints = {
                "A ∩ B son los elementos comunes: {4, 5}",
                "Fórmula: |A ∪ B| = |A| + |B| - |A ∩ B|",
                "P(A) tiene 2^|A| elementos",
                "A' es el complemento de A en U"
        };

        int index = random.nextInt(problems.length);

        problem.put("problem", problems[index]);
        problem.put("answer", answers[index]);
        problem.put("hint", hints[index]);

        return problem;
    }
}