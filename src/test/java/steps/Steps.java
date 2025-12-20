package steps;

import io.cucumber.java.en.*;
import pages.PaginaPrincipal;

public class Steps {

    PaginaPrincipal pagina = new PaginaPrincipal();

    @Given("Puedo navegar {string}")
    public void puedo_navegar(String url) {
        pagina.navigateToFree();
    }

    @When("Hago clic en el enlace {word}")
    public void NavBarClick(String section) {
        pagina.clickEnlace(section);
    }
    

}
