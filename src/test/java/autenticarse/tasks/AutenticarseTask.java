package autenticarse.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import autenticarse.models.CredencialesModelo;
import autenticarse.userinterfaces.AutenticarseUI;
import net.serenitybdd.screenplay.Actor;

public class AutenticarseTask implements Task {

    private CredencialesModelo autenticarseModelo;

    private static final int TIEMPO_ESPERA = 60;

    public AutenticarseTask(CredencialesModelo autenticarseModelo) {
        this.autenticarseModelo = autenticarseModelo;

    }

    public static AutenticarseTask con(CredencialesModelo autenticarseModelo) {
        return instrumented(AutenticarseTask.class, autenticarseModelo);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AutenticarseUI.LOCALIZADOR_NOMBRE_USUARIO, isVisible()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Enter.theValue(this.autenticarseModelo.getNombreDeUsuario()).into(AutenticarseUI.LOCALIZADOR_NOMBRE_USUARIO),

                WaitUntil.the(AutenticarseUI.LOCALIZADOR_CONTRASENA, isVisible()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Enter.theValue(this.autenticarseModelo.getContraseniaDeUsuario()).into(AutenticarseUI.LOCALIZADOR_CONTRASENA),

                WaitUntil.the(AutenticarseUI.LOCALIZADOR_BOTON_ACCEDER, isVisible()).forNoMoreThan(TIEMPO_ESPERA).seconds(),
                Click.on(AutenticarseUI.LOCALIZADOR_BOTON_ACCEDER));
    }

}
