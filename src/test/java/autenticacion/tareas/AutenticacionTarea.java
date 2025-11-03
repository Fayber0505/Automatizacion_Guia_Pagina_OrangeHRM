package autenticacion.tareas;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import autenticacion.interfaces_usuario.AutenticacionIU;
import autenticacion.modelos.CredencialesModelo;
import net.serenitybdd.screenplay.Actor;

public class AutenticacionTarea implements Task {

  private CredencialesModelo credencialesModelo;

  private static final int TIEMPO_ESPERA = 180;

  public AutenticacionTarea(CredencialesModelo credencialesModelo) {
    this.credencialesModelo = credencialesModelo;

  }

  public static AutenticacionTarea con(CredencialesModelo credencialesModelo) {
    return instrumented(AutenticacionTarea.class, credencialesModelo);

  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(AutenticacionIU.LOCALIZADOR_NOMBRE_USUARIO, isVisible()).forNoMoreThan(TIEMPO_ESPERA)
            .seconds(),
        Enter.theValue(this.credencialesModelo.getNombreDeUsuario())
            .into(AutenticacionIU.LOCALIZADOR_NOMBRE_USUARIO),

        WaitUntil.the(AutenticacionIU.LOCALIZADOR_CONTRASENA, isVisible()).forNoMoreThan(TIEMPO_ESPERA)
            .seconds(),
        Enter.theValue(this.credencialesModelo.getContraseniaDeUsuario())
            .into(AutenticacionIU.LOCALIZADOR_CONTRASENA),

        WaitUntil.the(AutenticacionIU.LOCALIZADOR_BOTON_ACCEDER, isVisible()).forNoMoreThan(TIEMPO_ESPERA)
            .seconds(),
        Click.on(AutenticacionIU.LOCALIZADOR_BOTON_ACCEDER));
  }

}
