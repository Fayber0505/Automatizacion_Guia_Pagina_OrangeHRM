package curso.preguntas;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import curso.interfaces_usuario.VerificarTituloDelCursoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ValidarTituloDelCurso implements Question<String> {

    private static final int TIEMPO_ESPERA = 60;

    public static Question<String> tituloDelCurso() {
        return new ValidarTituloDelCurso();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(VerificarTituloDelCursoUI.TITULO_DEL_CURSO, isVisible()).forNoMoreThan(TIEMPO_ESPERA)
                        .seconds());
        return VerificarTituloDelCursoUI.TITULO_DEL_CURSO.resolveFor(actor).getText();

    }
}

// .attemptsTo(
// WaitUntil.the(VerificarTituloDelCurso.TITULO_DEL_CURSO,
// isVisible()).forNoMoreThan(TIEMPO_ESPERA).seconds());
// return VerificarTituloDelCurso.TITULO_DEL_CURSO.resolveFor(actor).getText();