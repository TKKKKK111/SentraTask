package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Locators
    private String emailInput = "//input[@id='email']";
    private String passwordInput = "//input[@id='password']";
    private String ingresarButton = "//button[@type='submit']";
    private String crearNuevoUsuarioButton = "//button[text()='Crear nuevo usuario']";
    private String logoutButton = "//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-yb0lig']";
    private String alertErrorLogin = "//div[contains(@class,'MuiAlert-message')]";

    


    public LoginPage() {
        super();
    }

    // =========================
    // Actions
    // =========================

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

    // =========================
    // Validations
    // =========================

    public boolean isLoginVisible() {
        return isElementDisplayed(emailInput);
    }

   public boolean isLoginErrorVisible() {
    return isElementDisplayed(alertErrorLogin);
}

    public String getLoginErrorMessage() {
    return readText(alertErrorLogin);
}


    public boolean isEmailInvalidFormat() {
        return isFieldInvalid(emailInput);
    }


}


