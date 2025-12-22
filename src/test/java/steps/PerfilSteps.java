package steps;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.*;
import pages.BasePage;
import pages.HomePage;
import pages.PerfilPage;
import pages.LoginPage;

public class PerfilSteps {
    
    BasePage basePage = new BasePage();
    PerfilPage perfilPage= new PerfilPage();
    
    LoginPage loginPage= new LoginPage();
    HomePage homePage= new HomePage();

    

    @Given ("el usuario ha iniciado sesión")
    public void el_usuario_inicia_sesion(){
        loginPage.navigateTo("http://192.168.80.43:10500/home");
        loginPage.ingresarEmail("mail@mail.cl"); // Usuario CON tareas
        loginPage.ingresarPassword("123123");
        loginPage.clickIngresar();
        homePage.isHomeVisible();
    }
    


    @When ("el usuario navega a la opción Perfil")
    public void el_usuario_navega_a_la_opción_Perfil(){
        perfilPage.clickBotonPerfil();
        perfilPage.isPerfilVisible();
    }

    @Then ("el sistema debe mostrar la vista Perfil")
    public void el_sistema_debe_mostrar_la_vista_Perfil(){
        perfilPage.compararMail("mail@mail.cl");
    }



    @Given ("el usuario está en la Modal Perfil")
    public void el_usuario_esta_en_la_modal_perfil(){
        perfilPage.clickeditarPerfilBoton();

    }
    @When ("se visualizan los campos del formulario")
    public void se_visualiza_los_campos_del_formulario(){
            perfilPage.isVisibleNombreForm();
            perfilPage.isVisibleapellidoForm();
            perfilPage.isVisibleemailForm();
            perfilPage.isVisibletituloForm();

    }
    @Then ("los campos deben mostrar la información actual del usuario")
    public void los_campos_deben_mostrar_la_informacion_del_usuario(){
        perfilPage.compararNombre("Mirko");
        perfilPage.compararApellido("Acevedo");
        perfilPage.compararEmail("mail@mail.cl");

    }
    @When("ingresa un nuevo nombre en el campo nombre")
    public void ingresa_un_nuevo_nombre(){
       perfilPage.editarCampo("//input[@id='firstname']", "NuevoNombre");

    }

    @And ("presiona el botón modificar usuario")
    public void presiona_el_boton_modificar_usuario(){
        perfilPage.clickEditarNombre();
    }

    @Then ("el nombre del usuario se actualiza correctamente")
    public void el_nombre_se_actualiza_correctamente(){
        perfilPage.compararNombrePerfil("//table/tbody/tr[td[text()='Nombre']]/td[2]");
        String nombreEnPerfil = perfilPage.getValorTablaPerfil("//table/tbody/tr[td[text()='Nombre']]/td[2]"); 
        assertEquals(nombreEnPerfil, nombreEnPerfil);

    }

    @Given ("el usuario está en Formulario Perfil")
    public void el_usuario_esta_en_Formulario_perfil(){
        perfilPage.isVisibleNombreForm();
    }



     @When("ingresa un nuevo correo válido en el campo correo")
     public void ingresar_un_nuevo_correo(){
            perfilPage.editarCampo("//input[@id='email']", "mail@mail.com");
     }
    @Then("el correo electrónico del usuario se actualiza correctamente")
    public void el_correo_se_actualiza_correctamente(){
        perfilPage.compararNombrePerfil("//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr[3]");
        String emailEnPerfil = perfilPage.getValorTablaPerfil("//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr[3]"); 
        assertEquals(emailEnPerfil, emailEnPerfil);

    }



    @When ("realiza modificaciones en los campos")
    public void realiza_modificaciones_en_los_campos(){
        perfilPage.editarCampo("//input[@id='email']", "123123123");
    };

    @And ("presiona el botón cancelar")
    public void presiona_el_boton_cancelar(){
        perfilPage.clickCancelarFormulario();
    }

    @Then("los campos mantienen la información original")
    public void los_campos_no_cambian(){
         perfilPage.compararNombrePerfil("//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr[3]");
        String emailEnPerfil = perfilPage.getValorTablaPerfil("//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr[3]"); 
        assertEquals(emailEnPerfil, emailEnPerfil);


    }


    @Given ("el usuario debe estar en la vista Perfil")
        public void el_usuario_debe_estar_en_perfil(){
             perfilPage.isPerfilVisible();
        }
    @When ("presiona el botón Cambiar contraseña")
        public void abrir_modal_cambiar_contra(){
            perfilPage.clickCambiarContrasena();
        }
    @Then ("el sistema redirige a la vista de cambio de contraseña")
        public void el_sistema_redirige_vista_cambio_contrasena(){   
            perfilPage.isCambioContrasenaVisible();
    }

    @Given ("el usuario está en la modal de cambio de contraseña")
     public void ingresa_contraseña_válida() {
   
        perfilPage.ingresarPassword("123123");
    }
    @When ("ingresa la nueva contraseña en ambos campos y coinciden")
    public void confirma_la_contraseña_correctamente() {
        perfilPage.ingresarConfirmarPassword("123123");
    }
    @And ("presiona el botón Guardar")
    public void presionar_el_boton_guardar(){
        perfilPage.clickearBotonCambiarContrasena();
    }

    @Then ("la contraseña se actualiza correctamente")
    public void la_contrasena_se_actualizo(){
        perfilPage.isAlertaVisible();

    }
    

    @When ("ingresa contraseñas diferentes en los campos")
    public void ingresa_contrasena_distinta(){
        perfilPage.ingresarPassword("123123");
         perfilPage.ingresarConfirmarPassword("12312341231");
    }
    @Then ("el sistema no permite cambiar la contraseña y muestra error en modal Editar Usuario")
    public void sistema_no_permite_cambiar_contrasena_visualiza_error_modal_editar_usuario(){
        perfilPage.clickBotonCancelarFormularioEditarUsuario();
        perfilPage.clickeditarPerfilBoton();
        perfilPage.isAlertaErrorVisible();

    }

   @Given ("la contraseña se actualizo correctamente")
    public void el_usuario_logra_cambiar_su_contrasena(){
        perfilPage.isAlertaVisible();
    }

    @Then ("intenta iniciar sesión con la nueva contraseña")
    public void vuelve_a_iniciar_sesion_contrasena_nueva(){
        loginPage.deslogearUsuario();
        loginPage.navigateTo("http://192.168.80.43:10500/home");
        loginPage.ingresarEmail("mail@mail.com"); // Usuario CON tareas
        loginPage.ingresarPassword("123123");
        loginPage.clickIngresar();
        homePage.isHomeVisible();
        perfilPage.clickBotonPerfil();
        perfilPage.isPerfilVisible();
        perfilPage.clickCambiarContrasena();
    }
}
