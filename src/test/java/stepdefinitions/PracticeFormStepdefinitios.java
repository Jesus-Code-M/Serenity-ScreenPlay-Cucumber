package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import org.openqa.selenium.WebDriver;
import tasks.PracticeFormTasks;

public class PracticeFormStepdefinitios {

    @Managed(uniqueSession = true)
    WebDriver hisBrowser;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new Cast());
            OnStage.theActorCalled("User").whoCan(BrowseTheWeb.with(hisBrowser));//Crea un actor llamado "User" y le asigna la habilidad BrowseTheWeb con el WebDriver proporcionado.
        hisBrowser.manage().window().maximize();
    }


    // ============================
    // **1. Ingreso a la página**
    // ============================
    @Given("el usuario ingresa a la url de PracticeForm")
    public void elUsuarioIngresaALaUrlDePracticeForm() {
        OnStage.theActorCalled("User")
                .whoCan(BrowseTheWeb.with(hisBrowser)); // Asignar la habilidad
        OnStage.theActorInTheSpotlight().attemptsTo(
                PracticeFormTasks.openPracticeFormPage()
        );
    }

    // ============================
    // **2. Llenar Nombre y Apellido**
    // ============================
    @When("el usuario llena el nombre con {string} y el apellido con {string}")
    public void elUsuarioLlenaElNombreConYElApellidoCon(String firstName, String lastName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PracticeFormTasks.fillFirstAndLastName(firstName, lastName)
        );
    }

    // ============================
    // **3. Ingresar Email**
    // ============================
    @When("el usuario ingresa el email {string}")
    public void elUsuarioIngresaElEmail(String emailUser) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PracticeFormTasks.emailUsuario(emailUser)
        );
    }

    // ============================
    // **4. Seleccionar Género**
    // ============================
    @Given("el usuario marca radio button Male")
    public void elUsuarioMarcaRadioButtonMale() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PracticeFormTasks.openPracticeFormPage(), // Abre la página
                PracticeFormTasks.generoMasculino()       // Selecciona el radio button
        );
        espera();
    }


    @When("el usuario marca radio button Female")
    public void elUsuarioMarcaRadioButtonFemale() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PracticeFormTasks.generoFemenino()
        );espera();
    }

    @Then("el usuario marca radio button Other")
    public void elUsuarioMarcaRadioButtonOther() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PracticeFormTasks.generoOtro()
        );espera();
    }
    @And("el usuario ingresa el numero de telefono {string}")
    public void elUsuarioIngresaElNumeroDeTelefono(String numTelefono) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PracticeFormTasks.numTelefono(numTelefono)
        );espera();
    }

    // ============================
    // **5. Ajustar Zoom**
    // ============================
    @When("el usuario ajusta el zoom de la página al {string}")
    public void elUsuarioAjustaElZoomDeLaPaginaAl(String zoomLevel) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PracticeFormTasks.zoomPagina(zoomLevel)
        );
    }

    // ============================
    // **6. Tomar Screenshots**
    // ============================
    @And("el usuario toma un screenshot llamado {string}")
    public void elUsuarioTomaUnScreenshotLlamado(String screenshotName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                PracticeFormTasks.takeScreenshotWithName(screenshotName)
        );
    }
    // Método para agregar una espera explícita
    private void espera() {
        try {
            Thread.sleep(1000); // 1 segundo de espera
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/*La clase PracticeFormStepdefinitios contendrá los pasos de Cucumber.
Utilizaremos el patrón Given o When para definir el llenado de nombres.
En esta clase llamamos la clase PracticeFormTasks/
 */
