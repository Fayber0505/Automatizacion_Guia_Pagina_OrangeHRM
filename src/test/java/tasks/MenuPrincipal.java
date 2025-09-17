package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.PaginaPrincipal;

public class MenuPrincipal implements Task {

    private String menuMisCursos;

    public MenuPrincipal(String menuMisCursos) {
        this.menuMisCursos = menuMisCursos;

    }

    public static MenuPrincipal menuMisCursos(String menuMisCursos) {
        return instrumented(MenuPrincipal.class, menuMisCursos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaPrincipal.ubicarMenuCursos(this.menuMisCursos))

        );

    }

}
