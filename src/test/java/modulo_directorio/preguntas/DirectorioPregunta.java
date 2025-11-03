package modulo_directorio.preguntas;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import modulo_directorio.interfaces_usuario.DirectorioIU;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class DirectorioPregunta implements Question<String> {

  public static final int TIEMPO_DE_ESPERA_EN_SEGUNDOS = 60;

  public static DirectorioPregunta tituloDeLaTarjeta() {
    return new DirectorioPregunta();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(
        WaitUntil.the(DirectorioIU.LOCALIZADOR_CARD, isVisible())
            .forNoMoreThan(TIEMPO_DE_ESPERA_EN_SEGUNDOS).seconds());

    return DirectorioIU.LOCALIZADOR_CARD.resolveFor(actor).getText();
  }

}
