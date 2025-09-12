package com.puzzlehacker.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * MathProblemGenerator - Genera ejercicios matemáticos según el nivel de dificultad.
 * Los problemas se clasifican en: SUMMATION, LOGARITHM, SETS, INTEGRAL.
 */
public class MathProblemGenerator {

    private static final Random random = new Random();

    /**
     * Genera una lista de problemas según el nivel de dificultad.
     * Cada nivel contiene 10 problemas predefinidos o generados.
     */
    public static List<Problem> generateProblems(int level) {
        List<Problem> problems = new ArrayList<>();

        switch (level) {
            case 1 -> { // Nivel básico - solo sumatorias simples
                for (int i = 0; i < 10; i++) {
                    problems.add(generateSummationProblem());
                }
            }
            case 2 -> { // Nivel intermedio - sumatorias y logaritmos
                for (int i = 0; i < 5; i++) problems.add(generateSummationProblem());
                for (int i = 0; i < 5; i++) problems.add(generateLogarithmProblem());
            }
            case 3 -> { // Nivel intermedio - conjuntos + sumatorias
                for (int i = 0; i < 4; i++) problems.add(generateSummationProblem());
                for (int i = 0; i < 6; i++) problems.add(generateSetProblem());
            }
            case 4 -> { // Avanzado - logaritmos + conjuntos
                for (int i = 0; i < 5; i++) problems.add(generateLogarithmProblem());
                for (int i = 0; i < 5; i++) problems.add(generateSetProblem());
            }
            case 5 -> { // Muy avanzado - integrales + logaritmos
                for (int i = 0; i < 5; i++) problems.add(generateIntegralProblem());
                for (int i = 0; i < 5; i++) problems.add(generateLogarithmProblem());
            }
            case 6 -> { // Hacker mode - integrales, logaritmos, conjuntos
                for (int i = 0; i < 3; i++) problems.add(generateIntegralProblem());
                for (int i = 0; i < 3; i++) problems.add(generateLogarithmProblem());
                for (int i = 0; i < 4; i++) problems.add(generateSetProblem());
            }
            default -> throw new IllegalArgumentException("Nivel inválido: " + level);
        }

        return problems;
    }

    // ------------------------
    // Generadores de problemas
    // ------------------------

    private static Problem generateSummationProblem() {
        int n = random.nextInt(10) + 5; // n entre 5 y 15
        int result = (n * (n + 1)) / 2; // fórmula de Gauss
        return new Problem(
                "Calcule la sumatoria: 1 + 2 + ... + " + n,
                String.valueOf(result),
                "Pista: Fórmula de Gauss n(n+1)/2",
                Problem.ProblemType.SUMMATION
        );
    }

    private static Problem generateLogarithmProblem() {
        int base = 2;
        int exp = random.nextInt(4) + 2; // 2^2 hasta 2^5
        int value = (int) Math.pow(base, exp);
        return new Problem(
                "Resuelva: log_" + base + "(" + value + ")",
                String.valueOf(exp),
                "Pista: log_b(b^n) = n",
                Problem.ProblemType.LOGARITHM
        );
    }

    private static Problem generateSetProblem() {
        // Pequeño ejercicio de conjuntos
        String statement = "Sea A={1,2,3,4}, B={3,4,5,6}. ¿Cuál es A ∩ B?";
        String answer = "{3,4}";
        return new Problem(
                statement,
                answer,
                "Pista: ∩ significa intersección.",
                Problem.ProblemType.SETS
        );
    }

    private static Problem generateIntegralProblem() {
        // Problema fijo para simplificar
        String statement = "Calcule la integral ∫ x dx (de 0 a 2)";
        String answer = "2"; // ∫ x dx = x^2/2, evaluado entre 0 y 2 -> 2
        return new Problem(
                statement,
                answer,
                "Pista: Usa la fórmula ∫ x dx = x^2/2",
                Problem.ProblemType.INTEGRAL
        );
    }
}
