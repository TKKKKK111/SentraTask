package pages;

public class LoginPage extends BasePage {

    // Locators
    private String emailInput = "//input[@id='email']";
    private String passwordInput = "//input[@id='password']";
    private String ingresarButton = "//button[@type='submit']";
    private String crearNuevoUsuarioButton = "//button[@type='button' and text()='Crear Nuevo Usuario']";
    private String logoutButton = "//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-yb0lig']";
    private String alertErrorLogin = "//div[contains(@class,'MuiAlert-message')]";

    


    public LoginPage() {
        super();
    }

        // Acciones básicas para el login///
    public void ingresarEmail(String email) {
        writeText(emailInput, email);
    }

    public void deslogearUsuario() {
        clickElement(logoutButton);
    }

    public void ingresarPassword(String password) {
        writeText(passwordInput, password);
    }

    public void clickIngresar() {
        clickElement(ingresarButton);
    }

    public void clickCrearNuevoUsuario() {
        clickElement(crearNuevoUsuarioButton);
    }

    //--------------------------------------------------------------------------------------------------------//


        ///Validaciones para los formularios de login///


        //Este método valida que el formulario de login esté visible
    public boolean isLoginVisible() {
        return isElementDisplayed(emailInput);
    }
        //Este método valida que el mensaje de error de login esté visible
   public boolean isLoginErrorVisible() {
    return isElementDisplayed(alertErrorLogin);
}
        //Este método obtiene el texto del mensaje de error de login
    public String getLoginErrorMessage() {
    return readText(alertErrorLogin);
}

        //Este método valida que el campo email tenga formato inválido, obtiene el error nativo del formulario html... para sacarse los pelos
    public boolean isEmailInvalidFormat() {
        return isFieldInvalid(emailInput);
    }


}


