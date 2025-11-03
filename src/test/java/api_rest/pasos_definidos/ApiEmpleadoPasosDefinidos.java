package api_rest.pasos_definidos;

import api_rest.preguntas.ElCodigoDeEstado;
import api_rest.preguntas.LaRespuestaEmpleados;
import api_rest.tareas.ConsultarEmpleadosTarea;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ApiEmpleadoPasosDefinidos {
  private Actor actor = Actor.named("Fayber");
  private final String BASE_URL = "http://localhost:80";
  private final String COOKIE = "c14bvju1cod682pdthurjbghpt";

  @Given("que el usuario tiene acceso a la API de OrangeHRM")
  public void queElUsuarioTieneAccesoALaAPI() {
    actor.can(CallAnApi.at(BASE_URL));
  }

  @When("consulta la lista de empleados")
  public void consultaLaListaDeEmpleados() {
    actor.attemptsTo(ConsultarEmpleadosTarea.conCookie(COOKIE));
  }

  @Then("el servicio debe responder con estado {int}")
  public void elServicioDebeResponderConEstado(Integer codigoEsperado) {
    actor.attemptsTo(
        Ensure.that(ElCodigoDeEstado.delServicio()).isEqualTo(codigoEsperado));
  }

  @And("la respuesta debe contener al menos un empleado")
  public void laRespuestaDebeContenerAlMenosUnEmpleado() {
    actor.attemptsTo(
        Ensure.that(LaRespuestaEmpleados.contieneEmpleados()).isTrue());
  }

  @And("el primer empleado debe tener nombre {string}")
  public void elPrimerEmpleadoDebeTenerNombre(String nombreEsperado) {
    actor.attemptsTo(
        Ensure.that(LaRespuestaEmpleados.primerNombre()).isEqualTo(nombreEsperado));
  }
}
