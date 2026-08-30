TP1

Este proyecto implementa un sistema para la gestión y administración de eventos universitarios, salas, actividades académicas e inscripciones de estudiantes. El objetivo principal es aplicar y consolidar los conceptos fundamentales de la Programación Orientada a Objetos (POO) en Java:

- **Encapsulamiento y modificadores de acceso:** Protección del estado interno de los objetos y definición de métodos de acceso/modificación.
- **Relaciones entre objetos:**
  - **Asociación:** Vinculación entre inscripciones y estudiantes.
  - **Agregación:** Relación entre el evento y la sala asignada (la sala tiene un ciclo de vida independiente del evento).
  - **Composición:** Relación entre el evento y sus actividades (las actividades son instanciadas y gestionadas por el evento, dependiendo de su ciclo de vida).
- **Herencia y Polimorfismo:** Jerarquía con una clase abstracta base `Actividad` y sus clases derivadas concretas `Charla` y `Taller`, permitiendo el cálculo dinámico de costos y presentación polimórfica de identificación.
- **Constantes, miembros estáticos y métodos finales:** Uso de `final` en atributos invariables y en métodos como `mostrarIdentificacion()` para evitar su redefinición, junto con variables de clase (`static`) para el conteo global de eventos instanciados.

---

## Estructura del Dominio

```text
├── Actividad (abstract)
│    ├── Charla
│    └── Taller
├── EventoUniversitario
├── Sala
├── Estudiante
├── Inscripcion
└── App (Clase ejecutable / Main)

```

### Principales Responsabilidades por Clase
* **`EventoUniversitario`:** Gestiona el costo base, gratuidad, sala asignada y su lista de actividades. Posee constructor de copia y métodos para calcular el costo estimado total (incluyendo el 21% de impuestos sobre la base y materiales de actividades).
* **`Actividad` (Clase Abstracta):** Define los atributos comunes (`id`, `titulo`, `cupoMaximo`, `CUPO_MINIMO`, colección de `Inscripcion`). Declara los métodos abstractos `calcularCostoMateriales()` y `getTipo()`, y el método final `mostrarIdentificacion()`.
* **`Charla`:** Hereda de `Actividad`. Incorpora el atributo `disertante`. Su costo de materiales es `$0.0`.
* **`Taller`:** Hereda de `Actividad`. Incorpora `requiereNotebook`. Su costo de materiales es `$5000.0` si requiere notebook y `$2000.0` si no la requiere.
* **`Sala`:** Modela el espacio físico donde se desarrolla un evento.
* **`Estudiante`:** Modela al alumno mediante `legajo` y `nombre`.
* **`Inscripcion`:** Clase de asociación entre `Actividad` y `Estudiante` que registra la fecha (`LocalDate.now()`) y el estado.
