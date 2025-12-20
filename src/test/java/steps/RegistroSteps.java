package steps;

import io.cucumber.java.en.*;
import pages.BasePage;
import pages.LoginPage;
import pages.RegistroPage;

public class RegistroSteps {
    

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    RegistroPage registroPage = new RegistroPage();


    @Given("el usuario se encuentra en la pantalla de login")
    public void el_usuario_esta_en_la_pantalla_de_login() {
        basePage.navigateTo("http://192.168.80.43:10500/");
    }

    @When("presiona el botón Crear Nuevo Usuario")
    public void presiona_el_boton_crear_nuevo_usuario() {
        loginPage.clickCrearNuevoUsuario();
    }

    @Then("el sistema redirige al formulario de registro")
    public void el_sistema_redirige_al_formulario_de_registro() {
            registroPage.isModalRegistroVisible();
    }

    @When("el usuario accede al formulario de registro")
    public void el_usuario_accede_al_formulario_de_registro() {
        registroPage.isModalRegistroVisible();
    }

    @When("ingresa nombre válido")
    public void ingresa_nombre_válido() {
       registroPage.ingresarNombre("John");
    }

    @When("ingresa apellido válido")
    public void ingresa_apellido_válido() {
        registroPage.ingresarApellido("Doe");
    }

    @When("ingresa email válido")
    public void ingresa_email_válido() {
        registroPage.ingresarEmail("john.doe@example.com");
    }

    @When("ingresa contraseña válida")
    public void ingresa_contraseña_válida() {
        registroPage.ingresarPassword("Password123!");
    }

    @When("confirma la contraseña correctamente")
    public void confirma_la_contraseña_correctamente() {
        registroPage.ingresarConfirmarPassword("Password123!");
    }
    @And("presiona el botón Registrar usuario")
    public void presiona_el_boton_registrar_usuario() {
        registroPage.clickRegistrarUsuario();
        
    }
    @Then("el sistema registra al usuario correctamente")
    public void el_sistema_registra_al_usuario_correctamente() {
         registroPage.isRegistroExitosoVisible();

    }
    @And("redirige al login")
    public void redirige_al_login() {
        loginPage.isLoginVisible();
    }



    ///@R_009
     @Given("el usuario accede al modal de registro")
        public void el_usuario_accede_al_formulario_de_registro2() {
          loginPage.clickCrearNuevoUsuario();
    }
    @When("el usuario se encuentra en el formulario de registro")
    public void el_usuario_se_encuentra_en_el_formulario_de_registro() {
        registroPage.isModalRegistroVisible();
    }

    @When("confirma una contraseña distinta")
    public void confirma_una_contraseña_distinta() {
        registroPage.ingresarConfirmarPassword("Password123!");
    }


    @Then("el sistema muestra el mensaje \"Contraseñas no coinciden\"")
    public void el_sistema_muestra_el_mensaje_contraseñas_no_coinciden() {
        registroPage.isClaveErroneaVisible();
    }


    //@R_013
    @Given("el usuario clickea en el botón Crear nuevo usuario")
    public void el_usuario_clickea_en_el_boton_crear_nuevo_usuario() {
        loginPage.clickCrearNuevoUsuario();
    }
    @And("Accede al formulario de registro")
    public void el_usuario_accede_al_formulario_de_registro123() {
        registroPage.isModalRegistroVisible();
    }

    @When("presiona el botón Cancelar")
    public void presiona_el_botón_cancelar() {
        registroPage.clickCancelar();
    }

    @Then("el sistema redirige a la pantalla de login")
    public void el_sistema_redirige_a_la_pantalla_de_login() {
        loginPage.isLoginVisible();
    }
}