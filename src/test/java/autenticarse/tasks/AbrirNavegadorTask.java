package autenticarse.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import autenticarse.userinterfaces.AbrirPaginaOrangeHRM;


public class AbrirNavegadorTask implements Task{

    private AbrirPaginaOrangeHRM abrirPaginaOrangeHRM;
    public static AbrirNavegadorTask PaginaOrangeHRM() {
        return instrumented(AbrirNavegadorTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(this.abrirPaginaOrangeHRM));
   
    }

}
