package pages;

public class RegistroPage extends BasePage {

    // Locator del contenedor del modal
    private String modalRegistro ="(//div[contains(@class,'MuiDialogContent-root')]";
    private String nombreInput = "//input[@id='firstname']";
    private String apellidoInput = "//input[@id='lastname']";
    private String emailInput = "//label[text()='E-Mail']/following::input[1]";
    private String passwordInput = "//label[normalize-space()='Escribe tu contraseña']/following::input[1]";
    private String confirmarPasswordInput = "//label[normalize-space()='Repite tu contraseña']/following::input[1]";
    private String registrarUsuarioButton = "//button[.//text()[normalize-space()='Registrar Usuario']]";
    private String alertRegistroExitoso = "//div[@role='alert']//div[text()='Usuario creado correctamente']";
    private String alertClaveErronea = "/html/body/div[2]/div[3]/div/div[1]/div[1]/div/div/div";
    private String clickCancelar = "//button[normalize-space()='Cancelar']";
    private String cerrarAlerta= "//button[@aria-label='Close']";
    


    public RegistroPage() {
        super();
    }


        ///Validaciones y acciones para el formulario de registro//

    public boolean isModalRegistroVisible() {
        return isElementDisplayed(modalRegistro);
    }

    public void ingresarNombre(String nombre) {
        clickElement(nombreInput);
        writeText(nombreInput, nombre);
    }

    public void ingresarApellido(String apellido) {
        clickElement(apellidoInput);
        writeText(apellidoInput, apellido);
    }
    public void ingresarEmail(String email) {
        clickElement(emailInput);
        writeText(emailInput, email);
    }
    public void ingresarPassword(String password) {
        clickElement(passwordInput);
        writeText(passwordInput, password);
    }
    public void ingresarPasswordInvalida(String password) {
        clickElement(passwordInput);
        writeText(passwordInput, password);
    }
    public void ingresarConfirmarPassword(String confirmarPassword) {
        clickElement(confirmarPasswordInput);
        writeText(confirmarPasswordInput, confirmarPassword);
    }
    public void clickRegistrarUsuario() {
        clickElement(registrarUsuarioButton);
    }
    public boolean isRegistroExitosoVisible() {
        return isElementDisplayed(alertRegistroExitoso);
    }
    public boolean isClaveErroneaVisible() {
        return isElementDisplayed(alertClaveErronea);
    }
    public void clickCancelar() {
        clickElement(clickCancelar);
    }
    public void clickCerrarAlerta(){
        clickElement(cerrarAlerta);
    }
}
