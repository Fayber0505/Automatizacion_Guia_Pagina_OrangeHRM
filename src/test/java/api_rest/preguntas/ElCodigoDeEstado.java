package api_rest.preguntas;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class ElCodigoDeEstado{

    public static Question<Integer> delServicio() {
        return actor -> SerenityRest.lastResponse().statusCode();
    }
}
