// src/com/puzzlehacker/states/PlayState.java
package com.puzzlehacker.states;

import com.puzzlehacker.core.GameState;
import com.puzzlehacker.core.StateManager;
import com.puzzlehacker.math.MathProblemGenerator;

import java.awt.event.KeyEvent;
import java.util.Map;

public class PlayState extends GameState {
    private enum Phase { STORY, HACKING, MATH_PROBLEM, SUCCESS, FAILURE }

    private Phase currentPhase;
    private String userInput = "";
    private boolean showCursor = true;
    private long lastCursorBlink = System.currentTimeMillis();
    private MathProblemGenerator mathGen;
    private Map<String, Object> currentProblem;
    private String correctAnswer;
    private int attempts = 0;
    private final int maxAttempts = 3;
    private long hackingStartTime;
    private boolean hackingComplete = false;

    public PlayState(StateManager stateManager) {
        super(stateManager);
        mathGen = new MathProblemGenerator();
    }

    @Override
    public void enter() {
        currentPhase = Phase.STORY;
        showStory();
    }

    private void showStory() {
        stateManager.getTerminal().clearScreen();
        int level = stateManager.getCurrentLevel();

        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  ╔══════════════════════════════════════════════════════════╗");
        stateManager.getTerminal().printLine("  ║                    MISIÓN " + level + "/6                           ║");
        stateManager.getTerminal().printLine("  ╚══════════════════════════════════════════════════════════╝");
        stateManager.getTerminal().printLine("");

        String[] stories = getStoryForLevel(level);
        for (String line : stories) {
            stateManager.getTerminal().printLine("  " + line);
        }

        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  [PRESIONE ENTER PARA INICIAR EL HACKEO]");
    }

    private String[] getStoryForLevel(int level) {
        switch (level) {
            case 1:
                return new String[]{
                        "OBJETIVO: Infiltrar red social 'SocialNet'",
                        "",
                        "La empresa SocialNet ha estado censurando información crítica",
                        "sobre violaciones de privacidad. Necesitas acceder a su",
                        "servidor principal para exponer la verdad.",
                        "",
                        "DIFICULTAD: ★☆☆☆☆☆",
                        "SISTEMA: Ubuntu Server 18.04",
                        "FIREWALL: Básico",
                        "ENCRIPTACIÓN: MD5 (vulnerada)"
                };
            case 2:
                return new String[]{
                        "OBJETIVO: Romper cifrado WiFi 'SecureNet_Corp'",
                        "",
                        "Una corporación está bloqueando el acceso libre a internet",
                        "en zonas públicas. Su red WiFi usa WPA2 con contraseñas",
                        "basadas en patrones matemáticos.",
                        "",
                        "DIFICULTAD: ★★☆☆☆☆",
                        "SISTEMA: Router Cisco Enterprise",
                        "SEGURIDAD: WPA2-PSK",
                        "PATRÓN: Secuencias numéricas"
                };
            case 3:
                return new String[]{
                        "OBJETIVO: Sistema POS SuperMarket 'MegaStore'",
                        "",
                        "MegaStore está inflando precios artificialmente mediante",
                        "algoritmos en su sistema POS. Necesitas acceder a sus",
                        "bases de datos para obtener evidencia.",
                        "",
                        "DIFICULTAD: ★★★☆☆☆",
                        "SISTEMA: Windows Server 2019",
                        "BASE DE DATOS: SQL Server",
                        "CIFRADO: AES-128"
                };
            case 4:
                return new String[]{
                        "OBJETIVO: Banco 'SecureBank' - Servidor de transacciones",
                        "",
                        "SecureBank ha estado realizando transacciones fraudulentas",
                        "microscópicas robando centavos de millones de cuentas.",
                        "Necesitas acceso a los logs de transacciones.",
                        "",
                        "DIFICULTAD: ★★★★☆☆",
                        "SISTEMA: RedHat Enterprise Linux",
                        "SEGURIDAD: Biométrica + 2FA",
                        "CIFRADO: RSA-2048"
                };
            case 5:
                return new String[]{
                        "OBJETIVO: Base Militar 'Fort Cipher' - Red interna",
                        "",
                        "La base militar está desarrollando armas autónomas que",
                        "violan tratados internacionales. Necesitas infiltrarte",
                        "en su red clasificada para obtener pruebas.",
                        "",
                        "DIFICULTAD: ★★★★★☆",
                        "SISTEMA: Clasificado (UNIX-based)",
                        "SEGURIDAD: Quantum Encryption",
                        "CONTRAMEDIDAS: IDS/IPS Avanzado"
                };
            case 6:
                return new String[]{
                        "OBJETIVO: CIA/Pentágono - 'PRISM Server'",
                        "",
                        "El servidor PRISM contiene evidencia de vigilancia masiva",
                        "ilegal de ciudadanos. Esta es la misión más peligrosa:",
                        "un solo error podría exposar tu identidad.",
                        "",
                        "DIFICULTAD: ★★★★★★",
                        "SISTEMA: Clasificado TOP SECRET",
                        "SEGURIDAD: Cuántica + IA Defensiva",
                        "RIESGO: EXTREMO"
                };
            default:
                return new String[]{"ERROR: Misión no encontrada"};
        }
    }

    private void startHacking() {
        currentPhase = Phase.HACKING;
        hackingStartTime = System.currentTimeMillis();
        hackingComplete = false;
        showHackingSequence();
    }

    private void showHackingSequence() {
        stateManager.getTerminal().clearScreen();
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  Iniciando secuencia de hackeo...");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  root@kali:~# nmap -sS -O target.system");
        stateManager.getTerminal().printLine("  Starting Nmap scan...");
        stateManager.getTerminal().printLine("  PORT     STATE SERVICE");
        stateManager.getTerminal().printLine("  22/tcp   open  ssh");
        stateManager.getTerminal().printLine("  80/tcp   open  http");
        stateManager.getTerminal().printLine("  443/tcp  open  https");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  root@kali:~# sqlmap -u target.system --dbs");
        stateManager.getTerminal().printLine("  [INFO] Testing connection...");
        stateManager.getTerminal().printLine("  [INFO] SQL injection found!");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  root@kali:~# hydra -l admin -P passwords.txt ssh://target");
        stateManager.getTerminal().printLine("  [ATTEMPT] target:22 ssh - admin:admin123");
        stateManager.getTerminal().printLine("  [ATTEMPT] target:22 ssh - admin:password");
        stateManager.getTerminal().printLine("  [ATTEMPT] target:22 ssh - admin:123456");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  ¡ACCESO PARCIAL OBTENIDO!");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  Sin embargo, el archivo principal está protegido por");
        stateManager.getTerminal().printLine("  un sistema de cifrado matemático...");
    }

    private void showMathProblem() {
        currentPhase = Phase.MATH_PROBLEM;
        currentProblem = mathGen.generateProblem(stateManager.getCurrentLevel());
        correctAnswer = currentProblem.get("answer").toString();

        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  ╔══════════════════════════════════════════════════════════╗");
        stateManager.getTerminal().printLine("  ║               SISTEMA DE CIFRADO DETECTADO               ║");
        stateManager.getTerminal().printLine("  ╚══════════════════════════════════════════════════════════╝");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  Para desbloquear el archivo, debe resolver el siguiente");
        stateManager.getTerminal().printLine("  problema matemático:");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  " + currentProblem.get("problem"));
        stateManager.getTerminal().printLine("");

        if (currentProblem.containsKey("hint")) {
            stateManager.getTerminal().printLine("  PISTA: " + currentProblem.get("hint"));
            stateManager.getTerminal().printLine("");
        }

        stateManager.getTerminal().printLine("  Intentos restantes: " + (maxAttempts - attempts));
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().print("  cipher_key> " + userInput);
    }

    private void checkAnswer() {
        if (userInput.trim().equals(correctAnswer)) {
            attempts = 0;
            showSuccess();
        } else {
            attempts++;
            if (attempts >= maxAttempts) {
                showFailure();
            } else {
                stateManager.getTerminal().printLine("");
                stateManager.getTerminal().printLine("  ¡ACCESO DENEGADO! Respuesta incorrecta.");
                stateManager.getTerminal().printLine("  Sistema de seguridad activado...");
                stateManager.getTerminal().printLine("");
                showMathProblem();
            }
        }
        userInput = "";
    }

    private void showSuccess() {
        currentPhase = Phase.SUCCESS;
        stateManager.getTerminal().clearScreen();
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  ╔══════════════════════════════════════════════════════════╗");
        stateManager.getTerminal().printLine("  ║                   ¡HACKEO EXITOSO!                      ║");
        stateManager.getTerminal().printLine("  ╚══════════════════════════════════════════════════════════╝");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  cipher_key> " + correctAnswer);
        stateManager.getTerminal().printLine("  ¡ACCESO CONCEDIDO!");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  Descifrando archivos...");
        stateManager.getTerminal().printLine("  [████████████████████████████████████████] 100%");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  Archivos comprometidos exitosamente:");

        String[] files = getCompromisedFiles(stateManager.getCurrentLevel());
        for (String file : files) {
            stateManager.getTerminal().printLine("  ✓ " + file);
        }

        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  Misión " + stateManager.getCurrentLevel() + "/6 completada.");
        stateManager.getTerminal().printLine("  Experiencia ganada: " + (stateManager.getCurrentLevel() * 100) + " XP");
        stateManager.getTerminal().printLine("");

        // Marcar nivel como completado
        stateManager.markLevelCompleted(stateManager.getCurrentLevel());

        if (stateManager.getCurrentLevel() < 6) {
            stateManager.getTerminal().printLine("  [ENTER] Siguiente misión  [ESC] Menú principal");
        } else {
            stateManager.getTerminal().printLine("  ¡FELICIDADES! Has completado todas las misiones.");
            stateManager.getTerminal().printLine("  [ESC] Volver al menú principal");
        }
    }

    private void showFailure() {
        currentPhase = Phase.FAILURE;
        stateManager.getTerminal().clearScreen();
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  ╔══════════════════════════════════════════════════════════╗");
        stateManager.getTerminal().printLine("  ║                 ¡HACKEO FALLIDO!                        ║");
        stateManager.getTerminal().printLine("  ╚══════════════════════════════════════════════════════════╝");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  ¡SISTEMA DE SEGURIDAD ACTIVADO!");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  [ALERTA] Múltiples intentos de acceso fallidos detectados");
        stateManager.getTerminal().printLine("  [ALERTA] Iniciando rastreo de IP...");
        stateManager.getTerminal().printLine("  [ALERTA] Contactando autoridades locales...");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  Tu conexión ha sido bloqueada por 24 horas.");
        stateManager.getTerminal().printLine("  La respuesta correcta era: " + correctAnswer);
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  [ENTER] Reintentar misión  [ESC] Menú principal");
    }

    private String[] getCompromisedFiles(int level) {
        switch (level) {
            case 1:
                return new String[]{
                        "user_private_messages.db",
                        "censorship_logs.txt",
                        "admin_passwords.txt",
                        "privacy_violations.pdf"
                };
            case 2:
                return new String[]{
                        "wifi_config.xml",
                        "network_topology.json",
                        "blocked_sites_list.txt",
                        "traffic_analysis.log"
                };
            case 3:
                return new String[]{
                        "price_manipulation.sql",
                        "customer_data.db",
                        "profit_margins.xlsx",
                        "supplier_contracts.pdf"
                };
            case 4:
                return new String[]{
                        "micro_transactions.log",
                        "account_balances.db",
                        "fraud_algorithm.py",
                        "executive_emails.pst"
                };
            case 5:
                return new String[]{
                        "weapons_research.pdf",
                        "classified_projects.xml",
                        "international_violations.doc",
                        "command_structure.db"
                };
            case 6:
                return new String[]{
                        "prism_database.db",
                        "surveillance_targets.xml",
                        "operation_files.zip",
                        "government_secrets.7z"
                };
            default:
                return new String[]{"unknown_files.txt"};
        }
    }

    @Override
    public void update() {
        // Cursor parpadeante
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastCursorBlink > 500) {
            showCursor = !showCursor;
            lastCursorBlink = currentTime;
            if (currentPhase == Phase.MATH_PROBLEM) {
                updateMathInput();
            }
        }

        // Simular progreso de hacking
        if (currentPhase == Phase.HACKING && !hackingComplete) {
            if (currentTime - hackingStartTime > 3000) {
                hackingComplete = true;
                showMathProblem();
            }
        }
    }

    private void updateMathInput() {
        // Actualizar la línea de entrada con cursor parpadeante
        String cursor = showCursor ? "_" : " ";
        stateManager.getTerminal().updateInputLine("  cipher_key> " + userInput + cursor);
    }

    @Override
    public void render() {
        // La renderización se maneja en TerminalUI
    }

    @Override
    public void exit() {
        // Limpiar recursos si es necesario
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (currentPhase) {
            case STORY:
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    startHacking();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    stateManager.setState(new MenuState(stateManager));
                }
                break;

            case MATH_PROBLEM:
                handleMathInput(e);
                break;

            case SUCCESS:
                if (e.getKeyCode() == KeyEvent.VK_ENTER && stateManager.getCurrentLevel() < 6) {
                    stateManager.setCurrentLevel(stateManager.getCurrentLevel() + 1);
                    stateManager.setState(new PlayState(stateManager));
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    stateManager.setState(new MenuState(stateManager));
                }
                break;

            case FAILURE:
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    attempts = 0;
                    stateManager.setState(new PlayState(stateManager));
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    stateManager.setState(new MenuState(stateManager));
                }
                break;
        }
    }

    private void handleMathInput(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            checkAnswer();
        } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (!userInput.isEmpty()) {
                userInput = userInput.substring(0, userInput.length() - 1);
                updateMathInput();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            stateManager.setState(new MenuState(stateManager));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (currentPhase == Phase.MATH_PROBLEM) {
            char c = e.getKeyChar();
            if ((Character.isDigit(c) || c == '.' || c == '-' || c == '+' ||
                    c == '*' || c == '/' || c == '(' || c == ')' || c == ' ') &&
                    userInput.length() < 50) {
                userInput += c;
                updateMathInput();
            }
        }
    }
}