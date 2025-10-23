package modulopim.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.List;

import modulopim.models.UsuarioModelo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import utilidades.LeerDatosPrueba;

public class CrearEmpleadoTask implements Task {

    private List<UsuarioModelo> usuarioModelos;

    public static CrearEmpleadoTask diligenciarFormulario() {
        return instrumented(CrearEmpleadoTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (this.usuarioModelos == null) {
            this.usuarioModelos = LeerDatosPrueba.leerArchivoExcel(0, UsuarioModelo.class);
        }

        actor.attemptsTo(
            DiligenciarFormularioCrearEmpleadoTask.con(this.usuarioModelos.get(0))
        );
        
    }

}
