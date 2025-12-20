package steps;

import io.cucumber.java.en.*;

import org.junit.Assert;

import pages.LoginPage;
import pages.HomePage;
import pages.RegistroPage;
import pages.BasePage;

public class LoginSteps {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    RegistroPage registroPage = new RegistroPage();

 

    // =========================
    // Background
    // =========================

    @Given("el sistema web se encuentra disponible y operativo")
    public void el_sistema_web_se_encuentra_disponible_y_operativo() {
        loginPage.navigateTo("http://192.168.80.43:10500");

    }

    @And("El usuario puede desloguearse")
    public void el_usuario_puede_desloguearse() {
        loginPage.deslogearUsuario();
    }



    
    @Given("el navegador web está abierto y soportado por el sistema")
    public void el_navegador_web_esta_abierto_y_soportado_por_el_sistema() {
        // Driver inicializado en BasePage
    }

    // =========================
    // Preconditions
    // =========================

    @Given("el usuario se encuentra previamente registrado en el sistema")
    public void el_usuario_se_encuentra_previamente_registrado_en_el_sistema() {
        // Precondición lógica
    }

    @Given("el usuario se encuentra en la pantalla de inicio de sesión")
    public void el_usuario_se_encuentra_en_la_pantalla_de_inicio_de_sesion() {
        Assert.assertTrue(loginPage.isLoginVisible());
    }

    // =========================
    // Actions
    // =========================

    @When("ingresa email {string}")
    public void ingresa_email(String email) {
        loginPage.ingresarEmail(email);
    }

    @When("ingresa contraseña {string}")
    public void ingresa_contrasena(String password) {
        loginPage.ingresarPassword(password);
    }

    @When("presiona el botón Ingresar")
    public void presiona_el_boton_ingresar() {
        loginPage.clickIngresar();
    }

    @When("presiona el botón {string}")
    public void presiona_el_boton(String boton) {
        if (boton.equalsIgnoreCase("Crear nuevo usuario")) {
            loginPage.clickCrearNuevoUsuario();
        }
    }




        @Then("el sistema muestra error credenciales incorrectas")
        public void el_sistema_muestra_error_credenciales_incorrectas() {
         Assert.assertTrue(loginPage.isLoginErrorVisible());
            Assert.assertEquals(
        "Usuario o password incorrecto",
            loginPage.getLoginErrorMessage()
    );
        }


        @Then("el sistema redirige a la vista principal")
            public void el_sistema_redirige_a_la_vista_principal() {
       
        }




        @Then("se muestra el mensaje de error de email inválido")
            public void se_muestra_el_mensaje_de_error_de_email_invalido() {
   
        }

    @Then("el sistema muestra validacion nativa de email")
        public void el_sistema_muestra_validacion_nativa_de_email() {
        Assert.assertTrue(loginPage.isEmailInvalidFormat());
}

}
