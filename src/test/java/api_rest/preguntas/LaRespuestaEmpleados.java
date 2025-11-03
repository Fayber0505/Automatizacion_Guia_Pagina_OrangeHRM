package api_rest.preguntas;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class LaRespuestaEmpleados {
    public static Question<Boolean> contieneEmpleados() {
        return actor -> SerenityRest.lastResponse().jsonPath().getList("data").size() > 0;
    }

    public static Question<String> primerNombre() {
        return actor -> SerenityRest.lastResponse().jsonPath().getString("data[0].firstName");
    }
}
