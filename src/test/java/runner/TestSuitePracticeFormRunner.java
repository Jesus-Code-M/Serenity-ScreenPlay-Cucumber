package runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features", // Ruta de los archivos .feature
        glue = "stepdefinitions",                // Paquete de Step Definitions
        plugin = {"pretty", "html:target/cucumber-report.html"} // Reportes adicionales
)
public class TestSuitePracticeFormRunner {
}
