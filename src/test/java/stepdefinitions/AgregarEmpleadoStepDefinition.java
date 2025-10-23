package stepdefinitions;

import autenticarse.models.CredencialesModelo;
import autenticarse.tasks.AbrirNavegadorTask;
import autenticarse.tasks.AutenticarseTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modulopim.questions.ValidarTituloDelFormularioAddEmployee;
import modulopim.tasks.CrearEmpleadoTask;
import modulopim.tasks.DarClicEnElBotonAddTask;
import modulopim.tasks.DarClicEnElBotonSaveTask;
import modulopim.tasks.SelecionarModuloPIMTask;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

public class AgregarEmpleadoStepDefinition {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario").wasAbleTo(AbrirNavegadorTask.PaginaOrangeHRM());
    }

    @Given("que el administrador del aplicativo se autentica con usuario {string} y contraseña {string}")
    public void que_el_administrador_del_aplicativo_se_autentica_con_usuario_y_contraseña(String usuario,
            String contrasena) {
        CredencialesModelo credencialesModelo = new CredencialesModelo();
        credencialesModelo.setNombreDeUsuario(usuario);
        credencialesModelo.setContraseniaDeUsuario(contrasena);
        OnStage.theActorInTheSpotlight().wasAbleTo(AutenticarseTask.con(credencialesModelo));

    }

    @When("el administrador del aplicativo ingresa y da clic en el modulo PIM")
    public void el_administrador_del_aplicativo_ingresa_y_da_clic_en_el_modulo() {
        OnStage.theActorInTheSpotlight().attemptsTo(SelecionarModuloPIMTask.moduloPim());

    }

    @And("le da clic en el boton add")
    public void le_da_clic_en_el_boton() {
        OnStage.theActorInTheSpotlight().attemptsTo(DarClicEnElBotonAddTask.botonAdd());

    }

    @And("valida que el usuario ingrese al formulario {string}")
    public void valida_que_el_usuario_ingrese_al_formulario(String tituloFormulario) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(Ensure.that(ValidarTituloDelFormularioAddEmployee.tituloDelFormularioAddEmployee())
                        .isEqualTo(tituloFormulario));

    }

    @Then("el administrador diligencia el formulario Add Employee con las datos basicos del empleado")
    public void el_administrador_diligencia_el_formulario_con_las_datos_basicos_del_empleado() {
        OnStage.theActorInTheSpotlight().attemptsTo(CrearEmpleadoTask.diligenciarFormulario());
    }

    @And("selecciona la opccion Save")
    public void selecciona_la_opccion() {
        OnStage.theActorInTheSpotlight().attemptsTo(DarClicEnElBotonSaveTask.botonSave());
    }

}
