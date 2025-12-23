package pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NuevaTareaPage extends BasePage {

    public NuevaTareaPage() {
        super();
    }


    private static final String MODAL_NUEVA_TAREA ="//div[@role='dialog' and .//h2[normalize-space()='Crear nueva Tarea']]";

    private static final String INPUT_TITULO = "//input[@id='title']";
    private static final String INPUT_DESCRIPCION = "//textarea[contains(@class,'MuiInputBase-inputMultiline')]";
    private By INPUT_FECHA_VENCIMIENTO2 =By.xpath( "//input[@id='dueDate' and @type='datetime-local']");
    private static final String INPUT_PRIORIDAD = "//input[@type='number']";
    private String INPUT_FECHA_VENCIMIENTO ="//input[@id='dueDate' and @type='datetime-local']";

    private static final String BTN_CREAR_TAREA = "//button[normalize-space()='Crear Tarea']";
    private static final String BTN_CANCELAR = "//button[normalize-space()='Cancelar']";

    private static final By FILAS_TABLA =By.xpath("//tbody/a[contains(@class,'MuiTableRow-root')]");

    private static final String ALERTA_SUCCESS = "//div[@role='alert']";
    private String primerElementoTabla="//tbody[@class='MuiTableBody-root css-1xnox0e']/a[1]";
    private String nuevaTareaIsVisible="//td[normalize-space()='Fecha Modificación']";
    private String botonCancelarEditar="//button[normalize-space(text())='Cancelar']";
    private String botonEditarTarea="//button[text()='Editar Tarea']";
    private String botonConfirmarEdicion="//button[normalize-space(text())='Modificar Tarea']";
    private String alertaSuccessEdit="//div[@role='alert' and text()='Tarea modificada correctamente']";
    private String ultimoTituloIngresado;
    private String ultimaPrioridadIngresada;


    public boolean isModalVisible() {
        return isElementDisplayed(MODAL_NUEVA_TAREA);
    }
    public boolean isAlertaSuccessEditVisible() {
        return isElementDisplayed(alertaSuccessEdit);
    }
    public boolean isModalEditarTareaVisible() {
        return isElementDisplayed(nuevaTareaIsVisible);
    }

    public void clickBotonCancelarEditar(){
        clickElement(botonCancelarEditar);
    }

     public void clickBotonEditarTarea(){
        clickElement(botonEditarTarea);
    }
    public void clickBotonConfirmarEdicion(){
        clickElement(botonConfirmarEdicion);
    }
    public boolean camposVisibles() {
        return isElementDisplayed(INPUT_TITULO)
            && isElementDisplayed(INPUT_DESCRIPCION)
            && isElementDisplayed(INPUT_FECHA_VENCIMIENTO)
            && isElementDisplayed(INPUT_PRIORIDAD);
    }




public void setDateTime(By locator, String fechaIso) {
    WebElement input = driver.findElement(locator);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript(
        "arguments[0].value = arguments[1];",
        input
        ,fechaIso
    );
}

    public void completarFormulario(Map<String, String> datos) {

        if (datos.containsKey("Título")) {
            ultimoTituloIngresado = datos.get("Título");
            writeText(INPUT_TITULO, ultimoTituloIngresado);
        }

        if (datos.containsKey("Descripción")) {
            writeText(INPUT_DESCRIPCION, datos.get("Descripción"));
        }
      
            if (datos.containsKey("Fecha de Vencimiento")) {
            setDateTime(INPUT_FECHA_VENCIMIENTO2, "2025-12-20T19:29");


        }


        if (datos.containsKey("Prioridad")) {
            ultimaPrioridadIngresada = datos.get("Prioridad");
            writeText(INPUT_PRIORIDAD, ultimaPrioridadIngresada);
        }
    }

    public void clickCrear() {
        clickElement(BTN_CREAR_TAREA);
    }

    public void clickCancelar() {
        clickElement(BTN_CANCELAR);
    }

   

    public boolean seAgregoUnaNuevaTarea() {
        return isElementDisplayed(ALERTA_SUCCESS);
    }

    public boolean existeTareaEnTabla(String tituloEsperado, String prioridadEsperada) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(FILAS_TABLA));

        List<WebElement> filas = driver.findElements(FILAS_TABLA);

        for (int i = 1; i <= filas.size(); i++) {

            String tituloXpath =
                    "(//tbody/a[contains(@class,'MuiTableRow-root')])[" + i + "]/td[1]";
            String prioridadXpath =
                    "(//tbody/a[contains(@class,'MuiTableRow-root')])[" + i + "]/td[4]";

            String tituloTabla = driver.findElement(By.xpath(tituloXpath)).getText().trim();
            String prioridadTabla = driver.findElement(By.xpath(prioridadXpath)).getText().trim();

            if (tituloTabla.equals(tituloEsperado)
                    && prioridadTabla.equals(prioridadEsperada)) {
                return true;
            }
        }
        return false;
    }


    public void clickTareaTabla(){
        clickElement(primerElementoTabla);
    }




    // ================= HELPERS =================

    public boolean existeUltimaTarea() {
        return driver.findElements(FILAS_TABLA).size() > 0;
    }
        public boolean compararNombreTarea(String nombrePerfilComparar){
         String nombreEnPantalla = readText(nombrePerfilComparar).trim();
          return nombreEnPantalla.equals(nombrePerfilComparar);
        }
    }
    
    
    
