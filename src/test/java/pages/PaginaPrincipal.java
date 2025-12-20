package pages;

public class PaginaPrincipal extends BasePage {

    private String enlaceHome = "//a[normalize-space()='%s' and @href]";

    public PaginaPrincipal() {
        super();
    }

    public void navigateToFree() {
        navigateTo("https://www.freerangetesters.com");
    }

    public void clickEnlace(String section) {

        //Remplazar el marcador de posición en EnlaceHome con el nombre de la sección
        String xpathSection = String.format(enlaceHome, section);
        clickElement(xpathSection);
    }




}
