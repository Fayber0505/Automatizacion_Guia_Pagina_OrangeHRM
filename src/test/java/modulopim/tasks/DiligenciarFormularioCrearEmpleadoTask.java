package modulopim.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import modulopim.models.UsuarioModelo;
import modulopim.userinterfaces.DiligenciarFormularioDeEmpleadoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class DiligenciarFormularioCrearEmpleadoTask implements Task {

    UsuarioModelo usuarioModelo;

    public DiligenciarFormularioCrearEmpleadoTask(UsuarioModelo usuarioModelo){
        this.usuarioModelo = usuarioModelo;
    }

    public static DiligenciarFormularioCrearEmpleadoTask con(UsuarioModelo usuarioModelo) {
        return instrumented(DiligenciarFormularioCrearEmpleadoTask.class,usuarioModelo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.usuarioModelo.getFirstName()).into(DiligenciarFormularioDeEmpleadoUI.PRIMER_NOMBRE),
                Enter.theValue(this.usuarioModelo.getMiddleName()).into(DiligenciarFormularioDeEmpleadoUI.PRIMER_SEGUNDO_NOMBRE),
                Enter.theValue(this.usuarioModelo.getLastName()).into(DiligenciarFormularioDeEmpleadoUI.APELLIDO));
    }

}
