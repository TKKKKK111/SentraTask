package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

// public class BasePage {

//     protected static WebDriver driver;
//     protected static WebDriverWait wait;



//     public BasePage() {
//         if (driver == null) {
//             WebDriverManager.chromedriver().setup();
//             driver = new ChromeDriver();
//             wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//             driver.manage().window().maximize();
//         }
//     }

//     public static void navigateTo(String url) {
//         driver.get(url);
//     }

//     public static void closeBrowser() {
//         if (driver != null) {
//             driver.quit();
//             driver = null;
//         }
//     }


//         // Método para encontrar un elemento con espera explícita 
//         // Sirve para cualquier elemento de la página
//         // Es el esqueleto de otros métodos como clickElement, writeText, readText, etc.
//     private WebElement Find(String locator){
//         return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
//     }

//     // Método para hacer clic en un elemento, usando el método Find definido arriba
//     public void clickElement(String locator){
//         Find(locator).click();
//     }

//     public void writeText(String locator, String text){
//         Find(locator).clear();
//         Find(locator).sendKeys(text);
//     }

//         // Método para leer el texto de un elemento
//     public void selectDropdownByValue(String locator, String value){
//         // Crear un objeto Select a partir del elemento encontrado
//         Select dropdown = new Select(Find(locator));
//         // Seleccionar la opción por su valor
//         dropdown.selectByValue(value);
//         // Devolver el texto de la opción seleccionada
//     }
//        // Método para leer el texto de un elemento
//     public void selectDropdownByIndex(String locator, int index){
//         // Crear un objeto Select a partir del elemento encontrado
//         Select dropdown = new Select(Find(locator));
//         // Seleccionar la opción por su índice
//         dropdown.selectByIndex(index);
//         // Devolver el texto de la opción seleccionada
//     }
    
//     public int dropdownSize(String locator){
//         Select dropdown = new Select(Find(locator));
//         List<WebElement> options = dropdown.getOptions();
//         return options.size();
//     }
// }
public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage() {
        if (driver == null) {

            ChromeOptions options = new ChromeOptions();
    
     // Configuraciones para prevenir modales de contraseñas
    options.addArguments("--disable-features=PasswordManager");
    options.addArguments("--disable-password-manager-reauthentication");
    options.addArguments("--disable-autofill-keyboard-accessory-view");
    options.addArguments("--disable-save-password-bubble");
    options.addArguments("--disable-infobars");
    options.addArguments("--disable-notifications");
    
    // Para prevenir que Chrome guarde/gestione contraseñas
    options.addArguments("--password-store=basic");
    options.addArguments("--disable-single-click-autofill");
    
    // Para evitar la detección de fugas de contraseñas
    options.addArguments("--disable-features=PasswordLeakDetection");
    
    // Opciones generales para testing
    options.addArguments("--start-maximized");
    options.addArguments("--incognito"); // Modo incógnito no guarda contraseñas
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--remote-allow-origins=*");
    
    // Deshabilitar completamente el autofill/autocomplete
    Map<String, Object> prefs = new HashMap<>();
    prefs.put("credentials_enable_service", false);
    prefs.put("profile.password_manager_enabled", false);
    prefs.put("autofill.profile_enabled", false);
    prefs.put("autofill.credit_card_enabled", false);
    prefs.put("autofill.address_enabled", false);
    prefs.put("profile.default_content_setting_values.notifications", 2);
    options.setExperimentalOption("prefs", prefs);
    
       

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
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

    public WebElement Find(String locator){
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))
        );
    }
    

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void writeText(String locator, String text){
        Find(locator).clear();
        Find(locator).sendKeys(text);
    }

    public String readText(String locator){
        return Find(locator).getText();
    }

    public boolean isElementDisplayed(String locator){
        try {
            return Find(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String obtenerbyClass(String locator){
        return Find(locator).getAttribute("class");
    }
    
    public String getHTML5ValidationMessage(String locator){
        return Find(locator).getAttribute("validationMessage");
    }

    public void selectDropdownByValue(String locator, String value){
        new Select(Find(locator)).selectByValue(value);
    }

    public void selectDropdownByIndex(String locator, int index){
        new Select(Find(locator)).selectByIndex(index);
    }

    public int dropdownSize(String locator){
        return new Select(Find(locator)).getOptions().size();
    }

   public boolean isFieldInvalid(String locator) {
    WebElement field = Find(locator);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    return !(Boolean) js.executeScript(
        "return arguments[0].checkValidity();",
        field
    );
}

    public boolean isElementPresent(String xpath) {
    return driver.findElements(By.xpath(xpath)).size() > 0;
}

    public boolean tareasExistentes(String locator) {
        List<WebElement> elementos = driver.findElements(By.xpath(locator));
        return elementos.size() > 0;
    }



    public void validarOrden(List<String> actual, boolean ascendente) {

    List<String> esperado = new ArrayList<>(actual);

    if (ascendente) {
        esperado.sort(String.CASE_INSENSITIVE_ORDER);
    } else {
        esperado.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
    }

    Assert.assertEquals(esperado, actual);
    }

    public List<WebElement> findElements(String locator) {
    return driver.findElements(By.xpath(locator));}


public String getText(String locator) {
    WebElement element = wait.until(
        ExpectedConditions.presenceOfElementLocated(By.xpath(locator))
    );
    return element.getText().trim();
}

    
}
