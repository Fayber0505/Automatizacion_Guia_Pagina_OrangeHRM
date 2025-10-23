package modulopim.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import modulopim.userinterfaces.DarClicEnElBotonAddUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class DarClicEnElBotonAddTask implements Task {

    private static final int TIEMPO_ESPERA = 60;

    public static DarClicEnElBotonAddTask botonAdd() {
        return instrumented(DarClicEnElBotonAddTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DarClicEnElBotonAddUI.DAR_CLIC_EN_El_BOTONADD, isVisible())
                        .forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Click.on(DarClicEnElBotonAddUI.DAR_CLIC_EN_El_BOTONADD));

    }

}
