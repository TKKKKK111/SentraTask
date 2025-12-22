package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class HomeSteps {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    // =========================
    // LOGIN Y ACCESO A HOME
    // =========================

    @Given("el usuario ha iniciado sesión correctamente")
    public void el_usuario_ha_iniciado_sesion_correctamente() {
        loginPage.navigateTo("http://192.168.80.43:10500/home");
    }

    @When("el usuario ingresa sus credenciales validas")
    public void el_usuario_ingresa_sus_credenciales_validas() {
        loginPage.ingresarEmail("mirko.acevedo@correo.cl"); // Usuario SIN tareas
        loginPage.ingresarPassword("123");
        loginPage.clickIngresar();
    }

    @Then("el sistema muestra la vista Home correctamente")
    public void el_sistema_muestra_la_vista_home_correctamente() {
        homePage.isHomeVisible();
        
    }

    // =========================
    // HOME – USUARIO SIN TAREAS
    // =========================

    @Given("el usuario se encuentra en la vista Home sin Tareas")
    public void el_usuario_se_encuentra_en_la_vista_home_sin_tareas() {
        homePage.isHomeVisible();
    }

    @Then("el sistema muestra el mensaje \"No existen tareas para el usuario\"")
    public void el_sistema_muestra_el_mensaje_no_existen_tareas_para_el_usuario() {
        loginPage.navigateTo("http://192.168.80.43:10500/home");
        homePage.isSinTareasVisible();

    }

    // =========================
    // MODAL NUEVA TAREA
    // =========================

   @When("presiona el botón Crear Nuevo Tarea")
    public void presiona_el_boton_nueva_tarea() {
        homePage.clickNuevaTarea();
    }

    

    @Then("se muestra el modal Crear nueva Tarea")
    public void se_muestra_el_modal_crear_nueva_tarea() {
        homePage.isModalNuevaTareaVisible();
    }

    @And("se cierra el modal Crear Nueva Tarea al presionar el botón Cancelar")
    public void se_cierra_modal_crear_nueva_tarea_al_presionar_el_boton_cancelar() {
        homePage.clickCancelarNuevaTarea();
        homePage.modalNuevaTareaCerrado();
        loginPage.deslogearUsuario(); // Para finalizar el flujo y dejar el sistema limpio así proceder ocn los test con data
    }

    // =========================
    // HOME – USUARIO CON TAREAS
    // =========================


    @Given ("el usuario ha iniciado sesión con un usuario con tareas")
        public void el_usuario_ha_iniciado_sesion_con_un_usuaro_con_tareas(){
        loginPage.navigateTo("http://192.168.80.43:10500/home");
        loginPage.ingresarEmail("mail@mail.cl"); // Usuario CON tareas
        loginPage.ingresarPassword("123123");
        loginPage.clickIngresar();
        homePage.isHomeVisible();
        homePage.existenTareas();
        }


     @When ("ordena las tareas por Título de forma ascendente")
        public void ordena_las_tareas_por_titlo_de_forma_asc(){
            homePage.clickOrdenarPorTitulo();

        }

    @Then ("las tareas se muestran ordenadas alfabéticamente de A a Z")
    public void las_tareas_semuestran_ordenadas_a_z(){
            homePage.isOrdenTituloAsc();
            
        }

    @When ("ordena las tareas por Título de forma descendente")
        public void ordena_las_tareas_por_titulo_desc(){
            homePage.clickOrdenarPorTitulo();

        }

    @Then ("las tareas se muestran ordenadas alfabéticamente de Z a A")
        public void las_tareas_semuestran_ordenadas_z_a(){
            homePage.isOrdenTituloDesc();
        }



     @Given ("el usuario iniciado sesión posee tareas con Fecha")
     public void usuario_cuenta_con_tareas_con_fecha(){
            homePage.isHomeVisible();
            homePage.existenTareas();
           }

    @Given ("el usuario ha iniciado sesión con un usuario con muchas tareas")
     public void usuario_cuenta_con_tareas_con_muchas_tareas(){
            homePage.isHomeVisible();
            homePage.existenTareas();
           }


     @When ("ordena las tareas por fechas de forma ascendente")
        public void las_tareas_por_fecha_de_forma_asc(){
            homePage.clickOrdenarPorFechaCreacion();
            homePage.clickOrdenarPorFechaCVencimiento();

        }

     @Then ("las tareas se muestran ordenadas desde la más próxima a la más lejana")
        public void las_tareas_se_muesrtan_ordenadas_por_fecha_lejos(){
            homePage.isOrdenFechaAscCreacion();
            homePage.isOrdenFechaAscVenc();

        }

     @When ("ordena las tareas por fechas de forma descendente")
        public void las_tareas_por_fecha_de_forma_desc(){
            homePage.clickOrdenarPorFechaCreacion();
            homePage.clickOrdenarPorFechaCVencimiento();
        }
     @Then ("las tareas se muestran ordenadas desde la más lejana a la más próxima")
         public void las_tareas_se_muesrtan_ordenadas_por_fecha_prox(){
            homePage.isOrdenFechaDescVenc();
            homePage.isOrdenFechaDescCreacion();
        }

        @When ("ordena las tareas por Prioridad de forma ascendente")
        public void ordenar_las_tareas_por_prioridad_asc(){
            homePage.clickOrdenarPrioridad();
        }

         @Given ("el usuario iniciado sesión posee tareas con Prioridad")
         public void usuario_posee_tareas_con_prioridad(){
            homePage.isHomeVisible();
            homePage.existenTareas();

         }
        @Then ("las tareas se muestran ordenadas desde la prioridad más baja a la más alta")
            public void las_tareas_se_ordeman_asc(){
                homePage.isOrdenPrioridadAsc();
            }


        @When ("ordena las tareas por Prioridad de forma descendente")
         public void ordenar_las_tareas_por_prioridad_desc(){
            homePage.clickOrdenarPrioridad();
            
         }
        @Then ("las tareas se muestran ordenadas desde la prioridad más alta a la más baja")
            public void las_tareas_se_ordenan_desc(){
                   homePage.isOrdenPrioridadDesc();

            }

        @When ("navega a la siguiente página de la tabla")
        public void navega_a_la_siguiente_pag_tabla(){
            homePage.clickearPaginaSiguiente();
        }
        @And ("navega a la página anterior de la tabla")
        public void navega_a_la_pagina_anterior(){
            homePage.clickearPaginaAnterior();
        }
        @Then ("el orden de las tareas se mantiene")
        public void orden_de_las_tareas_se_mantiene(){
            homePage.isOrdenPrioridadDesc(); 
            homePage.isOrdenFechaDescVenc();
            homePage.isOrdenFechaDescCreacion();
            homePage.isOrdenTituloDesc();

        }

            @When("selecciona mostrar {int} tareas por página")
            public void selecciona_mostrar_tareas_por_pagina(int cantidad) {
                homePage.seleccionarTareasPorPagina(cantidad);
            }

            @Then("el sistema muestra {int} tareas en la tabla")
            public void el_sistema_muestra_tareas_en_la_tabla(int cantidad) {
                int visibles = homePage.obtenerCantidadTareasVisibles();
                Assert.assertTrue(visibles <= cantidad);
            }

            @And("el contador de registros se muestra correctamente")
            public void el_contador_se_muestra_correctamente() {
                Assert.assertTrue(homePage.obtenerTextoContador().contains("de"));
            }

            @Then ("el contador de registros se actualiza correctamente al cambiar de página")
             public void el_contador_se_muestra_correctamente_cambiar_pag() {
                Assert.assertTrue(homePage.obtenerTextoContador().contains("de"));
            }


            @When ("activa el interruptor Tabla compacta")
            public void activa_el_interruptor_tabla_compacta(){
                homePage.activarTablaCompacta();
            }
            @Then ("la tabla reduce el espacio entre filas correctamente")
            public void la_tabla_reduce_el_espacio_entre_filas(){
                
            }

            @And ("al desactivar el interruptor Tabla compacta, la tabla vuelve a su formato original")
            public void desactiva_el_interruptor_tabla_compacta(){
                 homePage.desactivarTablaCompacta();
                 Assert.assertFalse(homePage.isTablaCompactaActiva());
            }


}