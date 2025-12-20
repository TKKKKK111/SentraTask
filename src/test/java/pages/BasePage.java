package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;



    public BasePage() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.manage().window().maximize();
        }
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


        // Método para encontrar un elemento con espera explícita 
        // Sirve para cualquier elemento de la página
        // Es el esqueleto de otros métodos como clickElement, writeText, readText, etc.
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    // Método para hacer clic en un elemento, usando el método Find definido arriba
    public void clickElement(String locator){
        Find(locator).click();
    }

    public void writeText(String locator, String text){
        Find(locator).clear();
        Find(locator).sendKeys(text);
    }

        // Método para leer el texto de un elemento
    public void selectDropdownByValue(String locator, String value){
        // Crear un objeto Select a partir del elemento encontrado
        Select dropdown = new Select(Find(locator));
        // Seleccionar la opción por su valor
        dropdown.selectByValue(value);
        // Devolver el texto de la opción seleccionada
    }
       // Método para leer el texto de un elemento
    public void selectDropdownByIndex(String locator, int index){
        // Crear un objeto Select a partir del elemento encontrado
        Select dropdown = new Select(Find(locator));
        // Seleccionar la opción por su índice
        dropdown.selectByIndex(index);
        // Devolver el texto de la opción seleccionada
    }
    
    public int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> options = dropdown.getOptions();
        return options.size();
    }
}
