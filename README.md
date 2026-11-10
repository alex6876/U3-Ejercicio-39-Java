Aquí tienes la estructura en formato Markdown lista para el `README.md` de este código de **Simulación de Gestión de Cursos y Oferta Académica (Herencia, Sobrescritura y Polimorfismo en Java)**, manteniendo el enfoque exclusivo de **Programación Orientada a Objetos en memoria** (sin bases de datos):

---

# 🎓 Simulación de Gestión de Cursos y Oferta Académica (Herencia y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema de gestión educativa para una plataforma de aprendizaje, implementando una jerarquía de clases mediante herencia para administrar distintas modalidades formativas (cursos grabados, mentorías en vivo y talleres presenciales) con reglas especializadas para el control de cupos, disponibilidad de plataforma, conectividad y cálculo de costos con descuentos. Pone en práctica conceptos fundamentales de la **Programación Orientada a Objetos (POO)** como la **generalización de atributos protegidos (`protected`)**, la utilización de constructores mediante `super`, la sobrescritura polimórfica de métodos (`@Override`), la validación defensiva de estados y el procesamiento masivo mediante arreglos polimórficos en memoria.

---

## 🧩 Clases y Estructura del Sistema

El diseño del software se organiza a través de una clase base general, sus respectivas subclases especializadas y un punto de ejecución:

* **`Curso`**: Clase base que centraliza los atributos y comportamientos comunes de cualquier oferta formativa de la institución.
* **Atributos protegidos (`protected`)**: `nombreCurso`, `horasTotales`, `precioBase` y `alumnosInscritos`, permitiendo que las clases hijas accedan directamente a los datos básicos y al conteo de matrículas.
* **Constructor**: Inicializa los metadatos comunes del curso y establece el contador inicial de alumnos inscritos en cero (`0`).
* **Métodos operativos**:
* `calcularCostoFinal(double descuento)`: Valida el rango del descuento (0 a 100%) y computa el precio final aplicando la rebaja sobre el costo base.
* `inscribirAlumno(String nombreAlumno)`: Comportamiento base que incrementa el contador de alumnos y confirma la inscripción por consola.
* `mostrarInformacion()`: Imprime de forma estructurada el nombre del curso, las horas totales, el precio base y la cantidad de alumnos inscritos.




* **`CursoGrabado`**: Extiende de `Curso` para modelar programas educativos asincrónicos alojados en plataformas externas.
* **Atributos privados (`private`)**: `plataformaAlojamiento`, `fechaLimiteAcceso` y `plataformaDisponible`.
* **Constructor**: Invoca a `super(...)` para configurar los datos base y asigna los parámetros de disponibilidad digital.
* **Sobrescritura (`@Override`)**:
* `inscribirAlumno(String nombreAlumno)`: Verifica de forma defensiva si la plataforma se encuentra disponible antes de matricular al alumno y registrar el éxito de la operación.
* `mostrarInformacion()`: Reutiliza `super.mostrarInformacion()` y detalla la plataforma, fecha límite de acceso y estado de disponibilidad.




* **`MentoriaEnVivo`**: Extiende de `Curso` para modelar clases sincrónicas en tiempo real con cupos limitados.
* **Atributos privados (`private`)**: `enlaceVideollamada`, `cupoMaximo` y `conectividadDisponible`.
* **Constructor**: Utiliza `super(...)` para inicializar los atributos heredados y configura el enlace y los topes de capacidad.
* **Sobrescritura (`@Override`)**:
* `inscribirAlumno(String nombreAlumno)`: Implementa una doble validación defensiva comprobando la conectividad de la red y el respeto estricto del cupo máximo antes de admitir al estudiante.
* `mostrarInformacion()`: Muestra los datos base mediante `super`, añadiendo el enlace de videollamada, el cupo máximo y el estado de conectividad.




* **`TallerPresencial`**: Extiende de `Curso` para modelar experiencias de aprendizaje físicas en aulas con aforo limitado.
* **Atributos privados (`private`)**: `numeroAula`, `direccionFisica` y `capacidadAula`.
* **Constructor**: Utiliza `super(...)` y configura la ubicación geográfica y la capacidad del recinto.
* **Sobrescritura (`@Override`)**:
* `inscribirAlumno(String nombreAlumno)`: Controla que los alumnos inscritos no alcancen o superen la capacidad física del aula, rechazando la matrícula en caso de aforo completo.
* `mostrarInformacion()`: Reutiliza la lógica base e incorpora el número de aula, la dirección y la capacidad del recinto.




* **`Main`**: Punto de entrada del programa. Instancia un curso grabado, una mentoría en vivo y un taller presencial con datos específicos, simula rondas de inscripción de alumnos que demuestran la activación de los controles de cupo y conectividad, y recorre la oferta académica mediante un arreglo polimórfico de tipo `Curso[]` para generar el reporte consolidado de información y costos con descuento por consola.

---

## ⚙️ Reglas de Negocio y Control de Validación

1. **Validación Defensiva de Inscripciones:** Cada modalidad implementa su propia regla de control en el método `inscribirAlumno` (verificando disponibilidad de servidores en cursos grabados, conectividad y aforo en mentorías, y capacidad física en talleres presenciales).
2. **Cálculo Seguro de Descuentos:** El método `calcularCostoFinal` protege la integridad financiera validando que el porcentaje de descuento ingresado se encuentre estrictamente entre el 0% y el 100%.
3. **Procesamiento Masivo Uniforme:** El uso de un arreglo de la clase padre (`Curso[]`) permite recorrer y consultar la oferta formativa de manera completamente polimórfica, sin importar si se trata de un curso grabado, una mentoría o un taller presencial.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
===== INSCRIPCIONES DE ALUMNOS =====
Carlos se inscribio al curso grabado.
Lucia se inscribio al curso grabado.

Pedro se inscribio a la mentoria en vivo.
Maria se inscribio a la mentoria en vivo.
Inscripcion rechazada: cupo completo.

Sofia se inscribio al taller presencial.
Diego se inscribio al taller presencial.
Inscripcion rechazada: aula sin lugares disponibles.

===== OFERTA ACADEMICA =====

------------------------------
Curso: Java desde cero
Horas totales: 40
Precio base: $50000.0
Alumnos inscritos: 2
Plataforma: Udemy
Fecha limite de acceso: 31/12/2026
Plataforma disponible: true
Costo final con 10% de descuento: $45000.0

------------------------------
Curso: Programacion orientada a objetos
Horas totales: 20
Precio base: $80000.0
Alumnos inscritos: 2
Enlace de videollamada: https://meet.google.com/ejemplo
Cupo maximo: 2
Conectividad disponible: true
Costo final con 10% de descuento: $72000.0

------------------------------
Curso: Desarrollo de aplicaciones
Horas totales: 15
Precio base: $60000.0
Alumnos inscritos: 2
Numero de aula: 5
Direccion: Av. San Martin 1500, Mendoza
Capacidad del aula: 2
Costo final con 10% de descuento: $54000.0

```

---

## 🚀 Conceptos de Programación Aplicados

* **Jerarquía Educativa:** Modelado de modalidades formativas mediante una arquitectura limpia de herencia orientada a objetos.
* **Sobrescritura y Ligadura Dinámica (`@Override`):** Implementación de reglas de validación de matrículas especializadas que se ejecutan automáticamente según el tipo real de curso.
* **Diseño Modular:** Clara separación entre el dominio de negocio académico y la ejecución de casos de prueba simulados en el cliente (`Main`).
