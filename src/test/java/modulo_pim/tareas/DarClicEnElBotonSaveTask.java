package modulo_pim.tareas;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import modulo_pim.interfaces_usuario.DarClicEnElBotonSaveUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class DarClicEnElBotonSaveTask implements Task {

  private static final int TIEMPO_ESPERA = 180;

  public static DarClicEnElBotonSaveTask botonSave() {
    return instrumented(DarClicEnElBotonSaveTask.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(DarClicEnElBotonSaveUI.DAR_CLIC_EN_El_BOTON_SAVE, isVisible())
            .forNoMoreThan(TIEMPO_ESPERA).seconds(),
        Click.on(DarClicEnElBotonSaveUI.DAR_CLIC_EN_El_BOTON_SAVE));

  }

}
