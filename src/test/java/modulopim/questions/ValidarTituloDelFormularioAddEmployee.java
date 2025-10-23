package modulopim.questions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import modulopim.userinterfaces.VerificarTituloDelFormularioAddEmployee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ValidarTituloDelFormularioAddEmployee implements Question<String> {

    public static final int TIEMPO_ESPERA = 60;

    public static Question<String> tituloDelFormularioAddEmployee() {
        return new ValidarTituloDelFormularioAddEmployee();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(VerificarTituloDelFormularioAddEmployee.TITULO_DEL_FORMULARIO_ADDEMPLOYEE, isVisible())
                        .forNoMoreThan(TIEMPO_ESPERA).seconds());
        return VerificarTituloDelFormularioAddEmployee.TITULO_DEL_FORMULARIO_ADDEMPLOYEE.resolveFor(actor).getText();
    }

}
