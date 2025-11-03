package modulo_pim.preguntas;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import modulo_pim.interfaces_usuario.TituloDelFormularioAgregarEmpleadoIU;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class TituloDelFormularioAgregarEmpleadoPregunta implements Question<String> {

  public static final int TIEMPO_ESPERA = 60;

  public static Question<String> tituloDelFormularioAddEmployee() {
    return new TituloDelFormularioAgregarEmpleadoPregunta();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(
        WaitUntil.the(TituloDelFormularioAgregarEmpleadoIU.TITULO_DEL_FORMULARIO_ADDEMPLOYEE, isVisible())
            .forNoMoreThan(TIEMPO_ESPERA).seconds());
    return TituloDelFormularioAgregarEmpleadoIU.TITULO_DEL_FORMULARIO_ADDEMPLOYEE.resolveFor(actor).getText();
  }

}
