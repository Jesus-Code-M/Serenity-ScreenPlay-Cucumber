package interactions;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.PracticeFormUserinterface;

public class PracticeFormInteractions {
    public static Task enterFirstName (String fistName){
        return Task.where("{0} enter the first name", Enter.theValue(fistName).into(PracticeFormUserinterface.FIRST_NAME));
    }

    public static Task enterLastName (String lastName){
        return  Task.where("{0} enter last name", Enter.theValue(lastName).into(PracticeFormUserinterface.LAST_NAME));
    }
    public static Task enterEmailUsuario (String emailUser){
        return  Task.where("{0} enter email del usuario", Enter.theValue(emailUser).into(PracticeFormUserinterface.EMAIL_USER));
    }

    public static Task enterNumeroTelefono (String numeroTelefono){
        return  Task.where("{0} enter email del usuario", Enter.theValue(numeroTelefono).into(PracticeFormUserinterface.NUMERO_TELEFONO));
    }

}
/*La clase PracticeFormInteractions es donde definimos las acciones/interacciones.
Utilizaremos Enter.theValue() de Serenity Screenplay para escribir en un campo.
La acción interactuará con los Target creados en la clase de interfaz.
En esta clase llamamos  la clase PracticeFormUserinterface*/
