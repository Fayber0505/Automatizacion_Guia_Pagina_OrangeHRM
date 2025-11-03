package modulo_directorio.tareas;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import modulo_directorio.interfaces_usuario.DirectorioIU;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class DirectorioTarea implements Task {

  private static final int TIEMPO_ESPERA = 60;

  private String nombreEmpleado;

  public DirectorioTarea(String nombreEmpleado) {
    this.nombreEmpleado = nombreEmpleado;
  }

  public static DirectorioTarea filtrarPor(String nombreEmpleado) {
    return instrumented(DirectorioTarea.class, nombreEmpleado);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(DirectorioIU.LOCALIZADOR_FILTRO_NOMBRE_EMPLEADO, isVisible()).forNoMoreThan(TIEMPO_ESPERA)
            .seconds(),
        Click.on(DirectorioIU.LOCALIZADOR_FILTRO_NOMBRE_EMPLEADO),
        Enter.theValue(this.nombreEmpleado)
            .into(DirectorioIU.LOCALIZADOR_FILTRO_NOMBRE_EMPLEADO),
        WaitUntil.the(DirectorioIU.OPCION_SUGERIDA.of(nombreEmpleado), isVisible())
            .forNoMoreThan(TIEMPO_ESPERA).seconds(),
        Click.on(DirectorioIU.OPCION_SUGERIDA.of(nombreEmpleado)),
        Click.on(DirectorioIU.LOCALIZADOR_BOTON_BUSCAR));
  }

}
