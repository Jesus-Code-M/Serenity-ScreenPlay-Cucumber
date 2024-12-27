package userinterface;

import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.serenitybdd.screenplay.targets.Target;

public class PracticeFormUserinterface {
    public static final String FORM_URL = "https://demoqa.com/automation-practice-form";

    public static OpenUrl openPracticeFormPage() {
        return Open.url(FORM_URL);
    }
    public static final Target FIRST_NAME = Target.the("First Name").locatedBy("#firstName");
    public static final Target LAST_NAME = Target.the("Last Name").locatedBy("#lastName");
    public static final Target EMAIL_USER = Target.the("Email Usuario").locatedBy("#userEmail");
    public static final Target GENERO_MASCULINO = Target.the("Male").locatedBy("//label[text()='Male']");
    public static final Target GENERO_FEMENINO = Target.the("Female").locatedBy("//label[text()='Female']");
    public static final Target GENERO_OTRO = Target.the("Other").locatedBy("//label[text()='Other']");
    public static final Target NUMERO_TELEFONO = Target.the("Mobile Number").locatedBy("#userNumber");
}
/*Vamos a agregar los mapeos de los campos First Name y Last Name usando la anotación @FindBy proporcionada por Serenity.
Target es un objeto Screenplay para ubicar elementos web.
Los selectores serán CSS o XPath según la estructura del formulario.*/
