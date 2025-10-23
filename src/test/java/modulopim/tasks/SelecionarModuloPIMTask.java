package modulopim.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import modulopim.userinterfaces.UbicarModuloPimUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SelecionarModuloPIMTask implements Task {

    private static final int TIEMPO_ESPERA = 60;

    public static SelecionarModuloPIMTask moduloPim() {
        return instrumented(SelecionarModuloPIMTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(UbicarModuloPimUI.UBICAR_MODULO_PIM, isVisible())
                        .forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Click.on(UbicarModuloPimUI.UBICAR_MODULO_PIM));
    }

}
