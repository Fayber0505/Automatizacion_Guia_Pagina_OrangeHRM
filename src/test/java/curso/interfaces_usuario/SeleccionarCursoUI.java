package curso.interfaces_usuario;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class SeleccionarCursoUI {

    public static final Target GUIAS_TECNICAS_ANALISTA_FINANCIAL = Target
            .the("Localizador para capturar el Nombre del curso")
            .located(By.className("aalink"));

}
