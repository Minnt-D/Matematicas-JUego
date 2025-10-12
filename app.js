// ============ GAME DATA ============
const chapters = [
  {
    id: 1,
    title: 'MeetPoint — El Portal de los Ecos',
    text: 'Los avatares están congelados en MeetPoint. Neko detecta anomalías en los logs del sistema. ¿Qué debería hacer?',
    type: 'choice',
    choices: [
      {t: 'Analizar los logs del sistema', p: 'findLogs'},
      {t: 'Reiniciar toda la interfaz', p: 'restartUI'},
      {t: 'Esperar a que se solucione solo', p: 'wait'}
    ]
  },
  {
    id: 2,
    title: 'Canvas — Laberinto de Cursos',
    text: 'El sistema Canvas muestra una secuencia misteriosa que debes completar para avanzar:\n\n1, 1, 2, 3, 5, 8, ...\n\n¿Cuál es el siguiente número?',
    type: 'input',
    answer: '13',
    successText: '¡Correcto! Es la secuencia de Fibonacci. Cada término es la suma de los dos anteriores.',
    failText: 'Incorrecto. Analiza cómo cada número se relaciona con los anteriores.'
  },
  {
    id: 3,
    title: 'Sistema de Notas — Torre del Juicio',
    text: 'El sistema de notas presenta un acertijo lógico:\n\nSi A → B (si A entonces B) y B → C (si B entonces C), ¿qué se puede inferir?',
    type: 'choice',
    choices: [
      {t: 'A → C (transitividad)', p: 'ok'},
      {t: 'C → A (inversa)', p: 'no'},
      {t: 'No se puede inferir nada', p: 'no'}
    ]
  },
  {
    id: 4,
    title: 'El Núcleo — Confrontación Final',
    text: 'La profesora te reta con un último problema de combinatoria:\n\n¿De cuántas formas puedes elegir 3 elementos de un conjunto de 5?\n\nC(5,3) = ?',
    type: 'input',
    answer: '10',
    successText: '¡Excelente! C(5,3) = 5!/(3!×2!) = 10. Has restaurado el sistema.',
    failText: 'Incorrecto. Recuerda: C(n,k) = n!/(k!×(n-k)!)'
  }
];

const exercises = [
  {
    id: 'sum1',
    title: '<i class="fas fa-chart-line"></i> Sumatoria Básica',
    type: 'input',
    prompt: 'Calcula el valor de la siguiente sumatoria:',
    formula: '∑(i=1 hasta 5) i',
    visual: 'sum',
    answers: ['15', '1+2+3+4+5'],
    explain: 'La suma es: 1 + 2 + 3 + 4 + 5 = 15\nFórmula general: ∑(i=1 hasta n) i = n(n+1)/2'
  },
  {
    id: 'sum2',
    title: '<i class="fas fa-chart-line"></i> Sumatoria con Cuadrados',
    type: 'choice',
    prompt: '¿Cuál es el valor de ∑(i=1 hasta 3) i² ?',
    formula: '∑(i=1 hasta 3) i² = 1² + 2² + 3²',
    visual: 'sum',
    choices: [
      {t: '14', p: '14'},
      {t: '12', p: '12'},
      {t: '9', p: '9'}
    ],
    answer: '14',
    explain: '1² + 2² + 3² = 1 + 4 + 9 = 14\nFórmula: ∑(i=1 hasta n) i² = n(n+1)(2n+1)/6'
  },
  {
    id: 'set1',
    title: '<i class="fas fa-circle-notch"></i> Conjuntos — Intersección',
    type: 'choice',
    prompt: 'Dados los conjuntos:\nA = {1, 2, 3, 4}\nB = {3, 4, 5, 6}\n\n¿Cuál es A ∩ B (la intersección)?',
    visual: 'set',
    setA: [1,2,3,4],
    setB: [3,4,5,6],
    choices: [
      {t: '{3, 4}', p: '{3,4}'},
      {t: '{1, 2, 5, 6}', p: '{1,2,5,6}'},
      {t: '{1, 2, 3, 4, 5, 6}', p: '{1,2,3,4,5,6}'}
    ],
    answer: '{3,4}',
    explain: 'La intersección A ∩ B contiene los elementos que están en AMBOS conjuntos: {3, 4}'
  },
  {
    id: 'set2',
    title: '<i class="fas fa-circle-notch"></i> Conjuntos — Unión',
    type: 'input',
    prompt: 'Dados:\nA = {a, b, c}\nB = {c, d, e}\n\nEscribe A ∪ B (sin espacios, en orden alfabético)',
    visual: 'set',
    setA: ['a','b','c'],
    setB: ['c','d','e'],
    answers: ['{a,b,c,d,e}', 'abcde'],
    explain: 'La unión A ∪ B contiene todos los elementos de ambos conjuntos (sin repetir): {a,b,c,d,e}'
  },
  {
    id: 'ind1',
    title: '<i class="fas fa-sync"></i> Inducción — Caso Base',
    type: 'choice',
    prompt: 'En una prueba por inducción matemática, ¿qué es el CASO BASE?',
    visual: 'induction',
    choices: [
      {t: 'Probar que la fórmula funciona para n=1', p: 'base'},
      {t: 'Asumir que funciona para n=k', p: 'hip'},
      {t: 'Probar que funciona para n=k+1', p: 'paso'}
    ],
    answer: 'base',
    explain: 'El caso base consiste en verificar que la proposición P(n) es verdadera para el valor inicial (usualmente n=1).'
  },
  {
    id: 'ind2',
    title: '<i class="fas fa-sync"></i> Inducción — Fórmula',
    type: 'input',
    prompt: 'La fórmula de la suma de los primeros n números naturales es:\n\n∑(i=1 hasta n) i = ?\n\nEscribe la fórmula (ejemplo: n(n+1)/2)',
    visual: 'induction',
    answers: ['n(n+1)/2', 'n*(n+1)/2', '(n(n+1))/2'],
    explain: 'La fórmula es: n(n+1)/2\n\nEjemplo: Para n=5: 5(6)/2 = 15 ✓'
  },
  {
    id: 'ind3',
    title: '<i class="fas fa-sync"></i> Inducción — Paso Inductivo',
    type: 'choice',
    prompt: 'En el paso inductivo de la inducción matemática, si asumimos P(k) es verdadero, ¿qué debemos probar?',
    visual: 'induction',
    choices: [
      {t: 'Que P(k+1) también es verdadero', p: 'correcto'},
      {t: 'Que P(k-1) es verdadero', p: 'incorrecto'},
      {t: 'Que P(1) es verdadero', p: 'incorrecto'}
    ],
    answer: 'correcto',
    explain: 'El paso inductivo consiste en: asumir P(k) (hipótesis inductiva) y probar que P(k+1) es verdadero.'
  }
];

// ============ STATE MANAGEMENT ============
const STORAGE_KEY = 'neko_ubuntu_game_v2';
let state = {
  chapterIndex: 0,
  lives: 3,
  solved: 0,
  log: [],
  exercises: {}
};

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
const chapterLabel = document.getElementById('chapterLabel');
const meterBar = document.getElementById('meterBar');
const meterText = document.getElementById('meterText');
const logEl = document.getElementById('log');
const livesEl = document.getElementById('lives');
const modalRoot = document.getElementById('modalRoot');
const toastRoot = document.getElementById('toastRoot');

// ============ INITIALIZATION ============
document.getElementById('btnStart').addEventListener('click', () => render());
document.getElementById('btnChapters').addEventListener('click', () => showChapters());
document.getElementById('btnExercises').addEventListener('click', () => openExercises());
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
document.getElementById('gotoExercises').addEventListener('click', () => openExercises());

window.addEventListener('keydown', (e) => {
  if (e.key >= '1' && e.key <= '4') chooseByIndex(parseInt(e.key) - 1);
  if (e.key === 'r' || e.key === 'R') {
    if (confirm('¿Reiniciar la partida completa?')) reset();
  }
  if (e.key === 'Enter' && document.activeElement.tagName === 'INPUT') {
    const ch = chapters[state.chapterIndex];
    if (ch && ch.type === 'input') {
      handleInput(ch, document.activeElement.value);
    }
  }
});

// ============ STORAGE ============
function load() {
  try {
    const raw = localStorage.getItem(STORAGE_KEY);
    if (raw) {
      const parsed = JSON.parse(raw);
      if (typeof parsed.chapterIndex === 'number') state = parsed;
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
  state = {chapterIndex: 0, lives: 3, solved: 0, log: [], exercises: {}};
  save();
  addLog('🔄 Partida reiniciada');
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
  // Nota: innerHTML se usa aquí para permitir los iconos de Font Awesome en el log.
  logEl.innerHTML = state.log.join('\n') || '— Sin actividad —';
}

// ============ RENDER CHAPTER ============
function render() {
  const ch = chapters[state.chapterIndex];
  
  if (!ch) {
    // Epilogue
    chapterBadge.textContent = 'Epílogo';
    stageTitle.textContent = 'Misión Completada';
    stageText.innerHTML = '🎉 ¡Has restaurado el sistema universitario!\n\nNeko bosteza satisfecho y se prepara para una siesta bien merecida.\n\n<em>Gracias por jugar.</em>';
    stageChoices.innerHTML = '<div class="choice" onclick="reset()"><div class="choice-content">🔄 Jugar de nuevo</div></div>';
    updateMeter();
    renderLog();
    renderLives();
    return;
  }

  chapterBadge.textContent = `Capítulo ${ch.id}`;
  stageTitle.textContent = ch.title;
  stageText.textContent = ch.text;

  stageChoices.innerHTML = '';
  
  if (ch.type === 'choice') {
    ch.choices.forEach((choice, i) => {
      const el = document.createElement('div');
      el.className = 'choice';
      el.tabIndex = 0;
      el.innerHTML = `<div class="choice-content"><span class="choice-number">${i + 1}.</span> ${escapeHtml(choice.t)}</div>`;
      el.addEventListener('click', () => select(choice.p));
      el.addEventListener('keydown', (e) => {
        if (e.key === 'Enter' || e.key === ' ') select(choice.p);
      });
      stageChoices.appendChild(el);
    });
  } else if (ch.type === 'input') {
    const row = document.createElement('div');
    row.className = 'input-row';
    
    const input = document.createElement('input');
    input.type = 'text';
    input.placeholder = 'Escribe tu respuesta aquí...';
    input.addEventListener('keydown', (e) => {
      if (e.key === 'Enter') handleInput(ch, input.value);
    });
    
    const btn = document.createElement('button');
    btn.className = 'btn';
    btn.textContent = 'Enviar →';
    btn.addEventListener('click', () => handleInput(ch, input.value));
    
    row.appendChild(input);
    row.appendChild(btn);
    stageChoices.appendChild(row);
    
    setTimeout(() => input.focus(), 100);
  }

  updateMeter();
  renderLog();
  renderLives();
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
  const emptyHeart = '<i class="far fa-heart"></i>'; // far = Font Awesome Regular (vacío)
  
  const hearts = filledHeart.repeat(Math.max(0, state.lives));
  const empty = emptyHeart.repeat(Math.max(0, 3 - state.lives));
  
  livesEl.innerHTML = hearts + empty;
}

function chooseByIndex(i) {
  const ch = chapters[state.chapterIndex];
  if (!ch || ch.type !== 'choice') return;
  const chosen = ch.choices[i];
  if (chosen) select(chosen.p);
}

// ============ CHAPTER LOGIC ============
function select(payload) {
  if (payload === 'findLogs') {
    addLog('<i class="fas fa-check-circle"></i> Fragmentos recuperados de los logs');
    state.solved++;
    nextChapter();
    showToast('¡Excelente decisión! Avanzas al siguiente nivel', true);
    playTone(880, 'sine', 0.12);
  } else if (payload === 'restartUI') {
    addLog('<i class="fas fa-exclamation-triangle"></i> Reinicio temporal — solución parcial');
    state.lives--;
    checkLives();
    nextChapter();
    showToast('Reinicio realizado pero perdiste una vida', false);
    playTone(220, 'sawtooth', 0.15);
    shakeStage();
  } else if (payload === 'wait') {
    addLog('<i class="fas fa-times-circle"></i> Esperar no resolvió nada');
    state.lives--;
    checkLives();
    nextChapter();
    showToast('La espera no ayudó. Pierdes una vida', false);
    playTone(220, 'sawtooth', 0.15);
    shakeStage();
  } else if (payload === 'ok') {
    addLog('<i class="fas fa-check-circle"></i> Razonamiento lógico correcto');
    state.solved++;
    nextChapter();
    showToast('¡Correcto! La transitividad es clave', true);
    playTone(880, 'sine', 0.12);
  } else {
    addLog('<i class="fas fa-times-circle"></i> Respuesta incorrecta');
    state.lives--;
    checkLives();
    nextChapter();
    showToast('Respuesta incorrecta', false);
    playTone(220, 'sawtooth', 0.15);
    shakeStage();
  }
  render();
}

function handleInput(ch, inputValue) {
  const cleaned = ('' + inputValue).trim().toLowerCase();
  const expected = ('' + ch.answer).toLowerCase();
  
  if (cleaned === expected) {
    addLog(`<i class="fas fa-check-circle"></i> ${ch.successText || 'Respuesta correcta'}`);
    state.solved++;
    nextChapter();
    showToast(ch.successText || 'Correcto', true);
    playTone(880, 'sine', 0.15);
  } else {
    addLog(`<i class="fas fa-times-circle"></i> ${ch.failText || 'Respuesta incorrecta'}`);
    state.lives--;
    checkLives();
    nextChapter();
    showToast(ch.failText || 'Incorrecto', false);
    playTone(220, 'sawtooth', 0.15);
    shakeStage();
  }
  render();
}

function checkLives() {
  if (state.lives <= 0) {
    chapterBadge.textContent = 'Game Over';
    stageTitle.textContent = '<i class="fas fa-skull"></i> Neko ha fallado';
    stageText.textContent = 'Has perdido todas tus vidas. El sistema universitario permanece en caos.\n\nPero no te preocupes, ¡puedes intentarlo de nuevo!';
    stageChoices.innerHTML = '<div class="choice" onclick="reset()"><div class="choice-content">🔄 Reiniciar aventura</div></div>';
    save();
  }
}

function nextChapter() {
  state.chapterIndex++;
  save();
}

function shakeStage() {
  const stage = document.getElementById('stage');
  stage.classList.remove('shake');
  void stage.offsetWidth;
  stage.classList.add('shake');
  setTimeout(() => stage.classList.remove('shake'), 500);
}

// ============ EXERCISES MODAL ============
function openExercises() {
  let html = `
    <div class="modal-header">
      <h3><i class="fas fa-calculator"></i> Terminal de Práctica Matemática</h3>
      <button class="btn ghost" id="closeModalBtn">✕ Cerrar</button>
    </div>
    <div class="small" style="margin-bottom:24px;color:var(--ubuntu-muted)">
      Practica conceptos de sumatorias, conjuntos e inducción. Los ejercicios no afectan tus vidas.
    </div>
  `;

  exercises.forEach((ex) => {
    html += `<div class="exercise-item">`;
    // El título ya viene con el icono de Font Awesome
    html += `<div class="exercise-title">${ex.title}</div>`; 
    html += `<div class="exercise-prompt">${escapeHtml(ex.prompt)}</div>`;
    
    if (ex.formula) {
      html += `<div class="math-formula">${escapeHtml(ex.formula)}</div>`;
    }

    // Visual representations
    if (ex.visual === 'set' && ex.setA && ex.setB) {
      html += renderSetDiagram(ex.setA, ex.setB);
    } else if (ex.visual === 'induction') {
      html += renderInductionSteps();
    } else if (ex.visual === 'sum') {
      html += renderSummationVisual();
    }

    if (ex.type === 'input') {
      html += `
        <div class="input-row">
          <input id="ex-${ex.id}" type="text" placeholder="Tu respuesta...">
          <button class="btn" onclick="submitExercise('${ex.id}')">Comprobar</button>
        </div>
      `;
    } else if (ex.type === 'choice') {
      ex.choices.forEach((c) => {
        html += `<div class="choice" onclick="submitExerciseChoice('${ex.id}','${c.p}')" style="margin-top:8px">
          <div class="choice-content">${escapeHtml(c.t)}</div>
        </div>`;
      });
    }

    html += `</div>`;
  });

  showModal(html);
  document.getElementById('closeModalBtn').addEventListener('click', closeModal);
}

function renderSetDiagram(setA, setB) {
  const aStr = setA.join(', ');
  const bStr = setB.join(', ');
  return `
    <div class="set-diagram">
      <div class="set-circle">
        <div class="set-label">A</div>
        {${aStr}}
      </div>
      <div style="font-size:24px;color:var(--ubuntu-orange)"><i class="fas fa-intersection"></i></div>
      <div class="set-circle">
        <div class="set-label">B</div>
        {${bStr}}
      </div>
    </div>
  `;
}

function renderInductionSteps() {
  return `
    <div class="induction-steps">
      <div class="induction-step">
        <div class="step-title">1️ Caso Base</div>
        <div>Verificar que P(1) es verdadero</div>
      </div>
      <div class="induction-step">
        <div class="step-title">2️⃣ Hipótesis Inductiva</div>
        <div>Asumir que P(k) es verdadero</div>
      </div>
      <div class="induction-step">
        <div class="step-title">3️⃣ Paso Inductivo</div>
        <div>Probar que P(k+1) es verdadero</div>
      </div>
    </div>
  `;
}

function renderSummationVisual() {
  return `
    <div style="background:rgba(0,0,0,0.2);padding:20px;border-radius:12px;margin:16px 0;text-align:center">
      <div style="font-size:40px;color:var(--ubuntu-orange);margin-bottom:12px"><i class="fas fa-sigma"></i></div>
      <div style="font-family:'Ubuntu Mono',monospace;color:var(--ubuntu-muted)">
        Suma de términos consecutivos
      </div>
    </div>
  `;
}

window.submitExercise = function(exId) {
  const ex = exercises.find(e => e.id === exId);
  if (!ex) return;
  
  const inputEl = document.getElementById('ex-' + exId);
  const raw = (inputEl?.value || '').trim();
  const cleaned = raw.toLowerCase().replace(/\s+/g, '');
  
  const accepted = (ex.answers || []).some(a => 
    normalizeAnswer(a) === normalizeAnswer(cleaned)
  );
  
  state.exercises[exId] = {ok: accepted, answer: raw, ts: Date.now()};
  save();
  const logIcon = accepted ? '<i class="fas fa-check-circle"></i>' : '<i class="fas fa-times-circle"></i>';
  addLog(`${ex.title} — ${logIcon} ${accepted ? 'correcto' : 'incorrecto'}`);
  
  const toastIcon = accepted ? '<i class="fas fa-check-circle"></i>' : '<i class="fas fa-times-circle"></i>';
  showToast(toastIcon + ' ' + ex.explain, accepted);
  
  if (accepted) playTone(880, 'sine', 0.12);
  else playTone(220, 'sawtooth', 0.12);
};

window.submitExerciseChoice = function(exId, chosen) {
  const ex = exercises.find(e => e.id === exId);
  if (!ex) return;
  
  const ok = ('' + chosen) === ('' + ex.answer);
  state.exercises[exId] = {ok: ok, answer: chosen, ts: Date.now()};
  save();
  const logIcon = ok ? '<i class="fas fa-check-circle"></i>' : '<i class="fas fa-times-circle"></i>';
  addLog(`${ex.title} — ${logIcon} ${ok ? 'correcto' : 'incorrecto'}`);
  
  const toastIcon = ok ? '<i class="fas fa-check-circle"></i>' : '<i class="fas fa-times-circle"></i>';
  showToast(toastIcon + ' ' + ex.explain, ok);
  
  if (ok) playTone(880, 'sine', 0.12);
  else playTone(220, 'sawtooth', 0.12);
};

function normalizeAnswer(s) {
  if (!s) return '';
  return s.toString().toLowerCase().replace(/\s+/g, '').replace(/[{}]/g, '');
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
  // Usar innerHTML para mostrar el icono de Font Awesome en el mensaje
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
    
    html += `
      <div class="exercise-item" style="opacity:${locked ? '0.5' : '1'}">
        <div class="exercise-title">
          ${icon} Capítulo ${c.id}: ${escapeHtml(c.title)}
        </div>
        <div class="exercise-prompt">${escapeHtml(c.text.substring(0, 100))}...</div>
        ${!locked ? `<button class="btn ghost" onclick="gotoChapter(${idx})">Ir a este capítulo</button>` : '<div class="small"><i class="fas fa-lock"></i> Debes completar el capítulo anterior</div>'}
      </div>
    `;
  });
  
  showModal(html);
  document.getElementById('closeChapters').addEventListener('click', closeModal);
}

window.gotoChapter = function(idx) {
  state.chapterIndex = idx;
  save();
  closeModal();
  render();
  addLog(`<i class="fas fa-book-open"></i> Navegaste al capítulo ${idx + 1}`);
};

function openSettings() {
  const html = `
    <div class="modal-header">
      <h3><i class="fas fa-cog"></i> Configuración del Juego</h3>
      <button class="btn ghost" id="closeSettings">✕ Cerrar</button>
    </div>
    
    <div class="exercise-item">
      <div class="exercise-title"><i class="fas fa-heart"></i> Vidas</div>
      <div class="exercise-prompt">Ajusta el número de vidas disponibles</div>
      <div class="input-row">
        <input id="sLives" type="number" value="${state.lives}" min="1" max="9" style="flex:0 0 100px">
        <button class="btn" id="applySettings">Aplicar cambios</button>
      </div>
    </div>

    <div class="exercise-item">
      <div class="exercise-title"><i class="fas fa-chart-bar"></i> Estadísticas</div>
      <div class="exercise-prompt">
        <strong>Capítulo actual:</strong> ${state.chapterIndex + 1}/${chapters.length}<br>
        <strong>Problemas resueltos:</strong> ${state.solved}<br>
        <strong>Ejercicios completados:</strong> ${Object.keys(state.exercises).length}/${exercises.length}<br>
        <strong>Vidas restantes:</strong> ${state.lives}
      </div>
    </div>

    <div class="exercise-item">
      <div class="exercise-title"><i class="fas fa-trash-alt"></i> Zona Peligrosa</div>
      <div class="exercise-prompt">Reiniciar completamente el progreso</div>
      <button class="btn ghost" onclick="if(confirm('¿Estás seguro de reiniciar TODO el progreso?')) { reset(); closeModal(); }" style="background:var(--ubuntu-danger);color:#fff">
        Reiniciar todo
      </button>
    </div>
  `;
  
  showModal(html);
  document.getElementById('closeSettings').addEventListener('click', closeModal);
  document.getElementById('applySettings').addEventListener('click', () => {
    const v = parseInt(document.getElementById('sLives').value, 10) || 3;
    state.lives = Math.max(1, Math.min(9, v));
    save();
    addLog(`<i class="fas fa-cog"></i> Vidas ajustadas a ${state.lives}`);
    showToast('Configuración guardada', true);
    closeModal();
    render();
  });
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
if (state.log.length === 0) {
  addLog('<i class="fas fa-cat"></i> Bienvenido a la aventura de Neko');
  addLog('🎮 Sistema Ubuntu iniciado');
}
render();
createParticles();

// Expose functions for inline handlers
window.reset = reset;
window.openExercises = openExercises;
window.submitExerciseChoice = submitExerciseChoice;
window.submitExercise = submitExercise;
window.gotoChapter = gotoChapter;
window.closeModal = closeModal;