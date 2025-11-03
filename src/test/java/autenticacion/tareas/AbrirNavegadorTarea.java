package autenticacion.tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import autenticacion.interfaces_usuario.AbrirPaginaOrangeHRM;

public class AbrirNavegadorTarea implements Task {

  private AbrirPaginaOrangeHRM abrirPaginaOrangeHRM;

  public static AbrirNavegadorTarea PaginaOrangeHRM() {
    return instrumented(AbrirNavegadorTarea.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Open.browserOn(this.abrirPaginaOrangeHRM));

  }

}
