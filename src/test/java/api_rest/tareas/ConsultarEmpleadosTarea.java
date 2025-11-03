package api_rest.tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultarEmpleadosTarea implements Task {

  private final String cookie;

  public ConsultarEmpleadosTarea(String cookie) {
    this.cookie = cookie;
  }

  public static ConsultarEmpleadosTarea conCookie(String cookie) {
    return Tasks.instrumented(ConsultarEmpleadosTarea.class, cookie);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Get.resource(
            "/orange/orangehrm-5.7/orangehrm-5.7/web/index.php/api/v2/pim/employees?limit=50&offset=0&model=detailed&includeEmployees=onlyCurrent&sortField=employee.firstName&sortOrder=ASC")
            .with(request -> request
                .header("Cookie", "_orangehrm=" + cookie)
                .relaxedHTTPSValidation()
                .log().all()));
  }

}
