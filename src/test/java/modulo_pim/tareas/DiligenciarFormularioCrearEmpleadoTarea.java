package modulo_pim.tareas;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import modulo_pim.interfaces_usuario.DiligenciarFormularioDeEmpleadoUI;
import modulo_pim.modelos.UsuarioModelo;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class DiligenciarFormularioCrearEmpleadoTarea implements Task {

  UsuarioModelo usuarioModelo;

  public DiligenciarFormularioCrearEmpleadoTarea(UsuarioModelo usuarioModelo) {
    this.usuarioModelo = usuarioModelo;
  }

  public static DiligenciarFormularioCrearEmpleadoTarea con(UsuarioModelo usuarioModelo) {
    return instrumented(DiligenciarFormularioCrearEmpleadoTarea.class, usuarioModelo);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    Serenity.setSessionVariable("NOMBRE_EMPLEADO").to(this.usuarioModelo.getPrimerNombre());
    actor.attemptsTo(
        CargarFotoTarea.empleado(),
        Enter.theValue(this.usuarioModelo.getPrimerNombre()).into(DiligenciarFormularioDeEmpleadoUI.PRIMER_NOMBRE),
        Enter.theValue(this.usuarioModelo.getSegundoNombre())
            .into(DiligenciarFormularioDeEmpleadoUI.PRIMER_SEGUNDO_NOMBRE),
        Enter.theValue(this.usuarioModelo.getApellido()).into(DiligenciarFormularioDeEmpleadoUI.APELLIDO));
  }

}
