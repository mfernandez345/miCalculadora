# 🔢 Calculadora
Aplicación JavaFX que muestra una interfaz gráfica de una calculadora utilizando estilos CSS.  
La lógica de las operaciones aritméticas está implementada en la clase `Calculadora`, que 
incluye los métodos de suma, resta, multiplicación y división.

El proyecto incorpora una clase de pruebas unitarias, creadas con JUnit 
`CalculadoraTest`, que valida el funcionamiento correcto de los métodos de la clase `Calculadora`. 

Además, el proyecto utiliza un flujo de integración y despliegue continuos (CI/CD) 
configurado con GitHub Actions. Este sistema ejecuta automáticamente las pruebas unitarias y
genera la documentación JavaDoc en cada actualización del repositorio.
La documentación resultante se publica en GitHub Pages y puede consultarse fácilmente desde
cualquier navegador mediante la URL del proyecto.

Este proyecto forma parte de la práctica grupal de la asignatura 
"Procesos en Ingeniería del Software".


---

## ✨ Requisitos funcionales de la práctica
- Implementación de operaciones básicas: suma, resta, multiplicación y división.


- Definición de al menos tres casos de prueba diferentes para cada operación matemática.


---

## 📁 Estructura del proyecto

```
miCalcmiCalculadora/
│
├── src/
│   └── miCalculadora/
│       ├── Main.java
│       ├── Calculadora.java
│       ├── OverFlowException.java
│       ├── UnderFlowException.java
│       └── calculadora.css
│
└── test/
    └── miCalculadoraTest/
        └── CalculadoraTest.java
```


---

## 🧪 Pruebas unitarias

El proyecto incluye un conjunto completo de pruebas para validar el comportamiento de la 
clase `Calculadora`.  

Las pruebas cubren:

- Casos con números positivos.
- Casos con números negativos.
- Casos con ceros.
- Casos límite.


---

## 📚 Documentación JavaDoc

La documentación completa del proyecto (incluyendo los tests) está disponible en:

👉 **https://inesdev-org.github.io/miCalculadora/**


---

## 🛠 Tecnologías utilizadas, Servicios y Herramientas de desarrollo

- **Tecnologías**
  - Java 25: Eclipse Adoptium Temurin jdk-25.0.1.8-hotspot
  - JavaFx 25: javafx-sdk-25.0.1
  - JUnit 5: junit-jupiter-api-5.14.0


- **Servicios**
  - GitHub Actions
  - GitHub Pages


- **Herramientas**
  - IntelliJ IDEA 2015.2.6 (Community Edition)
  - Git 2.52.0


---

## 🧑‍💻 Autores y Roles

Proyecto realizado por el grupo de prácticas N02:

- **María Asunción Fas Vicent**: Functional Analyst.
- **María Inés Fernández Álvarez**: Software Developer.
- **Carlos Isidro Fenández Carbonell**: Product Owner.
- **Jorge Enrique Fungueiro Rodríguez**: Scrum Master.
- **Sergio Pérez González**: QA Tester.


---

## 📄 Licencia

Este proyecto se distribuye únicamente con fines académicos.
