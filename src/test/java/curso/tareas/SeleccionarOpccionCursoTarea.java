package curso.tareas;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import curso.interfaces_usuario.UbicarOpccionMisCursosUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SeleccionarOpccionCursoTarea implements Task {

    private String menuMisCursos;
    private static final int TIEMPO_ESPERA = 60;

    public SeleccionarOpccionCursoTarea(String menuMisCursos) {
        this.menuMisCursos = menuMisCursos;

    }

    public static SeleccionarOpccionCursoTarea menuMisCursos(String menuMisCursos) {
        return instrumented(SeleccionarOpccionCursoTarea.class, menuMisCursos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(UbicarOpccionMisCursosUI.ubicarMenuCursos(menuMisCursos), isVisible()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Click.on(UbicarOpccionMisCursosUI.ubicarMenuCursos(this.menuMisCursos))

        );

    }

}
