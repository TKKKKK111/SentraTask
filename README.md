# 🟢 SentraTask — Automatización de Pruebas

Un conjunto de pruebas automatizadas para los módulos principales de SentraTask. El objetivo es garantizar que las funcionalidades críticas funcionen correctamente y que las validaciones del sistema sean confiables.

---

## 📋 Contenido
- Descripción
- Módulos y casos de prueba
- Estructura del proyecto
- Cómo ejecutar las pruebas
- Interpretación de resultados y notas

---

## 🧭 Descripción
Este repositorio contiene pruebas automatizadas (Cucumber + Java) organizadas con Page Object Model y Steps. Las pruebas cubren flujos principales: login, registro, gestión de tareas, perfil y navegación en la Home.

---

## 📊 Módulos y Casos de Prueba

| Módulo      | Casos Totales | Observaciones |
|-------------|---------------:|--------------|
| 🏠 Home     | 10             | Visualización, navegación y ordenamiento de tareas |
| 🔑 Login    | 5              | Inicio de sesión y validación de datos |
| ✏️ NuevaTarea | 9            | Creación, edición, cancelación y validación de tareas |
| 👤 Perfil   | 10             | Modificación de datos, cambio de contraseña y navegación |
| 📝 Registro | 4              | Registro de usuarios y validación de campos |

Otros:
- ⚙️ Manual: 30 casos
- ❌ Sin desarrollar: 22 casos (validaciones no críticas para automatización)

---

## 📂 Estructura del Proyecto
El proyecto sigue el patrón Page Object + Steps (Cucumber). Estructura principal:

```text
src
└── test
    ├── java
    │   ├── pages                # Page Object Model
    │   │   ├── BasePage.java
    │   │   ├── HomePage.java
    │   │   ├── LoginPage.java
    │   │   ├── NuevaTareaPage.java
    │   │   ├── PerfilPage.java
    │   │   └── RegistroPage.java
    │   │
    │   ├── runner               # Test Runner
    │   │   └── TestRunner.java
    │   │
    │   └── steps                # Step Definitions
    │       ├── HomeSteps.java
    │       ├── LoginSteps.java
    │       ├── NuevaTareaSteps.java
    │       ├── PerfilSteps.java
    │       └── RegistroSteps.java
    │
    └── resources
        └── features            # Archivos Gherkin
            ├── home.feature
            ├── login.feature
            ├── nueva_tarea.feature
            ├── perfil.feature
            └── registro.feature
```

---

## ▶️ Ejecución de Pruebas por Módulo
Ejecuta con Gradle y filtrado por tags de Cucumber:

| Módulo     | Comando Gradle                                                      | Observación |
|------------|---------------------------------------------------------------------|-------------|
| 🔑 Login   | `./gradlew test "-Dcucumber.filter.tags=@Login"`                    | ✅ Todos los escenarios deben pasar |
| 📝 Registro| `./gradlew test "-Dcucumber.filter.tags=@Registro"`                 | ✅ Registros exitosos y fallidos (errores esperados) son válidos |
| 🏠 Home    | `./gradlew test "-Dcucumber.filter.tags=@Home"`                     | ✅ Casos con/ sin tareas y orden de la tabla |
| 👤 Perfil  | `./gradlew test "-Dcucumber.filter.tags=@Perfil"`                   | ✅ Ediciones exitosas y fallidas controladas son válidas |
| ✏️ NuevaTarea | `./gradlew test "-Dcucumber.filter.tags=@nuevaTarea"`            | ✅ Creación y edición exitosas son válidas |

Sugerencia: ejecutar en el orden mostrado para flujo lógico de pruebas (Login → Registro/Perfil → Home → NuevaTarea).

---

## ✅ Interpretación de Resultados
- Cada escenario debe pasar al 100% para considerarse exitoso.
- Los fallos se investigan a partir de los logs; corregir antes de la siguiente ejecución.
- Nota importante sobre Perfil: algunas pruebas editan datos de la cuenta; ejecutar esas pruebas con cuidado (idealmente en cuentas de prueba) porque cambian el estado y pueden necesitar restauración después.

---

## 📝 Notas y Buenas Prácticas
- Usar cuentas de prueba y datos aislados para evitar contaminación entre ejecuciones.
- Mantener los escenarios deterministas: limpiar estado entre tests cuando aplique.
- Registrar capturas y logs en los pasos críticos para facilitar debugging.
- Documentar casos manuales y pendientes para priorizarlos en futuras automatizaciones.

