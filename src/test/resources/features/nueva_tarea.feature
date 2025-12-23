@nuevaTarea

Feature: Gestión de Tareas
  Como usuario
  Quiero poder crear, visualizar y cancelar tareas
  Para administrar mis tareas correctamente

  
  Scenario: Mostrar lista de tareas asociadas al usuario
    Given el usuario inicia sesión con usuario con tareas
    When se deben mostrar todas las tareas asociadas al usuario en la lista

  # Caso 2: Mostrar modal de creación
  Scenario: Mostrar modal al presionar "Crear nueva Tarea"
    When el usuario presiona el botón Crear nueva Tarea
    Then se debe abrir el modal de creación con todos los campos visibles

  # Caso 3: Validar campos del formulario
  Scenario: Campos del formulario de creación
    Given el modal de creación está abierto
    Then el formulario debe mostrar los campos: Título, Descripción, Fecha de Vencimiento y Prioridad

  # Caso 4: Crear tarea con datos válidos
 Scenario: Crear nueva tarea correctamente
  Given el modal de creación está abierto
  When el usuario ingresa:
    | Campo                | Valor                  |
    | Título               | Tarea Testing        |
    | Descripción          | Descripción Testing       |
    | Fecha de Vencimiento | 2025-12-20T19:29   |
    | Prioridad            | 1                      |
  And presiona botón Crear Tarea
  Then la tarea se crea correctamente



  # Caso 7: Cancelar creación
  Scenario: Cancelar creación de tarea
    Given el usuario debe abrir Modal creación
    Then el usuario clickea botón Cancelar Tarea
    And el usuario retorna a la vista Home
