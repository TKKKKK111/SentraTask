package pages;

public class RegistroPage extends BasePage {

    // Locator del contenedor del modal
    private String modalRegistro =
            "//div[contains(@class,'modal') and contains(@class,'show')]";

    // Opción alternativa (más estable)
    // private String tituloModal =
    //     "//h5[text()='Registrar Usuario']";

    public RegistroPage() {
        super();
    }



    public boolean isModalVisible() {
        return isElementDisplayed(modalRegistro);
    }
}
