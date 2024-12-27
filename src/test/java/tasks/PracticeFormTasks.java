package tasks;

import interactions.PracticeFormInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import userinterface.PracticeFormUserinterface;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PracticeFormTasks {
    public static Task openPracticeFormPage() {
        return new Task() {
            @Override
            public <T extends Actor> void performAs(T actor) {
                // Obtener el WebDriver actual desde Serenity
                actor.attemptsTo(Open.url(PracticeFormUserinterface.FORM_URL));
                WebDriver driver = BrowseTheWeb.as(actor).getDriver();
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                        webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            }
        };
    }

    public static Task fillFirstAndLastName(String firstName, String lastName) {
        return Task.where("{0} fill fist name and last name", PracticeFormInteractions.enterFirstName(firstName), PracticeFormInteractions.enterLastName(lastName));
    }
    public static Task emailUsuario(String emailUser){
        return Task.where("el usuario ingresa el email {0 }", PracticeFormInteractions.enterEmailUsuario(emailUser));
    }
    public static Task generoMasculino() {
        return new Task() {
            @Override
            public <T extends Actor> void performAs(T actor) {
                waitForAndClick(actor, PracticeFormUserinterface.GENERO_MASCULINO);
            }
        };
    }

    public static Task generoFemenino() {
        return new Task() {
            @Override
            public <T extends Actor> void performAs(T actor) {
                waitForAndClick(actor, PracticeFormUserinterface.GENERO_FEMENINO);
            }
        };
    }

    public static Task generoOtro() {
        return new Task() {
            @Override
            public <T extends Actor> void performAs(T actor) {
                waitForAndClick(actor, PracticeFormUserinterface.GENERO_OTRO);
            }
        };
    }
    public static Task numTelefono(String numTelefono){
        return Task.where("el usuario ingresa el numero de telefono {0 }", PracticeFormInteractions.enterNumeroTelefono(numTelefono));
    }
    public static Task takeScreenshotWithName(String screenshotName) {
        return new Task() {
            @Override
            public <T extends Actor> void performAs(T actor) {
                // Obtener la fecha actual formateada
                String currentDate = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
                String screenshotPath = System.getProperty("user.dir") + "/screens-output/screenshots/";
                String filePath = screenshotPath + screenshotName + "_" + currentDate + ".png";
                try {
                    File screenshot = ((TakesScreenshot) SerenityWebdriverManager.inThisTestThread().getCurrentDriver()) // Capturar la pantalla usando WebDriver
                            .getScreenshotAs(OutputType.FILE);
                    Files.createDirectories(Paths.get(screenshotPath)); // Crear el directorio si no existe
                    Files.move(screenshot.toPath(), Paths.get(filePath));// Guardar el archivo en la ruta especificada
                    System.out.println("Screenshot guardado en: " + filePath);
                } catch (IOException e) {
                    throw new RuntimeException("No se pudo guardar el screenshot: " + e.getMessage());
                }
            }
        };
    }
    public static Task zoomPagina(String zoomLevel) {
        return new Task() {
            @Override
            public <T extends Actor> void performAs(T actor) {
                // Obtener el WebDriver actual
                WebDriver driver = SerenityWebdriverManager.inThisTestThread().getCurrentDriver();

                // Verificar y castear el driver a JavascriptExecutor
                if (driver instanceof JavascriptExecutor) {
                    JavascriptExecutor js = (JavascriptExecutor) driver;

                    // Ejecutar el script para ajustar el zoom
                    js.executeScript("document.body.style.zoom = '" + zoomLevel + "';");
                } else {
                    throw new IllegalStateException("El driver no soporta JavascriptExecutor");
                }
            }
        };
    }
    /**
     * Método reutilizable para esperar un elemento y hacer clic
     * JavaScript permite "forzar" el clic sin importar si hay otros elementos visualmente bloqueando el objetivo.
     * Ignora las limitaciones de la interfaz gráfica de Selenium.
     */
    private static void waitForAndClick(Actor actor, Target target) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        // Espera explícita hasta que el elemento esté visible
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(target.resolveFor(actor).getElement()));
        // Clic mediante JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", target.resolveFor(actor).getElement());
    }
}
/*La clase PracticeFormTasks se encargará de organizar las tareas que incluyen múltiples acciones.
Combinaremos las tareas enterFirstName y enterLastName en una sola.
En esta clase llamamos las clase PracticeFormInteractions*/