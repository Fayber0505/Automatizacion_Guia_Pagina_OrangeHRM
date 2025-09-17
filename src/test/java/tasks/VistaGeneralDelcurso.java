package tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import userinterface.VistaGeneralDelCurso;

public class VistaGeneralDelcurso implements Task {

    private String guiaTecnica;

    public VistaGeneralDelcurso(String guiaTecnica) {
        this.guiaTecnica = guiaTecnica;
        
    }

    public static VistaGeneralDelcurso listaDeCursos(String guiaTecnica) {
        return instrumented(VistaGeneralDelcurso.class, guiaTecnica);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(VistaGeneralDelCurso.GUIAS_TECNICAS_ANALISTA_FINANCIAL(this.guiaTecnica)));
    }

}
