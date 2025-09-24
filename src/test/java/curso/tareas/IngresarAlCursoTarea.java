package curso.tareas;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import curso.interfaces_usuario.SeleccionarCursoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class IngresarAlCursoTarea implements Task {

    private static final int TIEMPO_ESPERA = 60;

    public static IngresarAlCursoTarea listaDeCursos() {
        return instrumented(IngresarAlCursoTarea.class);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SeleccionarCursoUI.GUIAS_TECNICAS_ANALISTA_FINANCIAL, isVisible())
                        .forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Click.on(SeleccionarCursoUI.GUIAS_TECNICAS_ANALISTA_FINANCIAL));

    }

}
