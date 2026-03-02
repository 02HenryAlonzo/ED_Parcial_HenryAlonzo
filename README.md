# ED_Parcial_HenryAlonzo

**Estudiante:** Henry Alonzo  
**Asignatura:** Estructura de Datos  
**Catedrático:** Ing. Brandon Chitay  
**Universidad:** Da Vinci de Guatemala — Facultad de Ingeniería, Industria y Tecnología  
**Evaluación:** Examen Parcial Práctico

---

## 📋 Descripción del Proyecto

Este proyecto implementa **4 algoritmos clásicos** en sus versiones **iterativa y recursiva** (8 implementaciones en total) usando Java 11+. El objetivo es medir experimentalmente sus tiempos de ejecución con distintos volúmenes de datos, graficar los resultados y confirmar la **notación Big-O** de cada algoritmo.

### Algoritmos implementados

| # | Algoritmo | Iterativo | Recursivo |
|---|-----------|-----------|-----------|
| A1 | Factorial | O(n) | O(n) |
| A2 | Serie de Fibonacci | O(n) | O(2^n) |
| A3 | Búsqueda Lineal | O(n) | O(n) |
| A4 | Ordenamiento Burbuja | O(n²) | O(n²) |

---

## 🗂️ Estructura del Proyecto

```
ED_Parcial_HenryAlonzo/
├── src/
│   ├── algorithms/
│   │   ├── Factorial.java
│   │   ├── Fibonacci.java
│   │   ├── BusquedaLineal.java
│   │   └── OrdenamientoBurbuja.java
│   ├── benchmark/
│   │   ├── Medidor.java
│   │   └── Main.java
│   └── utils/
│       └── GeneradorDatos.java
├── resultados/
│   └── tiempos.csv
|   └── Tiempos_Rendimiento.xls
├── documentacion/
│   └── ED_Parcial_HenryAlonzo.pdf
├── .gitignore
└── README.md
```

---

## ⚙️ Requisitos

- **Java 11 o superior**
- Verificar versión instalada:
  ```bash
  java -version
  ```

---

## 🚀 Cómo compilar y ejecutar

### 1. Clonar el repositorio
```bash
git clone https://github.com/[tu-usuario]/ED_Parcial_HenryAlonzo.git
cd ED_Parcial_HenryAlonzo
```

### 2. Compilar todos los archivos Java
```bash
javac -d bin src/algorithms/*.java src/utils/*.java src/benchmark/*.java
```

### 3. Ejecutar el programa
```bash
java -cp bin benchmark.Main
```

### 4. Ver resultados
El programa genera automáticamente el archivo `resultados/tiempos.csv` con todos los tiempos medidos.

---

## 📊 Resultados

Los tiempos de ejecución se encuentran en:
- `resultados/tiempos.csv` — datos crudos exportados por el programa
- `Tiempos_Rendimiento.xlsx` — análisis completo con gráficas de tendencia

---

## 🎥 Video de Demostración

> 🔗 **Link al video:** _[https://universidaddavincid-my.sharepoint.com/:v:/g/personal/202503003_estudiante_udv_edu_gt/IQDT70zRu90MSJqoTcfIpdx2AdPne7u1ERsLRUSSsV217RQ?e=4lvU40&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D]_

---

## 📄 Documentación Técnica

El PDF con la documentación completa se encuentra en la carpeta `/documentacion/`.

---

## 🤖 Anexo — Prompts de IA utilizados

Durante el desarrollo de este proyecto se utilizó inteligencia artificial como apoyo. Los prompts utilizados se documentan en el PDF de documentación técnica en la sección de Anexos.