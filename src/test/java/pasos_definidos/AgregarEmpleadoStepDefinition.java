package pasos_definidos;

import autenticacion.modelos.CredencialesModelo;
import autenticacion.tareas.AbrirNavegadorTarea;
import autenticacion.tareas.AutenticacionTarea;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modulo_directorio.preguntas.DirectorioPregunta;
import modulo_directorio.tareas.DirectorioTarea;
import modulo_pim.preguntas.TituloDelFormularioAgregarEmpleadoPregunta;
import modulo_pim.preguntas.TituloListaDeEmpleadosPregunta;
import modulo_pim.tareas.CrearEmpleadoTarea;
import modulo_pim.tareas.AgregarEmpleadoTarea;
import modulo_pim.tareas.DarClicEnElBotonSaveTask;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import utilidades.interfaces_usuario.UbicarModuloIU;
import utilidades.tareas.SelecionarModuloTarea;

public class AgregarEmpleadoStepDefinition {

  private String nombreCompleto;

  @Before
  public void setStage() {
    OnStage.setTheStage(new OnlineCast());
    OnStage.theActorCalled("usuario").wasAbleTo(AbrirNavegadorTarea.PaginaOrangeHRM());
  }

  @Given("que el administrador del aplicativo se autentica con usuario {string} y contraseña {string}")
  public void autenticarseCon(String usuario,
      String contrasena) {
    CredencialesModelo credencialesModelo = new CredencialesModelo();
    credencialesModelo.setNombreDeUsuario(usuario);
    credencialesModelo.setContraseniaDeUsuario(contrasena);
    OnStage.theActorInTheSpotlight().wasAbleTo(AutenticacionTarea.con(credencialesModelo));

  }

  @When("el administrador del aplicativo ingresa y da clic en el modulo PIM")
  public void darClicMenuPim() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            SelecionarModuloTarea.modulo(UbicarModuloIU.UBICAR_MODULO.of("/web/index.php/pim/viewPimModule")));

  }

  @And("le da clic en el boton add")
  public void darClicEnElBotonAgregar() {
    OnStage.theActorInTheSpotlight().attemptsTo(AgregarEmpleadoTarea.darClicEnAgregar());

  }

  @And("valida que el usuario ingrese al formulario {string}")
  public void validarIngresoAlFormularioCon(String tituloFormulario) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(Ensure.that(TituloDelFormularioAgregarEmpleadoPregunta.tituloDelFormularioAddEmployee())
            .isEqualTo(tituloFormulario));

  }

  @Then("el administrador adjunta la foto del empleado y diligencia el formulario Add Employee con las datos basicos del empleado")
  public void diligenciarFormularioAgregarEmpleado() {
    OnStage.theActorInTheSpotlight().attemptsTo(CrearEmpleadoTarea.diligenciarFormulario());
  }

  @And("selecciona la opccion Save")
  public void guardarEmpleado() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(DarClicEnElBotonSaveTask.botonSave(),
            Ensure.that(TituloListaDeEmpleadosPregunta.tituloListaDeEmpleados())
                .isEqualTo("No Records Found"));
  }

  @When("el administrador navega al módulo de directorio")
  public void accederAlModuloDirectorio() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            SelecionarModuloTarea.modulo(UbicarModuloIU.UBICAR_MODULO.of("/web/index.php/directory/viewDirectory")));
  }

  @And("realizan la búsqueda por el nombre del empleado")
  public void realizarFiltroPorNombreDeEmpleado() {
    this.nombreCompleto = Serenity.sessionVariableCalled("NOMBRE_EMPLEADO");
    OnStage.theActorInTheSpotlight().attemptsTo(
        DirectorioTarea.filtrarPor(nombreCompleto));

  }

  @Then("el aplicativo deberá mostrar una ficha con el hombre del empleado")
  public void validarResultadoDeLaBusqueda() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Ensure.that(DirectorioPregunta.tituloDeLaTarjeta())
                .contains(this.nombreCompleto));
  }

}
