@Registro

####################################

#¡¡¡IMPORTANTE!!!! Las validaciones de campos no fueron automatizadas al 100%
#ya que no se encuentran implementadas en la versión actual del sistema.
#Estas fueron identificadas y documentadas como incidentes a corregir para una "futura implementación".


##Solamente se pudo validar el caso de contraseñas no coincidentes y el flujo de cancelar registro. 
##Ya que estos sí cuentan con mensajes y comportamientos visibles en la UI.

###################################

Feature: Registro
  Como usuario del sistema
  Quiero registrarme
  Para poder acceder a la aplicación


@R_001
Scenario: Acceso a pantalla de registro
  Given el usuario se encuentra en la pantalla de login
  When presiona el botón "Crear nuevo usuario"
  Then el sistema redirige al formulario de registro


@R_002
Scenario: Registro exitoso con datos válidos
  Given el usuario accede al formulario de registro
  When ingresa nombre válido
  And ingresa apellido válido
  And ingresa email válido
  And ingresa contraseña válida
  And confirma la contraseña correctamente
  And presiona el botón Registrar usuario
  Then el sistema registra al usuario correctamente
  And redirige al login



@R_009
Scenario: Registro con contraseñas no coincidentes
  Given el usuario accede al modal de registro
  When el usuario se encuentra en el formulario de registro
  And ingresa nombre válido
  And confirma una contraseña distinta
  And presiona el botón Registrar usuario
 Then el sistema muestra el mensaje "Contraseñas no coinciden"


@R_013
Scenario: Cancelar registro
  Given el usuario clickea en el botón Crear nuevo usuario
  And Accede al formulario de registro
  When presiona el botón Cancelar
  Then el sistema redirige a la pantalla de login
