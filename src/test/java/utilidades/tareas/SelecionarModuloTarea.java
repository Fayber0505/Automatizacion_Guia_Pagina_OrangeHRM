package utilidades.tareas;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SelecionarModuloTarea implements Task {

  private static final int TIEMPO_ESPERA = 180;
  private Target modulo;

  public SelecionarModuloTarea(Target modulo) {
    this.modulo = modulo;
  }

  public static SelecionarModuloTarea modulo(Target modulo) {
    return instrumented(SelecionarModuloTarea.class, modulo);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(modulo, isVisible())
            .forNoMoreThan(TIEMPO_ESPERA).seconds(),
        Click.on(modulo));
  }

}
