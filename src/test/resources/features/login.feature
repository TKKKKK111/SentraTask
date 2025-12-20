@login
Feature: Login

  Background:
    Given el sistema web se encuentra disponible y operativo
    And el navegador web está abierto y soportado por el sistema

  @Login_001
  Scenario: Login exitoso con credenciales válidas
    Given el usuario se encuentra previamente registrado en el sistema
    And el usuario se encuentra en la pantalla de inicio de sesión
    When ingresa email "mail@mail.cl"
    And ingresa contraseña "123123"
    And presiona el botón Ingresar
    Then el sistema redirige a la vista principal
    And El usuario puede desloguearse



  @Login_002
  Scenario: Login con email válido y contraseña incorrecta
    Given el usuario se encuentra previamente registrado en el sistema
    And el usuario se encuentra en la pantalla de inicio de sesión
    When ingresa email "mail@mail.cl"
    And ingresa contraseña "incorrecta"
    And presiona el botón Ingresar
    Then el sistema muestra error credenciales incorrectas

  @Login_003
  Scenario: Login con email no registrado
    Given el usuario se encuentra en la pantalla de inicio de sesión
    When ingresa email "noexiste@sentra.cl"
    And ingresa contraseña "alguna_contraseña"
    And presiona el botón Ingresar
    Then el sistema muestra error credenciales incorrectas

  @Login_004
  Scenario: Login con email vacío
    Given el usuario se encuentra en la pantalla de inicio de sesión
    When ingresa email ""
    And ingresa contraseña "alguna_contraseña"
    And presiona el botón Ingresar
    Then el sistema muestra validacion nativa de email

  @Login_006
  Scenario: Login con email en formato inválido
    Given el usuario se encuentra en la pantalla de inicio de sesión
    When ingresa email "formatoinvalido"
    And ingresa contraseña "alguna_contraseña"
    And presiona el botón Ingresar
    Then el sistema muestra validacion nativa de email


  @Login_012
  Scenario: Redirección a home tras login exitoso
    Given el usuario se encuentra previamente registrado en el sistema
    And el usuario se encuentra en la pantalla de inicio de sesión
    When ingresa email "mail@mail.cl"
    And ingresa contraseña "123123"
    And presiona el botón Ingresar
    Then el sistema redirige a la vista principal