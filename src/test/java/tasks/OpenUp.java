package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import userinterface.AcademyPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class OpenUp implements Task{

    private AcademyPage academyPage;
    public static OpenUp thePage() {
        return instrumented(OpenUp.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(this.academyPage));
   
    }

}
