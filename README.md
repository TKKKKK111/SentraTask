🟢 SentraTask – Proyecto de Automatización de Pruebas

Descripción:
Automatización de pruebas de los módulos principales de SentraTask, garantizando que las funcionalidades críticas funcionen correctamente y que las validaciones del sistema sean confiables.

📊 Módulos y Casos de Prueba
Módulo	Casos Totales	Observaciones
🏠 Home	        10	    Visualización, navegación y ordenamiento de tareas
🔑 Login	    5	    Inicio de sesión y validación de datos
✏️ NuevaTarea	9	    Creación, edición, cancelación y validación de tareas
👤 Perfil	    10	    Modificación de datos, cambio de contraseña y navegación
📝 Registro	    4	    Registro de usuarios y validación de campos

Otros casos:

⚙️ Manual: 30 casos

❌ Sin desarrollar: 21 casos (validaciones no críticas para automatización)







📂 Estructura del Proyecto
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
        └── features             # Archivos Gherkin
            ├── home.feature
            ├── login.feature
            ├── nueva_tarea.feature
            ├── perfil.feature
            └── registro.feature











▶️ Ejecución de Pruebas por Módulo (En el orden que se muestra)
Módulo	Comando Gradle	Observación
🔑 Login	    ./gradlew test "-Dcucumber.filter.tags=@Login"  	✅ Todos los escenarios deben pasar

📝 Registro	    ./gradlew test "-Dcucumber.filter.tags=@Registro"	✅ Registros exitosos y fallidos (Ya que están controlados los errores esperados) se consideran válidos

🏠 Home	        ./gradlew test "-Dcucumber.filter.tags=@Home"	-   ✅ Se considerarán válidos los casos que muestren usuarios sin tareas y con tarea, además del orden de las tabla.

👤 Perfil    ./gradlew test "-Dcucumber.filter.tags=@Perfil"	✅ Ediciones del perfil exitosas  y fallidas (Se controlan los errores esperados) se consideran válidos

✏️ NuevaTarea	./gradlew test "-Dcucumber.filter.tags=@nuevaTarea"	✅ Creación y edición de tareas exitosos se consideran válidos (No tiene validaciones para ningun campo/ está documentado)



✅ Interpretación de Resultados
Cada escenario debe pasar al 100% para considerarse exitoso.
Los casos que fallen se revisan en los logs y se corrigen antes de la siguiente ejecución. 
En caso del PerfilPage: Se podrá *ejecutar una vez*,ya que editará los datos de la cuenta y el dato se deberá ser acondicionado.
Las pruebas automatizadas cubren los flujos principales y validaciones críticas; los casos manuales o sin desarrollo se documentan pero no se ejecutan automáticamente.
