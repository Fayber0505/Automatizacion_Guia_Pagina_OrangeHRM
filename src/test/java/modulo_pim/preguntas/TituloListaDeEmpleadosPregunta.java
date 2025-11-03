package modulo_pim.preguntas;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import modulo_pim.interfaces_usuario.TituloListaDeEmpleadosIU;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class TituloListaDeEmpleadosPregunta implements Question <String> {

  public static final int TIEMPO_DE_ESPERA_EN_SEGUNDOS = 60;

  public static Question<String> tituloListaDeEmpleados(){
    return new TituloListaDeEmpleadosPregunta();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(
      WaitUntil.the(TituloListaDeEmpleadosIU.TIUTLO_LISTA_EMPLEADOS, isVisible())
      .forNoMoreThan(TIEMPO_DE_ESPERA_EN_SEGUNDOS).seconds());
      return TituloListaDeEmpleadosIU.TIUTLO_LISTA_EMPLEADOS.resolveFor(actor).getText();
  }

}
