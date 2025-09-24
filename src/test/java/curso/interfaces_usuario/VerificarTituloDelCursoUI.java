package curso.interfaces_usuario;

import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class VerificarTituloDelCursoUI {

        public static final Target TITULO_DEL_CURSO = Target
            .the("Localizador para capturar el titulo del curso")
            .located(By.className("h2"));

}
