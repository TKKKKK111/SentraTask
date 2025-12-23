package steps;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import pages.HomePage;
import pages.LoginPage;
import pages.NuevaTareaPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

public class NuevaTareaSteps {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    NuevaTareaPage nuevaTareaPage = new NuevaTareaPage();
    String tituloIngresado;
    String descripcionIngresada;
    String prioridadIngresada;

    int cantidadInicial;

    // ================= LOGIN =================

    @Given("el usuario inicia sesión con usuario con tareas")
    public void usuario_inicia_sesion() {
        loginPage.navigateTo("http://192.168.80.43:10500/home");
        loginPage.ingresarEmail("test@mailprueba.cl");
        loginPage.ingresarPassword("123");
        loginPage.clickIngresar();
        assert homePage.isHomeVisible();
    }

    @Then("se deben mostrar todas las tareas asociadas al usuario en la lista")
    public void validar_lista_tareas() {
        assert homePage.existenTareas();
    }

    // ================= MODAL =================

    @When("el usuario presiona el botón Crear nueva Tarea")
    public void presiona_boton() {
        cantidadInicial = homePage.obtenerCantidadTareasVisibles();
        homePage.clickNuevaTarea();
    }

    @Then("se debe abrir el modal de creación con todos los campos visibles")
    public void validar_modal_creacion() {
        assert nuevaTareaPage.isModalVisible();
        assert nuevaTareaPage.camposVisibles();
    }

    @Given("el modal de creación está abierto")
    public void modal_abierto() {
        assert nuevaTareaPage.isModalVisible();
    }

    @Given("el modal de creación debe estar abierto")
    public void modal_abierto_() {
        assert nuevaTareaPage.isModalVisible();
    }


    // ================= FORMULARIO =================

    @When("el usuario ingresa:")
    public void ingresar_datos(DataTable table) {
   


    Map<String, String> datos = table.asMap(String.class, String.class);
    
    tituloIngresado = datos.get("Título");
    descripcionIngresada = datos.get("Descripción");
    prioridadIngresada = datos.get("Prioridad");

    nuevaTareaPage.completarFormulario(datos);
}
    
    @And("presiona botón Crear Tarea")
    public void crear_tarea() {
        nuevaTareaPage.clickCrear();
    }

    // ================= VALIDACIONES =================


    @Then("el formulario debe mostrar los campos: Título, Descripción, Fecha de Vencimiento y Prioridad")
        public void validar_campos_formulario() {
            assertTrue(nuevaTareaPage.camposVisibles());
            }


 @Then("la tarea se crea correctamente")
public void validar_creacion() {

  assertTrue(
    nuevaTareaPage.existeTareaEnTabla(
        tituloIngresado,
        prioridadIngresada
    )
);
}




@And("el usuario retorna a la vista Home")
public void validar_retorno_home() {
   assert homePage.isHomeVisible();
}
            @Given ("el usuario debe abrir Modal creación")
            public void presiona_boton_Abrir() {
                    cantidadInicial = homePage.obtenerCantidadTareasVisibles();
                    homePage.clickNuevaTarea(); 
                }

                @Then ("el usuario clickea botón Cancelar Tarea")
                public void presionar_boton_cancelar(){
                    nuevaTareaPage.clickCancelar();
                }
 
                

                
}
