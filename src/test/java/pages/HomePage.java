package pages;

public class HomePage extends BasePage {

    // Locator de un elemento ÚNICO del Home
    private String homeContainer = "//div[@id='home-container']";
    // o por ejemplo:
    // private String tituloHome = "//h1[contains(text(),'Home')]";
    // private String btnNuevaTarea = "//button[text()='Nueva Tarea']";

    public HomePage() {
        super();
    }

    // =========================
    // Validations
    // =========================

    public boolean isHomeVisible() {
        return isElementDisplayed(homeContainer);
    }

    // Opcional (para Login_012)
    public boolean isSesionActiva() {
        return isElementDisplayed(homeContainer);
    }
}
