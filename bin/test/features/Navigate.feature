Feature: Barra de Navegación
  Como usuario
  Quiero ver la barra de navegación
  Para acceder a las distintas páginas del sitio

Scenario Outline: : Puedo navegar através de la barra de navegación

  Given Puedo navegar "www.freerangertesters.com"
  When Hago clic en el enlace <section>
  Examples:
      | section  | 
      | Academia  |
      | Cursos  |
      | Mentorías  |
      | Talleres  |