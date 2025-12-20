package pages;

public class HomePage extends BasePage {

   
    private String homeTitulo = "//h5[@class='MuiTypography-root MuiTypography-h5 toolbar-title css-8u639']";


    public HomePage() {
        super();
    }


    public boolean isHomeVisible() {
        return isElementDisplayed(homeTitulo);
    }

    // Opcional (para Login_012)
    public boolean isSesionActiva() {
        return isElementDisplayed(homeTitulo);
    }
}
