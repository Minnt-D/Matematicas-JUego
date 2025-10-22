// ============ GAME DATA ============
const chapters = [
  {
    id: 0,
    title: 'Prólogo - El Llamado de Alerta',
    text: `Eres Neko, un estudiante de matemáticas en Jala University. 

Esta mañana despertaste con mensajes urgentes: las calificaciones de todos tus compañeros están siendo alteradas. Alguien ha infiltrado los sistemas de la universidad.

Tu misión: encontrar al hacker y restaurar el sistema. Para lograrlo, debes recolectar 7 piezas del enigma resolviendo problemas matemáticos en cada módulo comprometido.

¿Estás listo para comenzar?`,
    type: 'story',
    piece: null
  },
  {
    id: 1,
    title: 'Capítulo 1 - MeetPoint Comprometido',
    text: `Has detectado actividad sospechosa en MeetPoint, la plataforma de videoconferencias de la universidad.

Los logs muestran que alguien ha estado recopilando información durante las clases virtuales. Debes analizar los datos y desbloquear la primera pieza del enigma.

Completa los 10 ejercicios de SUMATORIAS para recuperar la pieza 🧩`,
    type: 'exercises',
    category: 'sumatorias',
    piece: 1,
    exercises: [
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 5) i',
        answer: '15',
        hint: 'Suma: 1+2+3+4+5',
        explanation: '1+2+3+4+5 = 15'
      },
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 4) i²',
        answer: '30',
        hint: '1²+2²+3²+4²',
        explanation: '1+4+9+16 = 30'
      },
      {
        type: 'choice',
        prompt: '¿Cuál es la fórmula para ∑(i=1 hasta n) i?',
        choices: [
          {text: 'n(n+1)/2', correct: true},
          {text: 'n²', correct: false},
          {text: 'n(n-1)/2', correct: false}
        ],
        explanation: 'La fórmula correcta es n(n+1)/2'
      },
      {
        type: 'input',
        prompt: 'Si ∑(i=1 hasta n) i = 55, ¿cuál es el valor de n?',
        answer: '10',
        hint: 'n(n+1)/2 = 55',
        explanation: 'n(n+1)/2 = 55 → n(n+1) = 110 → n = 10'
      },
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 3) (2i)',
        answer: '12',
        hint: '2(1) + 2(2) + 2(3)',
        explanation: '2+4+6 = 12'
      },
      {
        type: 'choice',
        prompt: '∑(i=1 hasta n) c (donde c es constante) es igual a:',
        choices: [
          {text: 'n·c', correct: true},
          {text: 'c', correct: false},
          {text: 'n+c', correct: false}
        ],
        explanation: 'Sumar c n veces da n·c'
      },
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 6) i',
        answer: '21',
        hint: 'Usa la fórmula n(n+1)/2',
        explanation: '6(7)/2 = 21'
      },
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 3) i³',
        answer: '36',
        hint: '1³+2³+3³',
        explanation: '1+8+27 = 36'
      },
      {
        type: 'choice',
        prompt: '∑(i=1 hasta 100) 1 es igual a:',
        choices: [
          {text: '100', correct: true},
          {text: '1', correct: false},
          {text: '5050', correct: false}
        ],
        explanation: 'Sumar 1 cien veces da 100'
      },
      {
        type: 'input',
        prompt: 'Si ∑(i=1 hasta n) i = 210, encuentra n',
        answer: '20',
        hint: 'n(n+1)/2 = 210',
        explanation: 'n(n+1) = 420 → n = 20'
      }
    ]
  },
  {
    id: 2,
    title: 'Capítulo 2 - Infiltración en Teams',
    text: `El rastro continúa en Microsoft Teams. El hacker ha dejado patrones en los canales de comunicación.

Necesitas aplicar INDUCCIÓN MATEMÁTICA para demostrar las propiedades que te ayudarán a rastrear al intruso.

Completa los 10 ejercicios de INDUCCIÓN para recuperar la pieza 🧩`,
    type: 'exercises',
    category: 'induccion',
    piece: 2,
    exercises: [
      {
        type: 'choice',
        prompt: '¿Cuál es el primer paso en una prueba por inducción?',
        choices: [
          {text: 'Caso base: probar P(1)', correct: true},
          {text: 'Asumir P(k)', correct: false},
          {text: 'Probar P(k+1)', correct: false}
        ],
        explanation: 'Siempre empezamos verificando el caso base P(1)'
      },
      {
        type: 'choice',
        prompt: 'En el paso inductivo, asumimos P(k) y debemos probar:',
        choices: [
          {text: 'P(k+1)', correct: true},
          {text: 'P(k-1)', correct: false},
          {text: 'P(1)', correct: false}
        ],
        explanation: 'El paso inductivo requiere probar P(k+1) asumiendo P(k)'
      },
      {
        type: 'input',
        prompt: 'Para n=1, verifica ∑(i=1 hasta 1) i = 1(1+1)/2. ¿Cuál es el resultado?',
        answer: '1',
        hint: 'Sustituye n=1 en la fórmula',
        explanation: '1(2)/2 = 1 El caso base es verdadero'
      },
      {
        type: 'choice',
        prompt: '¿Qué se llama "hipótesis inductiva"?',
        choices: [
          {text: 'Asumir que P(k) es verdadero', correct: true},
          {text: 'Probar el caso base', correct: false},
          {text: 'Concluir que P(n) es verdadero para todo n', correct: false}
        ],
        explanation: 'La hipótesis inductiva es la suposición de que P(k) es verdadero'
      },
      {
        type: 'choice',
        prompt: 'Para probar ∑(i=1 hasta n) i = n(n+1)/2 por inducción, el caso base es:',
        choices: [
          {text: 'n=1: 1 = 1(2)/2', correct: true},
          {text: 'n=0: 0 = 0', correct: false},
          {text: 'n=2: 3 = 2(3)/2', correct: false}
        ],
        explanation: 'Verificamos n=1 primero'
      },
      {
        type: 'input',
        prompt: 'Si P(k) = k², ¿cuál es P(k+1)?',
        answer: '(k+1)^2',
        hint: 'Sustituye k por k+1',
        explanation: 'P(k+1) = (k+1)²'
      },
      {
        type: 'choice',
        prompt: 'En inducción, después de probar el caso base y el paso inductivo:',
        choices: [
          {text: 'Concluimos que P(n) es verdadero para todo n≥1', correct: true},
          {text: 'Solo sabemos que P(1) es verdadero', correct: false},
          {text: 'Necesitamos probar cada caso individualmente', correct: false}
        ],
        explanation: 'Por inducción, probamos que es verdadero para todos los naturales'
      },
      {
        type: 'choice',
        prompt: '¿Cuál proposición se puede probar por inducción?',
        choices: [
          {text: '2ⁿ > n para todo n≥1', correct: true},
          {text: 'Todos los números primos son impares', correct: false},
          {text: 'π es irracional', correct: false}
        ],
        explanation: '2ⁿ > n es una afirmación sobre enteros que se puede inducir'
      },
      {
        type: 'input',
        prompt: 'Para n=1, verifica: 2¹ = 2. ¿Es 2 > 1?',
        answer: 'si',
        hint: '¿2 es mayor que 1?',
        explanation: 'Sí, 2 > 1 Caso base verdadero'
      },
      {
        type: 'choice',
        prompt: 'La inducción matemática es útil para probar:',
        choices: [
          {text: 'Fórmulas que involucran números naturales', correct: true},
          {text: 'Cualquier teorema matemático', correct: false},
          {text: 'Solo sumatorias', correct: false}
        ],
        explanation: 'La inducción funciona específicamente para números naturales'
      }
    ]
  },
  {
    id: 3,
    title: 'Capítulo 3 - Canvas LMS Hackeado',
    text: `El sistema Canvas LMS ha sido comprometido. Las tareas y exámenes están siendo modificados.

Necesitas entender CONJUNTOS para identificar qué datos han sido alterados y cuáles permanecen intactos.

Completa los 10 ejercicios de CONJUNTOS para recuperar la pieza 🧩`,
    type: 'exercises',
    category: 'conjuntos',
    piece: 3,
    exercises: [
      {
        type: 'choice',
        prompt: 'Dados A={1,2,3} y B={3,4,5}, ¿cuál es A∩B?',
        choices: [
          {text: '{3}', correct: true},
          {text: '{1,2,3,4,5}', correct: false},
          {text: '{1,2}', correct: false}
        ],
        explanation: 'A∩B son los elementos comunes: solo el 3'
      },
      {
        type: 'choice',
        prompt: 'Dados A={1,2} y B={3,4}, ¿cuál es A∪B?',
        choices: [
          {text: '{1,2,3,4}', correct: true},
          {text: '{}', correct: false},
          {text: '{2,3}', correct: false}
        ],
        explanation: 'A∪B es la unión: todos los elementos de ambos'
      },
      {
        type: 'input',
        prompt: 'Si A={a,b,c,d}, ¿cuántos elementos tiene A? (escribe el número)',
        answer: '4',
        hint: 'Cuenta los elementos',
        explanation: 'A tiene 4 elementos: a, b, c, d'
      },
      {
        type: 'choice',
        prompt: '¿Qué símbolo representa "pertenece a"?',
        choices: [
          {text: '∈', correct: true},
          {text: '⊂', correct: false},
          {text: '∪', correct: false}
        ],
        explanation: '∈ significa "es elemento de" o "pertenece a"'
      },
      {
        type: 'choice',
        prompt: 'El conjunto vacío se denota:',
        choices: [
          {text: '∅ o {}', correct: true},
          {text: '{0}', correct: false},
          {text: 'null', correct: false}
        ],
        explanation: '∅ o {} representan el conjunto sin elementos'
      },
      {
        type: 'choice',
        prompt: 'Si A⊂B, significa que:',
        choices: [
          {text: 'A es subconjunto de B', correct: true},
          {text: 'A es igual a B', correct: false},
          {text: 'A y B son disjuntos', correct: false}
        ],
        explanation: 'A⊂B significa que todos los elementos de A están en B'
      },
      {
        type: 'input',
        prompt: 'Si A={1,2,3} y B={2,3,4,5}, ¿cuántos elementos tiene A∪B?',
        answer: '5',
        hint: 'Cuenta sin repetir: {1,2,3,4,5}',
        explanation: 'A∪B = {1,2,3,4,5} tiene 5 elementos'
      },
      {
        type: 'choice',
        prompt: 'Dos conjuntos son disjuntos si:',
        choices: [
          {text: 'Su intersección es vacía', correct: true},
          {text: 'Son iguales', correct: false},
          {text: 'Tienen todos los elementos en común', correct: false}
        ],
        explanation: 'A y B son disjuntos si A∩B = ∅'
      },
      {
        type: 'input',
        prompt: 'Si A={x,y} y B={y,z}, escribe A∩B (sin espacios, orden alfabético)',
        answer: '{y}',
        hint: 'El elemento común',
        explanation: 'Solo y está en ambos conjuntos'
      },
      {
        type: 'choice',
        prompt: 'La diferencia A-B contiene:',
        choices: [
          {text: 'Elementos de A que no están en B', correct: true},
          {text: 'Elementos de B que no están en A', correct: false},
          {text: 'Elementos comunes', correct: false}
        ],
        explanation: 'A-B = {x ∈ A : x ∉ B}'
      }
    ]
  },
  {
    id: 4,
    title: 'Capítulo 4 - Descifrando el Firewall',
    text: `Has llegado al firewall de la universidad. Está protegido con problemas de RELACIONES matemáticas.

Debes comprender propiedades de relaciones para desactivar las barreras de seguridad que el hacker ha manipulado.

Completa los 10 ejercicios de RELACIONES para recuperar la pieza 🧩`,
    type: 'exercises',
    category: 'relaciones',
    piece: 4,
    exercises: [
      {
        type: 'choice',
        prompt: 'Una relación R es reflexiva si:',
        choices: [
          {text: 'Para todo a: (a,a)∈R', correct: true},
          {text: 'Si (a,b)∈R entonces (b,a)∈R', correct: false},
          {text: 'Si (a,b) y (b,c)∈R entonces (a,c)∈R', correct: false}
        ],
        explanation: 'Reflexiva: cada elemento se relaciona consigo mismo'
      },
      {
        type: 'choice',
        prompt: 'Una relación R es simétrica si:',
        choices: [
          {text: 'Si (a,b)∈R entonces (b,a)∈R', correct: true},
          {text: 'Para todo a: (a,a)∈R', correct: false},
          {text: 'Si (a,b) y (b,c)∈R entonces (a,c)∈R', correct: false}
        ],
        explanation: 'Simétrica: la relación va en ambas direcciones'
      },
      {
        type: 'choice',
        prompt: 'Una relación R es transitiva si:',
        choices: [
          {text: 'Si (a,b)∈R y (b,c)∈R entonces (a,c)∈R', correct: true},
          {text: 'Si (a,b)∈R entonces (b,a)∈R', correct: false},
          {text: 'Para todo a: (a,a)∈R', correct: false}
        ],
        explanation: 'Transitiva: se puede "saltar" por elementos intermedios'
      },
      {
        type: 'choice',
        prompt: '¿Cuál relación es reflexiva? A={1,2,3}',
        choices: [
          {text: 'R={(1,1),(2,2),(3,3),(1,2)}', correct: true},
          {text: 'R={(1,2),(2,1)}', correct: false},
          {text: 'R={(1,2),(2,3)}', correct: false}
        ],
        explanation: 'Debe contener (1,1), (2,2) y (3,3)'
      },
      {
        type: 'choice',
        prompt: 'La relación "=" (igualdad) es:',
        choices: [
          {text: 'Reflexiva, simétrica y transitiva', correct: true},
          {text: 'Solo reflexiva', correct: false},
          {text: 'Solo simétrica', correct: false}
        ],
        explanation: '"=" es una relación de equivalencia (cumple las 3)'
      },
      {
        type: 'choice',
        prompt: 'La relación "<" (menor que) en números naturales es:',
        choices: [
          {text: 'Transitiva pero no reflexiva ni simétrica', correct: true},
          {text: 'Reflexiva', correct: false},
          {text: 'Simétrica', correct: false}
        ],
        explanation: 'a<b no implica b<a, ni a<a, pero si a<b y b<c entonces a<c'
      },
      {
        type: 'choice',
        prompt: 'Una relación de equivalencia debe ser:',
        choices: [
          {text: 'Reflexiva, simétrica y transitiva', correct: true},
          {text: 'Solo reflexiva y simétrica', correct: false},
          {text: 'Solo transitiva', correct: false}
        ],
        explanation: 'Las tres propiedades definen una relación de equivalencia'
      },
      {
        type: 'choice',
        prompt: 'Si R={(1,2),(2,3)}, ¿qué falta para que sea transitiva?',
        choices: [
          {text: '(1,3)', correct: true},
          {text: '(3,1)', correct: false},
          {text: '(2,1)', correct: false}
        ],
        explanation: 'Si (1,2) y (2,3) están, debe estar (1,3)'
      },
      {
        type: 'input',
        prompt: 'En A={1,2,3}, ¿cuántos pares debe tener una relación reflexiva mínima?',
        answer: '3',
        hint: 'Uno por cada elemento',
        explanation: 'Debe tener (1,1), (2,2), (3,3) = 3 pares'
      },
      {
        type: 'choice',
        prompt: 'El dominio de R={(1,a),(2,b),(1,c)} es:',
        choices: [
          {text: '{1,2}', correct: true},
          {text: '{a,b,c}', correct: false},
          {text: '{1,2,a,b,c}', correct: false}
        ],
        explanation: 'El dominio son las primeras componentes: {1,2}'
      }
    ]
  },
  {
    id: 5,
    title: 'Capítulo 5 - Base de Datos Infiltrada',
    text: `Has accedido a la base de datos central. Aquí están almacenadas todas las calificaciones.

Necesitas aplicar conceptos avanzados de SUMATORIAS Y SERIES para identificar las alteraciones.

Completa los 10 ejercicios avanzados para recuperar la pieza 🧩`,
    type: 'exercises',
    category: 'sumatorias_avanzadas',
    piece: 5,
    exercises: [
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 10) i',
        answer: '55',
        hint: 'Usa la fórmula n(n+1)/2',
        explanation: '10(11)/2 = 55'
      },
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 5) i²',
        answer: '55',
        hint: '1²+2²+3²+4²+5²',
        explanation: '1+4+9+16+25 = 55'
      },
      {
        type: 'choice',
        prompt: '¿Cuál es la fórmula para ∑(i=1 hasta n) i²?',
        choices: [
          {text: 'n(n+1)(2n+1)/6', correct: true},
          {text: 'n(n+1)/2', correct: false},
          {text: 'n²(n+1)²/4', correct: false}
        ],
        explanation: 'Fórmula para suma de cuadrados: n(n+1)(2n+1)/6'
      },
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 4) (2i+1)',
        answer: '24',
        hint: '(2·1+1)+(2·2+1)+(2·3+1)+(2·4+1)',
        explanation: '3+5+7+9 = 24'
      },
      {
        type: 'input',
        prompt: 'Si ∑(i=1 hasta n) i = 91, encuentra n',
        answer: '13',
        hint: 'n(n+1)/2 = 91',
        explanation: 'n(n+1) = 182 → n = 13'
      },
      {
        type: 'choice',
        prompt: 'La serie geométrica ∑(i=0 hasta ∞) rⁱ converge si:',
        choices: [
          {text: '|r| < 1', correct: true},
          {text: 'r > 1', correct: false},
          {text: 'r = 1', correct: false}
        ],
        explanation: 'Series geométricas convergen solo si |r| < 1'
      },
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 3) 2ⁱ',
        answer: '14',
        hint: '2¹+2²+2³',
        explanation: '2+4+8 = 14'
      },
      {
        type: 'choice',
        prompt: '∑(i=1 hasta n) (aᵢ + bᵢ) es igual a:',
        choices: [
          {text: '∑aᵢ + ∑bᵢ', correct: true},
          {text: '∑aᵢ · ∑bᵢ', correct: false},
          {text: '∑(aᵢ·bᵢ)', correct: false}
        ],
        explanation: 'La suma se distribuye: ∑(aᵢ + bᵢ) = ∑aᵢ + ∑bᵢ'
      },
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 8) i',
        answer: '36',
        hint: '8(9)/2',
        explanation: '8(9)/2 = 36'
      },
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 4) i³',
        answer: '100',
        hint: '1³+2³+3³+4³',
        explanation: '1+8+27+64 = 100'
      }
    ]
  },
  {
    id: 6,
    title: 'Capítulo 6 - Rastreando al Hacker',
    text: `Estás cerca. Has identificado patrones en el código malicioso.

Necesitas dominar INDUCCIÓN AVANZADA para predecir los próximos movimientos del atacante.

Completa los 10 ejercicios para recuperar la pieza 🧩`,
    type: 'exercises',
    category: 'induccion_avanzada',
    piece: 6,
    exercises: [
      {
        type: 'choice',
        prompt: 'Para probar por inducción que 2ⁿ ≥ n+1 para n≥0, el caso base es:',
        choices: [
          {text: 'n=0: 2⁰=1 ≥ 0+1=1 ✓', correct: true},
          {text: 'n=1: 2¹=2 ≥ 1+1=2', correct: false},
          {text: 'n=2: 2²=4 ≥ 2+1=3', correct: false}
        ],
        explanation: 'Comenzamos desde n=0 según el enunciado'
      },
      {
        type: 'choice',
        prompt: 'En la inducción fuerte, la hipótesis asume que P(k) es cierto para:',
        choices: [
          {text: 'Todos los valores desde 1 hasta k', correct: true},
          {text: 'Solo k', correct: false},
          {text: 'Solo k-1', correct: false}
        ],
        explanation: 'Inducción fuerte asume P(1), P(2), ..., P(k)'
      },
      {
        type: 'input',
        prompt: 'Verifica caso base: Para n=1, ∑(i=1 hasta 1) i² = 1²(1+1)²/4. Resultado:',
        answer: '1',
        hint: '1²·2²/4 = 4/4 = 1',
        explanation: '1·4/4 = 1 ✓'
      },
      {
        type: 'choice',
        prompt: 'La inducción matemática demuestra que una proposición es verdadera:',
        choices: [
          {text: 'Para todos los números naturales', correct: true},
          {text: 'Para algunos números', correct: false},
          {text: 'Solo para el caso base', correct: false}
        ],
        explanation: 'La inducción prueba para todo n en los naturales'
      },
      {
        type: 'choice',
        prompt: 'Para probar P(n) por inducción, después del caso base debemos:',
        choices: [
          {text: 'Asumir P(k) y probar P(k+1)', correct: true},
          {text: 'Probar P(2)', correct: false},
          {text: 'Probar todos los casos', correct: false}
        ],
        explanation: 'El paso inductivo es P(k) → P(k+1)'
      },
      {
        type: 'input',
        prompt: '¿Cuántos pasos tiene una prueba por inducción básica?',
        answer: '2',
        hint: 'Caso base y paso inductivo',
        explanation: '2 pasos: caso base y paso inductivo'
      },
      {
        type: 'choice',
        prompt: 'Si queremos probar ∑(i=1 hasta n) i³ = [n(n+1)/2]², el método es:',
        choices: [
          {text: 'Inducción matemática', correct: true},
          {text: 'Contradicción', correct: false},
          {text: 'Contraejemplo', correct: false}
        ],
        explanation: 'Es una fórmula para naturales, perfecta para inducción'
      },
      {
        type: 'choice',
        prompt: 'El principio de inducción se basa en:',
        choices: [
          {text: 'El principio del buen orden', correct: true},
          {text: 'La ley de contradicción', correct: false},
          {text: 'El teorema de Pitágoras', correct: false}
        ],
        explanation: 'La inducción se fundamenta en el buen orden de ℕ'
      },
      {
        type: 'choice',
        prompt: 'Para probar que n! > 2ⁿ para n≥4, ¿cuál es el caso base?',
        choices: [
          {text: 'n=4: 24 > 16 ✓', correct: true},
          {text: 'n=1: 1 > 2', correct: false},
          {text: 'n=0: 1 > 1', correct: false}
        ],
        explanation: 'El enunciado dice n≥4, así que probamos n=4'
      },
      {
        type: 'choice',
        prompt: 'La inducción NO puede usarse para probar:',
        choices: [
          {text: 'Proposiciones sobre números reales arbitrarios', correct: true},
          {text: 'Fórmulas sobre números naturales', correct: false},
          {text: 'Desigualdades para n≥1', correct: false}
        ],
        explanation: 'Inducción solo funciona con conjuntos bien ordenados como ℕ'
      }
    ]
  },
  {
    id: 7,
    title: 'Capítulo 7 - Confrontación Final',
    text: `¡Lo has encontrado! El hacker está intentando escapar.

Para atraparlo y reforzar el sistema, necesitas resolver ejercicios MIXTOS que combinan todo lo aprendido.

Completa los 10 ejercicios finales para recuperar la última pieza 🧩 y atrapar al hacker.`,
    type: 'exercises',
    category: 'mixto',
    piece: 7,
    exercises: [
      {
        type: 'choice',
        prompt: 'Si A={1,2,3} y B={2,3,4}, entonces A∩B es:',
        choices: [
          {text: '{2,3}', correct: true},
          {text: '{1,2,3,4}', correct: false},
          {text: '{1,4}', correct: false}
        ],
        explanation: 'Intersección: elementos comunes {2,3}'
      },
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 7) i',
        answer: '28',
        hint: '7(8)/2',
        explanation: '7(8)/2 = 28'
      },
      {
        type: 'choice',
        prompt: 'Una relación R es de equivalencia si es:',
        choices: [
          {text: 'Reflexiva, simétrica y transitiva', correct: true},
          {text: 'Solo reflexiva', correct: false},
          {text: 'Solo transitiva', correct: false}
        ],
        explanation: 'Las tres propiedades definen equivalencia'
      },
      {
        type: 'input',
        prompt: 'Si A={a,b,c} y B={c,d}, ¿cuántos elementos tiene A∪B?',
        answer: '4',
        hint: '{a,b,c,d}',
        explanation: 'A∪B = {a,b,c,d} tiene 4 elementos'
      },
      {
        type: 'choice',
        prompt: 'El primer paso de inducción es:',
        choices: [
          {text: 'Probar el caso base', correct: true},
          {text: 'Asumir P(k)', correct: false},
          {text: 'Probar P(k+1)', correct: false}
        ],
        explanation: 'Siempre empezamos con el caso base'
      },
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 3) (i+1)',
        answer: '9',
        hint: '(1+1)+(2+1)+(3+1)',
        explanation: '2+3+4 = 9'
      },
      {
        type: 'choice',
        prompt: 'Si A⊂B y B⊂C, entonces:',
        choices: [
          {text: 'A⊂C (por transitividad)', correct: true},
          {text: 'C⊂A', correct: false},
          {text: 'A=B=C', correct: false}
        ],
        explanation: 'La relación ⊂ es transitiva'
      },
      {
        type: 'input',
        prompt: 'Calcula: ∑(i=1 hasta 2) i³',
        answer: '9',
        hint: '1³+2³',
        explanation: '1+8 = 9'
      },
      {
        type: 'choice',
        prompt: 'El conjunto potencia de A={1,2} tiene:',
        choices: [
          {text: '4 elementos', correct: true},
          {text: '2 elementos', correct: false},
          {text: '3 elementos', correct: false}
        ],
        explanation: 'P(A) = {∅, {1}, {2}, {1,2}} tiene 2² = 4 elementos'
      },
      {
        type: 'choice',
        prompt: 'Para probar ∀n∈ℕ: P(n), usamos:',
        choices: [
          {text: 'Inducción matemática', correct: true},
          {text: 'Contradicción siempre', correct: false},
          {text: 'Casos particulares', correct: false}
        ],
        explanation: 'Inducción es ideal para proposiciones sobre ℕ'
      }
    ]
  }
];

// ============ STATE MANAGEMENT ============
const STORAGE_KEY = 'neko_ubuntu_game_v3';
let state = {
  chapterIndex: 0,
  lives: 3,
  maxLives: 3,
  timeLimit: 60,
  currentExercise: 0,
  completedExercises: {},
  pieces: [false, false, false, false, false, false, false],
  log: []
};

let timerInterval = null;
let timeRemaining = 0;

// ============ AUDIO ============
const AudioCtx = window.AudioContext || window.webkitAudioContext;
const audioCtx = AudioCtx ? new AudioCtx() : null;

function playTone(freq = 440, type = 'sine', duration = 0.15) {
  if (!audioCtx) return;
  const osc = audioCtx.createOscillator();
  const gain = audioCtx.createGain();
  osc.type = type;
  osc.frequency.value = freq;
  osc.connect(gain);
  gain.connect(audioCtx.destination);
  gain.gain.value = 0.001;
  const now = audioCtx.currentTime;
  gain.gain.exponentialRampToValueAtTime(0.1, now + 0.01);
  osc.start(now);
  gain.gain.exponentialRampToValueAtTime(0.001, now + duration);
  osc.stop(now + duration + 0.02);
}

// ============ DOM REFERENCES ============
const stageTitle = document.getElementById('stageTitle');
const stageText = document.getElementById('stageText');
const stageChoices = document.getElementById('stageChoices');
const chapterBadge = document.getElementById('chapterBadge');
const meterBar = document.getElementById('meterBar');
const meterText = document.getElementById('meterText');
const logEl = document.getElementById('log');
const livesEl = document.getElementById('lives');
const modalRoot = document.getElementById('modalRoot');
const toastRoot = document.getElementById('toastRoot');
const nextBtn = document.getElementById('nextBtn');

// ============ INITIALIZATION ============
document.getElementById('btnStart').addEventListener('click', () => render());
document.getElementById('btnChapters').addEventListener('click', () => showChapters());
document.getElementById('btnSettings').addEventListener('click', () => openSettings());
document.getElementById('saveBtn').addEventListener('click', () => {
  save();
  addLog('<i class="fas fa-save"></i> Partida guardada');
  showToast('Juego guardado exitosamente', true);
});
document.getElementById('nextBtn').addEventListener('click', () => {
  nextChapter();
  render();
});

window.addEventListener('keydown', (e) => {
  if (e.key >= '1' && e.key <= '4') chooseByIndex(parseInt(e.key) - 1);
  if (e.key === 'r' || e.key === 'R') {
    if (confirm('¿Reiniciar la partida completa?')) reset();
  }
});

// ============ STORAGE ============
function load() {
  try {
    const raw = localStorage.getItem(STORAGE_KEY);
    if (raw) {
      const parsed = JSON.parse(raw);
      if (typeof parsed.chapterIndex === 'number') {
        state = parsed;
        // Asegurar valores por defecto
        if (!state.maxLives) state.maxLives = 3;
        if (!state.timeLimit) state.timeLimit = 60;
        if (!state.lives) state.lives = state.maxLives;
      }
    }
  } catch (e) {
    console.warn('Error al cargar:', e);
  }
}

function save() {
  try {
    localStorage.setItem(STORAGE_KEY, JSON.stringify(state));
  } catch (e) {
    console.warn('Error al guardar:', e);
  }
}

function reset() {
  state = {
    chapterIndex: 0,
    lives: state.maxLives || 3,
    maxLives: state.maxLives || 3,
    timeLimit: state.timeLimit || 60,
    currentExercise: 0,
    completedExercises: {},
    pieces: [false, false, false, false, false, false, false],
    log: []
  };
  stopTimer();
  save();
  addLog('<i class="fas fa-sync-alt"></i> Partida reiniciada');
  render();
}

// ============ LOGGING ============
function addLog(msg) {
  const time = new Date().toLocaleTimeString();
  const entry = `[${time}] ${msg}`;
  state.log.unshift(entry);
  if (state.log.length > 50) state.log.pop();
  renderLog();
  save();
}

function renderLog() {
  logEl.innerHTML = state.log.join('\n') || '— Sin actividad —';
}

// ============ RENDER CHAPTER ============
function render() {
  const ch = chapters[state.chapterIndex];
  
  if (!ch) {
    // Epilogue
    renderEpilogue();
    return;
  }

  chapterBadge.textContent = ch.id === 0 ? 'Prólogo' : `Capítulo ${ch.id}`;
  stageTitle.textContent = ch.title;
  stageText.textContent = ch.text;

  stageChoices.innerHTML = '';
  nextBtn.style.display = 'none';
  
  if (ch.type === 'story') {
    // Story chapter - just show continue button
    const btn = document.createElement('button');
    btn.className = 'btn';
    btn.innerHTML = 'Continuar <i class="fas fa-arrow-right"></i>';
    btn.addEventListener('click', () => {
      nextChapter();
      render();
    });
    stageChoices.appendChild(btn);
  } else if (ch.type === 'exercises') {
    // Exercise chapter
    renderExercise(ch);
  }

  updateMeter();
  renderLog();
  renderLives();
  renderPieces();
}

function renderExercise(ch) {
  const key = `ch${ch.id}`;
  if (!state.completedExercises[key]) {
    state.completedExercises[key] = 0;
  }
  
  const exIndex = state.completedExercises[key];
  
  if (exIndex >= ch.exercises.length) {
    // All exercises completed
    stopTimer();
    stageText.innerHTML = `<i class="fas fa-trophy"></i> ¡Has completado todos los ejercicios!<br><br>Has desbloqueado la pieza ${ch.piece}/7 <i class="fas fa-puzzle-piece"></i>`;
    state.pieces[ch.piece - 1] = true;
    
    const btn = document.createElement('button');
    btn.className = 'btn';
    btn.innerHTML = 'Continuar al siguiente capítulo <i class="fas fa-arrow-right"></i>';
    btn.addEventListener('click', () => {
      nextChapter();
      render();
    });
    stageChoices.appendChild(btn);
    save();
    return;
  }
  
  const ex = ch.exercises[exIndex];
  const progressHTML = `
    <div class="progress-bar">
      <div class="progress-fill" style="width:${(exIndex/ch.exercises.length)*100}%">
        ${exIndex}/${ch.exercises.length}
      </div>
    </div>
  `;
  
  // Timer display
  const timerHTML = `
    <div style="text-align:center;margin:16px 0">
      <div style="font-size:14px;color:var(--ubuntu-muted);margin-bottom:8px"><i class="fas fa-hourglass-end"></i> Tiempo restante</div>
      <div id="timerDisplay" style="font-size:32px;font-weight:700;font-family:'Ubuntu Mono',monospace;color:var(--ubuntu-orange)">
        ${state.timeLimit}s
      </div>
    </div>
  `;
  
  stageText.innerHTML = progressHTML + timerHTML + '\n' + ex.prompt;
  
  // Start timer
  startTimer(ch, ex);
  
  if (ex.type === 'input') {
    const row = document.createElement('div');
    row.className = 'input-row';
    
    const input = document.createElement('input');
    input.type = 'text';
    input.placeholder = 'Escribe tu respuesta aquí...';
    input.id = 'exerciseInput';
    input.addEventListener('keydown', (e) => {
      if (e.key === 'Enter') checkExercise(ch, ex, input.value);
    });
    
    const btn = document.createElement('button');
    btn.className = 'btn';
    btn.textContent = 'Verificar →';
    btn.addEventListener('click', () => checkExercise(ch, ex, input.value));
    
    row.appendChild(input);
    row.appendChild(btn);
    stageChoices.appendChild(row);
    
    setTimeout(() => input.focus(), 100);
  } else if (ex.type === 'choice') {
    ex.choices.forEach((choice, i) => {
      const el = document.createElement('div');
      el.className = 'choice';
      el.tabIndex = 0;
      el.innerHTML = `<div class="choice-content"><span class="choice-number">${i + 1}.</span> ${escapeHtml(choice.text)}</div>`;
      el.addEventListener('click', () => checkExercise(ch, ex, choice));
      stageChoices.appendChild(el);
    });
  }
}

function checkExercise(ch, ex, answer) {
  stopTimer();
  
  const key = `ch${ch.id}`;
  let correct = false;
  
  if (ex.type === 'input') {
    const cleaned = ('' + answer).trim().toLowerCase().replace(/\s+/g, '');
    const expected = ('' + ex.answer).toLowerCase().replace(/\s+/g, '');
    correct = cleaned === expected || cleaned === ex.answer.toLowerCase();
  } else if (ex.type === 'choice') {
    correct = answer.correct === true;
  }
  
  if (correct) {
    state.completedExercises[key]++;
    addLog(`<i class="fas fa-check-circle"></i> Ejercicio ${state.completedExercises[key]}/${ch.exercises.length} correcto`);
    showToast('<i class="fas fa-check-circle"></i> ' + ex.explanation, true);
    playTone(880, 'sine', 0.15);
    save();
    render();
  } else {
    state.lives--;
    addLog(`<i class="fas fa-times-circle"></i> Respuesta incorrecta - Vida perdida`);
    showToast('<i class="fas fa-times-circle"></i> Incorrecto. ' + (ex.hint || 'Intenta de nuevo'), false);
    playTone(220, 'sawtooth', 0.15);
    shakeStage();
    
    if (state.lives <= 0) {
      gameOver();
    } else {
      renderLives();
      save();
    }
  }
}

// ============ TIMER FUNCTIONS ============
function startTimer(ch, ex) {
  stopTimer();
  timeRemaining = state.timeLimit || 60;
  updateTimerDisplay();
  
  timerInterval = setInterval(() => {
    timeRemaining--;
    updateTimerDisplay();
    
    if (timeRemaining <= 10) {
      const timerEl = document.getElementById('timerDisplay');
      if (timerEl) {
        timerEl.style.color = 'var(--ubuntu-danger)';
        timerEl.style.animation = 'pulse 0.5s ease-in-out infinite';
      }
    }
    
    if (timeRemaining <= 0) {
      stopTimer();
      timeOut(ch, ex);
    }
  }, 1000);
}

function stopTimer() {
  if (timerInterval) {
    clearInterval(timerInterval);
    timerInterval = null;
  }
}

function updateTimerDisplay() {
  const timerEl = document.getElementById('timerDisplay');
  if (timerEl) {
    timerEl.textContent = `${timeRemaining}s`;
  }
}

function timeOut(ch, ex) {
  state.lives--;
  addLog(`<i class="fas fa-hourglass-end"></i> Tiempo agotado - Vida perdida`);
  showToast('<i class="fas fa-hourglass-end"></i> ¡Se acabó el tiempo! Pierdes una vida', false);
  playTone(220, 'sawtooth', 0.15);
  shakeStage();
  
  if (state.lives <= 0) {
    gameOver();
  } else {
    renderLives();
    save();
    render();
  }
}

function nextChapter() {
  state.chapterIndex++;
  state.currentExercise = 0;
  save();
}

function gameOver() {
  stopTimer();
  chapterBadge.textContent = 'Game Over';
  stageTitle.innerHTML = '<i class="fas fa-skull"></i> Neko ha fallado';
  stageText.innerHTML = `
    <p>Has perdido todas tus vidas. El hacker ha escapado y el sistema permanece comprometido.</p>
    <p>¡Pero no te rindas! Puedes intentarlo de nuevo.</p>
  `;
  stageChoices.innerHTML = `
    <div class="choice" onclick="reset()">
      <div class="choice-content">
        <i class="fas fa-sync-alt"></i> Reiniciar aventura
      </div>
    </div>
  `;
  nextBtn.style.display = 'none';
  save();
}


function renderEpilogue() {
  chapterBadge.textContent = 'Epílogo';
  stageTitle.innerHTML = '<i class="fas fa-trophy"></i> ¡Misión Completada!';
  
  const allPieces = state.pieces.every(p => p);
  
  if (allPieces) {
    stageText.innerHTML = `
      <h3><i class="fas fa-medal"></i> ¡FELICIDADES!</h3>
      <p>Has recolectado las 7 piezas del enigma y atrapado al hacker.</p>
      <ul style="list-style:none;padding-left:0;line-height:1.6em">
        <li><i class="fas fa-check"></i> MeetPoint seguro</li>
        <li><i class="fas fa-check"></i> Teams protegido</li>
        <li><i class="fas fa-check"></i> Canvas LMS restaurado</li>
        <li><i class="fas fa-check"></i> Firewall reforzado</li>
        <li><i class="fas fa-check"></i> Base de datos limpia</li>
        <li><i class="fas fa-check"></i> Código fuente protegido</li>
        <li><i class="fas fa-check"></i> Inyecciones SQL bloqueadas</li>
      </ul>
      <p>Gracias a tus habilidades matemáticas, Jala University está a salvo.</p>`;
    stageText.appendChild(document.createElement("p")).appendChild(icon);
    stageText.lastChild.insertAdjacentText("beforeend", " Neko puede descansar... por ahora.");

  } else {
    stageText.textContent = 'Has llegado al final, pero no recolectaste todas las piezas. Completa todos los ejercicios para atrapar al hacker.';
  }
  
  stageChoices.innerHTML = `
  <div class="choice" onclick="reset()">
    <div class="choice-content">
      <i class="fas fa-sync-alt"></i> Jugar de nuevo
    </div>
  </div>
  `;
  updateMeter();
  renderLog();
  renderLives();
  renderPieces();
}

function updateMeter() {
  const total = chapters.length;
  const done = Math.min(state.chapterIndex, total);
  const pct = Math.round((done / total) * 100);
  meterBar.style.width = pct + '%';
  meterText.textContent = `${done}/${total}`;
}

function renderLives() {
  const filledHeart = '<i class="fas fa-heart heart"></i>';
  const emptyHeart = '<i class="far fa-heart"></i>';
  
  const hearts = filledHeart.repeat(Math.max(0, state.lives));
  const empty = emptyHeart.repeat(Math.max(0, (state.maxLives || 3) - state.lives));
  
  livesEl.innerHTML = hearts + empty;
}

function renderPieces() {
  state.pieces.forEach((collected, i) => {
    const pieceEl = document.getElementById(`piece${i + 1}`);
    if (pieceEl) {
      pieceEl.style.opacity = collected ? '1' : '0.2';
      if (collected) pieceEl.style.filter = 'drop-shadow(0 0 10px var(--ubuntu-orange))';
    }
  });
}

function chooseByIndex(i) {
  const ch = chapters[state.chapterIndex];
  if (!ch || ch.type !== 'choice') return;
  const chosen = ch.choices[i];
  if (chosen) checkExercise(ch, ch, chosen);
}

function shakeStage() {
  const stage = document.getElementById('stage');
  stage.classList.remove('shake');
  void stage.offsetWidth;
  stage.classList.add('shake');
  setTimeout(() => stage.classList.remove('shake'), 500);
}

// ============ UI HELPERS ============
function showModal(html) {
  closeModal();
  const overlay = document.createElement('div');
  overlay.className = 'modal-overlay';
  overlay.id = 'modalOverlay';
  overlay.innerHTML = `<div class="modal-box">${html}</div>`;
  overlay.addEventListener('click', (e) => {
    if (e.target === overlay) closeModal();
  });
  modalRoot.appendChild(overlay);
}

function closeModal() {
  const el = document.getElementById('modalOverlay');
  if (el) el.remove();
}

function showToast(msg, success = true) {
  const toast = document.createElement('div');
  toast.className = 'toast';
  toast.style.background = success 
    ? 'linear-gradient(135deg, var(--ubuntu-success), #33d17a)' 
    : 'linear-gradient(135deg, var(--ubuntu-danger), #e01b24)';
  toast.innerHTML = msg;
  toastRoot.appendChild(toast);
  
  setTimeout(() => {
    toast.style.transition = 'opacity 0.4s ease, transform 0.4s ease';
    toast.style.opacity = '0';
    toast.style.transform = 'translateY(20px)';
    setTimeout(() => toast.remove(), 400);
  }, 3000);
}

function showChapters() {
  let html = `
    <div class="modal-header">
      <h3><i class="fas fa-book"></i> Capítulos de la Aventura</h3>
      <button class="btn ghost" id="closeChapters">✕ Cerrar</button>
    </div>
  `;
  
  chapters.forEach((c, idx) => {
    const completed = idx < state.chapterIndex;
    const current = idx === state.chapterIndex;
    const locked = idx > state.chapterIndex;

    let icon = '';
    if (completed) icon = '<i class="fas fa-check-circle"></i>';
    else if (current) icon = '<i class="fas fa-play"></i>';
    else if (locked) icon = '<i class="fas fa-lock"></i>';
    
    const title = c.id === 0 ? 'Prólogo' : `Capítulo ${c.id}`;
    
    html += `
      <div class="exercise-item" style="opacity:${locked ? '0.5' : '1'}">
        <div class="exercise-title">
          ${icon} ${title}: ${escapeHtml(c.title)}
        </div>
        <div class="exercise-prompt">${escapeHtml(c.text.substring(0, 100))}...</div>
        ${!locked && completed ? `<button class="btn ghost" onclick="gotoChapter(${idx})">Revisar capítulo</button>` : ''}
        ${locked ? '<div class="small"><i class="fas fa-lock"></i> Debes completar el capítulo anterior</div>' : ''}
      </div>
    `;
  });
  
  showModal(html);
  document.getElementById('closeChapters').addEventListener('click', closeModal);
}

window.gotoChapter = function(idx) {
  if (idx <= state.chapterIndex) {
    const oldIndex = state.chapterIndex;
    state.chapterIndex = idx;
    save();
    closeModal();
    render();
    addLog(`<i class="fas fa-book"></i> Revisando capítulo ${idx}`);
    
    setTimeout(() => {
      state.chapterIndex = oldIndex;
      save();
    }, 100);
  }
};

function openSettings() {
  // Asegurar que tenemos valores válidos
  if (!state.maxLives) state.maxLives = 3;
  if (!state.timeLimit) state.timeLimit = 60;
  
  const html = `
    <div class="modal-header">
      <h3><i class="fas fa-cog"></i> Configuración del Juego</h3>
      <button class="btn ghost" id="closeSettings">✕ Cerrar</button>
    </div>
    
    <div class="exercise-item">
      <div class="exercise-title"><i class="fas fa-heart"></i> Vidas</div>
      <div class="exercise-prompt">Ajusta el número de vidas (3-15)</div>
      <div class="input-row">
        <input id="sLives" type="number" value="${state.maxLives}" min="3" max="15" style="flex:0 0 120px">
        <span style="color:var(--ubuntu-muted);flex:1;padding-left:12px">Vidas actuales: ${state.lives}/${state.maxLives}</span>
      </div>
    </div>

    <div class="exercise-item">
      <div class="exercise-title"><i class="fas fa-clock"></i> Tiempo por Pregunta</div>
      <div class="exercise-prompt">Ajusta el tiempo límite en segundos (30-180)</div>
      <div class="input-row">
        <input id="sTime" type="number" value="${state.timeLimit}" min="30" max="180" step="15" style="flex:0 0 120px">
        <span style="color:var(--ubuntu-muted);flex:1;padding-left:12px">segundos</span>
      </div>
    </div>

    <div style="text-align:center;margin:20px 0">
      <button class="btn" id="applySettings">
        <i class="fas fa-save"></i> Aplicar Configuración
      </button>
    </div>
    
    <div class="exercise-item">
      <div class="exercise-title"><i class="fas fa-chart-bar"></i> Estadísticas</div>
      <div class="exercise-prompt">
        <strong>Capítulo actual:</strong> ${state.chapterIndex}/${chapters.length}<br>
        <strong>Vidas restantes:</strong> ${state.lives}/${state.maxLives}<br>
        <strong>Tiempo por pregunta:</strong> ${state.timeLimit}s<br>
        <strong>Piezas recolectadas:</strong> ${state.pieces.filter(p=>p).length}/7<br>
        <strong>Progreso:</strong> ${Math.round((state.chapterIndex/chapters.length)*100)}%
      </div>
    </div>

    <div class="exercise-item">
      <div class="exercise-title"><i class="fas fa-gamepad"></i> Controles</div>
      <div class="exercise-prompt">
        <strong>Teclas 1-4:</strong> Elegir respuesta<br>
        <strong>Enter:</strong> Enviar respuesta<br>
        <strong>R:</strong> Reiniciar partida
      </div>
    </div>

    <div class="exercise-item">
      <div class="exercise-title"><i class="fas fa-info-circle"></i> Sobre el Juego</div>
      <div class="exercise-prompt">
        <strong>Versión:</strong> 3.0 Enhanced Edition<br>
        <strong>Creado por:</strong> Alejandro Galvis<br>
        <strong>Tema:</strong> Matemáticas Discretas<br>
        <strong>Universidad:</strong> Jala University
      </div>
    </div>

    <div class="exercise-item">
      <div class="exercise-title"><i class="fas fa-trash-alt"></i> Zona Peligrosa</div>
      <div class="exercise-prompt">Reiniciar completamente el progreso</div>
      <button class="btn ghost" id="btnResetAll" style="background:var(--ubuntu-danger);color:#fff">
        <i class="fas fa-exclamation-triangle"></i> Reiniciar todo
      </button>
    </div>
  `;
  
  showModal(html);
  
  const closeBtn = document.getElementById('closeSettings');
  if (closeBtn) {
    closeBtn.addEventListener('click', closeModal);
  }
  
  const applyBtn = document.getElementById('applySettings');
  if (applyBtn) {
    applyBtn.addEventListener('click', () => {
      const livesInput = document.getElementById('sLives');
      const timeInput = document.getElementById('sTime');
      
      const newLives = parseInt(livesInput.value, 10) || 3;
      const newTime = parseInt(timeInput.value, 10) || 60;
      
      state.maxLives = Math.max(3, Math.min(15, newLives));
      state.timeLimit = Math.max(30, Math.min(180, newTime));
      
      // Ajustar vidas actuales si es necesario
      if (state.lives > state.maxLives) {
        state.lives = state.maxLives;
      }
      
      save();
      addLog(`<i class="fas fa-cog"></i> Configuración actualizada: ${state.maxLives} vidas, ${state.timeLimit}s por pregunta`);
      showToast(`<i class="fas fa-check"></i> Configuración guardada: ${state.maxLives} vidas, ${state.timeLimit}s`, true);
      closeModal();
      render();
    });
  }
  
  const resetBtn = document.getElementById('btnResetAll');
  if (resetBtn) {
    resetBtn.addEventListener('click', () => {
      if (confirm('¿Estás seguro de reiniciar TODO el progreso?')) {
        reset();
        closeModal();
      }
    });
  }
}

function escapeHtml(s) {
  return (s + '').replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
}

// ============ PARTICLES ANIMATION ============
function createParticles() {
  const container = document.getElementById('particles');
  const numParticles = 20;
  
  for (let i = 0; i < numParticles; i++) {
    const particle = document.createElement('div');
    particle.className = 'particle';
    
    const x = Math.random() * 100;
    const y = Math.random() * 100;
    const tx = (Math.random() - 0.5) * 200;
    const ty = (Math.random() - 0.5) * 200;
    const delay = Math.random() * 20;
    
    particle.style.left = x + '%';
    particle.style.top = y + '%';
    particle.style.setProperty('--tx', tx + 'px');
    particle.style.setProperty('--ty', ty + 'px');
    particle.style.animationDelay = delay + 's';
    
    container.appendChild(particle);
  }
}

// ============ INITIALIZE ============
load();

// Asegurar valores iniciales
if (!state.maxLives) state.maxLives = 3;
if (!state.timeLimit) state.timeLimit = 60;
if (!state.lives || state.lives === 3) state.lives = state.maxLives;

if (state.log.length === 0) {
  addLog('<i class="fas fa-cat"></i> Bienvenido a la aventura de Neko');
  addLog('<i class="fas fa-terminal"></i> Sistema Ubuntu iniciado');
  addLog('<i class="fas fa-search"></i> Misión: Encontrar al hacker infiltrado');
}
render();
createParticles();

// Expose functions for inline handlers
window.reset = reset;
window.gotoChapter = gotoChapter;
window.closeModal = closeModal;
