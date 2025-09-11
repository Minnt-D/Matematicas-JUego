# PuzzleHacker - Juego Educativo de Hackeo y Matemáticas

## Descripción del Juego

PuzzleHacker es un juego educativo estilo "puzzle-hacker" donde los jugadores asumen el rol de un hacker ético que debe infiltrar diferentes sistemas resolviendo problemas matemáticos. Cada nivel representa un desafío de hackeo diferente, desde redes sociales hasta sistemas militares clasificados.

## Características Principales

### Concepto del Juego
- **Temática**: Simulación de hackeo ético con interfaz estilo terminal
- **Mecánica**: Resolver problemas matemáticos para "desbloquear" sistemas
- **Progresión**: 6 niveles con dificultad creciente
- **Interfaz**: Terminal estilo CMD con efectos visuales

### Niveles de Dificultad
1. **Red Social** - Aritmética básica
2. **WiFi Corporativo** - Secuencias numéricas  
3. **Sistema POS** - Sumatorias ( ∑ )
4. **Banco** - Logaritmos
5. **Base Militar** - Integrales
6. **CIA/Pentágono** - Teoría de conjuntos

## Tecnologías Utilizadas

- **Lenguaje**: Java SE 8+
- **GUI**: Swing/Java2D
- **Arquitectura**: MVC + State Machine Pattern
- **Fuente**: Monospace (Consolas/Courier New)

## Estructura del Proyecto

```
PuzzleHacker/
├─ src/
│  └─ com/puzzlehacker/
│     ├─ main/
│     │   └─ Main.java                    # Punto de entrada
│     │
│     ├─ core/
│     │   ├─ Game.java                    # Clase principal del juego
│     │   ├─ StateManager.java            # Gestor de estados
│     │   └─ GameState.java               # Clase base para estados
│     │
│     ├─ states/
│     │   ├─ SplashState.java            # Pantalla de carga inicial
│     │   ├─ MenuState.java              # Menú principal
│     │   ├─ PlayState.java              # Estado de juego
│     │   ├─ SettingsState.java          # Configuraciones
│     │   └─ CreditsState.java           # Créditos del equipo
│     │
│     ├─ ui/
│     │   ├─ TerminalUI.java             # Interfaz estilo terminal
│     │   └─ ProgressBarUI.java          # Barras de progreso animadas
│     │
│     └─ math/
│         └─ MathProblemGenerator.java    # Generador de problemas
│
└─ README.md
```

## Características de la Interfaz

### Pantalla de Inicio (SplashState)
- Logo ASCII del juego "PUZZLEHACKER"
- Barra de carga animada simulando carga de archivos del sistema
- Efectos de texto estilo hacker

### Menú Principal (MenuState)
- **Continuar**: Reanuda partida guardada
- **Nueva Misión**: Inicia desde el nivel 1
- **Ajustes**: Configuración de idioma y colores
- **Créditos**: Información del equipo desarrollador
- **Salir**: Cierra la aplicación

### Configuraciones (SettingsState)
- **Idiomas**: Español, English
- **Colores de Texto**: 
  - Blanco
  - Verde Hacker (por defecto)
  - Azul
  - Rojo
  - Rosa

### Estado de Juego (PlayState)
#### Fases del Juego:
1. **Historia**: Narrativa del nivel con objetivos
2. **Hackeo**: Simulación de comandos de terminal
3. **Problema Matemático**: Desafío principal
4. **Resultado**: Éxito o fracaso de la misión

## Contenido Educativo

### Nivel 1 - Red Social (★☆☆☆☆☆)
- **Matemática**: Aritmética básica
- **Conceptos**: Orden de operaciones, potencias, raíces
- **Ejemplo**: `15 + 27 × 3 - 8 = ?`

### Nivel 2 - WiFi (★★☆☆☆☆)  
- **Matemática**: Secuencias y patrones
- **Conceptos**: Progresiones aritméticas, Fibonacci
- **Ejemplo**: `2, 6, 12, 20, 30, ?`

### Nivel 3 - Supermercado (★★★☆☆☆)
- **Matemática**: Sumatorias
- **Conceptos**: Notación sigma (∑)
- **Ejemplo**: `∑(i=1 to 5) i²`

### Nivel 4 - Banco (★★★★☆☆)
- **Matemática**: Logaritmos
- **Conceptos**: Propiedades logarítmicas
- **Ejemplo**: `log₂(x) = 4`

### Nivel 5 - Base Militar (★★★★★☆)
- **Matemática**: Integrales
- **Conceptos**: Cálculo integral básico
- **Ejemplo**: `∫₀² x dx`

### Nivel 6 - CIA/Pentágono (★★★★★★)
- **Matemática**: Teoría de conjuntos
- **Conceptos**: Unión, intersección, complemento
- **Ejemplo**: `|A ∩ B|` dados A y B

## Instalación y Ejecución

### Requisitos
- Java SE 8 o superior
- IDE compatible (IntelliJ IDEA, Eclipse, VS Code)

### Compilación
```bash
# Navegar al directorio del proyecto
cd PuzzleHacker/

# Compilar
javac -d bin -sourcepath src src/com/puzzlehacker/main/Main.java

# Ejecutar
java -cp bin com.puzzlehacker.main.Main
```

### Ejecución directa desde IDE
1. Importar el proyecto en tu IDE favorito
2. Ejecutar la clase `Main.java`
3. ¡Disfrutar del juego!

## Controles

### Menús
- **↑↓**: Navegar opciones
- **ENTER**: Seleccionar
- **ESC**: Volver/Salir

### Configuraciones
- **←→**: Cambiar valores
- **↑↓**: Navegar opciones

### Juego
- **Escribir**: Respuesta matemática
- **ENTER**: Confirmar respuesta
- **BACKSPACE**: Borrar
- **ESC**: Volver al menú

### Créditos
- **↑↓**: Desplazar
- **PAGE UP/DOWN**: Desplazamiento rápido
- **HOME/END**: Inicio/Final

## Equipo de Desarrollo

### Desarrolladores
- **Omar Alejandro Galvis Espitia**
  - Arquitectura del juego y sistema de estados
  - Interfaz de terminal y animaciones
  - Generador de problemas matemáticos

- **Julio César Ramírez Vega**
  - Sistema de niveles y progresión
  - Lógica de hackeo y narrativa
  - Optimización y rendimiento

- **Eli Santiago López Mahecha**
  - Diseño de interfaz de usuario
  - Sistema de configuración
  - Testing y debugging

- **Daphne Geysi Rivera Flores**
  - Contenido matemático y educativo
  - Balanceo de dificultad
  - Documentación del proyecto

### Institución
**Jala University** - Programa de Ingeniería de Software  
Proyecto Final - Curso de Programación Java (2025-1)

## Características Técnicas

### Optimizaciones Implementadas
- **Separación lógica/renderizado**: Estados independientes
- **Reutilización de recursos**: Componentes UI reutilizables
- **Gestión de memoria**: Límite de líneas en terminal
- **Rendering eficiente**: Solo redibuja cuando es necesario

### Patrones de Diseño
- **State Pattern**: Gestión de estados del juego
- **MVC**: Separación modelo-vista-controlador
- **Singleton**: Gestión de configuraciones globales

### Extensibilidad
- Fácil adición de nuevos niveles
- Sistema modular de problemas matemáticos
- Configuraciones expandibles
- Soporte multiidioma preparado

## Objetivos Educativos

### Programación
- Programación orientada a objetos
- Patrones de diseño
- Interfaces gráficas con Swing
- Manejo de eventos
- Arquitectura de software

### Matemáticas
- Aritmética y álgebra básica
- Secuencias y patrones
- Sumatorias y series
- Logaritmos y exponenciales
- Cálculo integral
- Teoría de conjuntos

### Habilidades Transversales
- Resolución de problemas
- Pensamiento lógico
- Trabajo en equipo
- Documentación de proyectos

## Contribuciones

Este proyecto fue desarrollado con fines educativos para Jala University. Las contribuciones y mejoras son bienvenidas para fines educativos.

## Disclaimer

PuzzleHacker es un juego educativo creado con fines puramente académicos. No promueve actividades ilegales reales y es una simulación educativa para aprender programación y matemáticas de manera interactiva.

---

**¡Gracias por jugar PuzzleHacker!** 

Para más información: github.com/jala-university
