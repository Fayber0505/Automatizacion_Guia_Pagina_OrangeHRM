package modulo_pim.tareas;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.List;

import modulo_pim.modelos.UsuarioModelo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import utilidades.LeerDatosPrueba;

public class CrearEmpleadoTarea implements Task {

  private List<UsuarioModelo> usuarioModelos;

  public static CrearEmpleadoTarea diligenciarFormulario() {
    return instrumented(CrearEmpleadoTarea.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    if (this.usuarioModelos == null) {
      this.usuarioModelos = LeerDatosPrueba.leerArchivoExcel(0, UsuarioModelo.class);
    }

    actor.attemptsTo(
        DiligenciarFormularioCrearEmpleadoTarea.con(this.usuarioModelos.get(0)));

  }

}
