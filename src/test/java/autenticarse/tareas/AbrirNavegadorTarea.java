package autenticarse.tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import autenticarse.interfaces_usuario.AbrirPaginaChoucair;


public class AbrirNavegadorTarea implements Task{

    private AbrirPaginaChoucair abrirPaginaChoucair;
    public static AbrirNavegadorTarea dePaginaChoucair() {
        return instrumented(AbrirNavegadorTarea.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(this.abrirPaginaChoucair));
   
    }

}
