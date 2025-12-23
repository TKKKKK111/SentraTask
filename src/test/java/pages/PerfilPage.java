package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class PerfilPage extends BasePage {
    
    private String perfilTitulo = "(//div[@class='MuiTypography-root MuiTypography-h6 MuiTypography-noWrap css-3wafqk'])[1]";
    private String botonPerfil = "//span[normalize-space()='Perfil']";
    private String mailXpath = "//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr[3]/td[2]";
    private String botonEditarPerfil="//button[normalize-space()='Editar Datos Usuario']";
    private String botonCambiarContrasena="//button[normalize-space()='Cambiar Contraseña']";
    private String nombreForm= "//input[@id='firstname']";
    private String apellidoForm="//input[@id='lastname']";
    private String emailForm="//input[@id='email']";
    private String tituloForm=	"//input[@id='title']";
    private String botonFormContinuar="(//button[normalize-space()='Modificar Usuario'])[1]";
    private String botonFormCancelar="(//button[normalize-space()='Cancelar'])[1]";
    private String cambiarContrasena="(//h2[normalize-space()='Cambiar Contraseña'])[1]";
    private String passwordInput = "//label[normalize-space()='Escribe tu contraseña']/following::input[1]";
    private String confirmarPasswordInput = "//label[normalize-space()='Repite tu contraseña']/following::input[1]";
    private String botonConfirmarPassword="(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1y36nkv'][normalize-space()='Cambiar Contraseña'])[1]";
    private String botonCancelarPassword="(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1y36nkv'][normalize-space()='Cancelar'])[1]";

    
    private String alertaSuccess="//div[@role='alert']";    
    private String alertaError="//div[contains(@class,'MuiAlert-standardError') and @role='alert']";

    
    

    public PerfilPage() {
        super();
    }

    public boolean isPerfilVisible() {
        return isElementDisplayed(perfilTitulo);
    }
    public boolean isAlertaVisible(){ return isElementDisplayed(alertaSuccess);}
     public boolean isAlertaErrorVisible(){ return isElementDisplayed(alertaError);}

    public void clickBotonPerfil(){
        clickElement(botonPerfil);
    }
     public void clickBotonCancelarFormularioEditarUsuario(){
        clickElement(botonCancelarPassword);
    }

         public boolean compararMail(String mailComparar){
         String mailEnPantalla = readText(mailXpath).trim();
          return mailEnPantalla.equals(mailComparar);
        }

    public void clickeditarPerfilBoton(){
        clickElement(botonEditarPerfil);
    }

    public boolean isVisibleNombreForm(){
        return isElementDisplayed(nombreForm);
    }
    public boolean isVisibleapellidoForm(){
        return isElementDisplayed(apellidoForm);
    }
    public boolean isVisibleemailForm(){
        return isElementDisplayed(emailForm);
    }
    public boolean isVisibletituloForm(){
        return isElementDisplayed(tituloForm);
    }

        public boolean compararNombre(String nombreAcomparar){
         String nombreEnPantalla = readText(nombreForm).trim();
          return nombreEnPantalla.equals(nombreAcomparar);
        }
        public boolean compararApellido(String apellidoAcomparar){
         String apellidoEnPantalla = readText(apellidoForm).trim();
          return apellidoEnPantalla.equals(apellidoAcomparar);
        }

         public boolean compararEmail(String EmailAcomparar){
         String EmailEnPantalla = readText(emailForm).trim();
          return EmailEnPantalla.equals(EmailAcomparar);
        }


        public void editarCampo(String xpathInput, String nuevoValor) {
        WebElement input = driver.findElement(By.xpath(xpathInput));
        input.click(); // clic para enfocar
        input.sendKeys(Keys.chord(Keys.CONTROL, "a")); // selecciona todo
        input.sendKeys(Keys.DELETE); // borra el contenido
        input.sendKeys(nuevoValor); // escribe nuevo valor
}

    


        public String getValorTablaPerfil(String xpatha) {
            
            String valor = driver.findElement(By.xpath(xpatha)).getText();
            return valor.replace(": ", "").trim();
        }



        public void editarNombre(String input){
            clickElement(nombreForm);

            writeText(nombreForm,input );
        }
        public void clickEditarNombre(){
            clickElement(botonFormContinuar);
        }
        public void clickCancelarFormulario(){
            clickElement(botonFormCancelar);
        }

         public boolean compararNombrePerfil(String nombrePerfilComparar){
         String nombreEnPantalla = readText(nombrePerfilComparar).trim();
          return nombreEnPantalla.equals(nombrePerfilComparar);
        }

        public void clickCambiarContrasena(){
            clickElement(botonCambiarContrasena);

        }

        public boolean isCambioContrasenaVisible() {
        return isElementDisplayed(cambiarContrasena);
    }



        public void ingresarPassword(String password) {
        clickElement(passwordInput);
        writeText(passwordInput, password);
    }
    public void ingresarConfirmarPassword(String confirmarPassword) {
        clickElement(confirmarPasswordInput);
        writeText(confirmarPasswordInput, confirmarPassword);
    }
    public void ingresarPasswordInvalida(String password) {
        clickElement(passwordInput);
        writeText(passwordInput, password);
    }
    public void clickearBotonCambiarContrasena(){
        clickElement(botonConfirmarPassword);
    }


}
