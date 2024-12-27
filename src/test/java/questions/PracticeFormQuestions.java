package questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PracticeFormQuestions {
    // 1. Verificar si un elemento es visible
    public static Question<Boolean> isVisible(Target target) {
        return actor -> target.resolveFor(actor).isVisible();
    }

    // 2. Verificar si un elemento está presente en el DOM
    public static Question<Boolean> isPresent(Target target) {
        return actor -> target.resolveFor(actor).isPresent();
    }

    // 3. Verificar si un elemento está habilitado
    public static Question<Boolean> isEnabled(Target target) {
        return actor -> target.resolveFor(actor).isEnabled();
    }

    // 4. Obtener el texto visible de un elemento
    public static Question<String> visibleTextOf(Target target) {
        return actor -> target.resolveFor(actor).getText();
    }

    // 5. Obtener el valor de un campo de texto
    public static Question<String> valueOfInput(Target target) {
        return actor -> target.resolveFor(actor).getValue();
    }

    // 6. Verificar si el texto de un elemento coincide con un valor esperado
    public static Question<Boolean> textEquals(Target target, String expected) {
        return actor -> target.resolveFor(actor).getText().equals(expected);
    }

    // 7. Verificar si un elemento está seleccionado (checkbox, radio button)
    public static Question<Boolean> isSelected(Target target) {
        return actor -> target.resolveFor(actor).isSelected();
    }

    // 8. Obtener el número de elementos visibles
    public static Question<Integer> countOf(Target target) {
        return actor -> target.resolveAllFor(actor).size();
    }

    // 9. Obtener el valor de un atributo específico de un elemento
    public static Question<String> attributeOf(Target target, String attribute) {
        return actor -> target.resolveFor(actor).getAttribute(attribute);
    }

    // 10. Obtener un estilo CSS de un elemento
    public static Question<String> cssValue(Target target, String property) {
        return actor -> target.resolveFor(actor).getCssValue(property);
    }

    // 11. Validar la URL actual
    public static Question<String> currentUrl() {
        return actor -> BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
    }

    // 12. Validar el título de la página
    public static Question<String> pageTitle() {
        return actor -> BrowseTheWeb.as(actor).getDriver().getTitle();
    }

    // 13. Validar si un elemento contiene un texto específico (usando "contains")
    public static Question<Boolean> textContains(Target target, String partialText) {
        return actor -> target.resolveFor(actor).getText().contains(partialText);
    }

    // 14. Validar si un checkbox no está seleccionado
    public static Question<Boolean> isUnchecked(Target target) {
        return actor -> !target.resolveFor(actor).isSelected();
    }

    // 15. Validar el texto de una alerta (si existe)
    public static Question<String> alertText(WebDriver driver) {
        return actor -> driver.switchTo().alert().getText();
    }

    // 16. Validar si un elemento está oculto
    public static Question<Boolean> isHidden(Target target) {
        return actor -> !target.resolveFor(actor).isVisible();
    }

    // 17. Verificar si el número de elementos coincide con un valor esperado
    public static Question<Boolean> elementCountIs(Target target, int expectedCount) {
        return actor -> target.resolveAllFor(actor).size() == expectedCount;
    }

    // 18. Obtener todos los textos visibles de una lista de elementos

}
