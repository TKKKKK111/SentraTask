@Home
Feature: HomePage
  Como usuario autenticado
  Quiero acceder a la vista Home
  Para gestionar mis tareas de manera eficiente


@H_001
Scenario: Acceso a la vista Home con usuario autenticado
  Given el usuario ha iniciado sesión correctamente
  When el usuario ingresa sus credenciales validas
  Then el sistema muestra la vista Home correctamente


@H_005
Scenario: Usuario sin tareas registradas
  Given el usuario se encuentra en la vista Home sin Tareas
  Then el sistema muestra el mensaje "No existen tareas para el usuario"


@H_008
Scenario: Apertura del modal Crear nueva Tarea
  Given el usuario ha iniciado sesión correctamente
  When presiona el botón Crear Nuevo Tarea
  Then se muestra el modal Crear nueva Tarea
  And se cierra el modal Crear Nueva Tarea al presionar el botón Cancelar


@H_009
Scenario: Ordenar tareas por Título
  Given el usuario ha iniciado sesión con un usuario con tareas
  When ordena las tareas por Título de forma ascendente
  Then las tareas se muestran ordenadas alfabéticamente de A a Z
  When ordena las tareas por Título de forma descendente
  Then las tareas se muestran ordenadas alfabéticamente de Z a A


@H_010
Scenario: Ordenar tareas por Fechas
  Given el usuario iniciado sesión posee tareas con Fecha
  When ordena las tareas por fechas de forma ascendente
  Then las tareas se muestran ordenadas desde la más próxima a la más lejana
  When ordena las tareas por fechas de forma descendente
  Then las tareas se muestran ordenadas desde la más lejana a la más próxima


@H_012
Scenario: Ordenar tareas por Prioridad
  Given el usuario iniciado sesión posee tareas con Prioridad
  When ordena las tareas por Prioridad de forma ascendente
  Then las tareas se muestran ordenadas desde la prioridad más baja a la más alta
  When ordena las tareas por Prioridad de forma descendente
  Then las tareas se muestran ordenadas desde la prioridad más alta a la más baja


@H_013
Scenario: Mantener orden al navegar entre páginas
  Given el usuario ha iniciado sesión con un usuario con muchas tareas
  When navega a la siguiente página de la tabla
  And navega a la página anterior de la tabla
  Then el orden de las tareas se mantiene


@H_014
Scenario: Visualización de cantidad de tareas por página
  Given el usuario ha iniciado sesión con un usuario con muchas tareas
  When selecciona mostrar 10 tareas por página
  Then el sistema muestra 10 tareas en la tabla
  And el contador de registros se muestra correctamente


@H_016
Scenario: Navegación entre páginas de la tabla
  Given el usuario ha iniciado sesión con un usuario con muchas tareas
  When navega a la siguiente página de la tabla
  And navega a la página anterior de la tabla
  Then el contador de registros se actualiza correctamente al cambiar de página


@H_017
Scenario: Activar visualización de tabla compacta
  Given el usuario ha iniciado sesión con un usuario con muchas tareas
  When activa el interruptor Tabla compacta
  Then la tabla reduce el espacio entre filas correctamente
  And al desactivar el interruptor Tabla compacta, la tabla vuelve a su formato original
