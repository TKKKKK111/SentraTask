@Perfil

Feature: Gestión del perfil de usuario
  Como usuario autenticado
  Quiero poder visualizar y actualizar mis datos personales
  Para asegurar que mi información en el sistema esté correcta y actualizada

Scenario: Validar que el sistema permita navegar a la vista Perfil
  Given el usuario ha iniciado sesión
  When el usuario navega a la opción Perfil
  Then el sistema debe mostrar la vista Perfil

Scenario: Verificar campos precargados con la información del usuario
    Given el usuario está en la Modal Perfil
    When se visualizan los campos del formulario
    Then los campos deben mostrar la información actual del usuario

  Scenario: Modificar nombre del usuario
   Given el usuario está en Formulario Perfil
    When ingresa un nuevo nombre en el campo nombre
    And presiona el botón modificar usuario
    Then el nombre del usuario se actualiza correctamente

  Scenario: Modificar correo electrónico del usuario
    Given el usuario está en la Modal Perfil
    When ingresa un nuevo correo válido en el campo correo
    And presiona el botón modificar usuario
    Then el correo electrónico del usuario se actualiza correctamente

  Scenario: Cancelar cambios realizados
    Given el usuario está en la Modal Perfil
    When realiza modificaciones en los campos
    And presiona el botón cancelar
    Then los campos mantienen la información original

  Scenario: Redirigir a cambio de contraseña
    Given el usuario debe estar en la vista Perfil
    When presiona el botón Cambiar contraseña
    Then el sistema redirige a la vista de cambio de contraseña

  Scenario: Cambiar contraseña correctamente
    Given el usuario está en la modal de cambio de contraseña
    When ingresa la nueva contraseña en ambos campos y coinciden
    And presiona el botón Guardar
    Then la contraseña se actualiza correctamente


Scenario: Iniciar sesión con nueva contraseña
    Given la contraseña se actualizo correctamente
    Then intenta iniciar sesión con la nueva contraseña

  Scenario: Contraseñas no coinciden
    Given el usuario está en la modal de cambio de contraseña
    When ingresa contraseñas diferentes en los campos
    And presiona el botón Guardar
    Then el sistema no permite cambiar la contraseña y muestra error en modal Editar Usuario

 