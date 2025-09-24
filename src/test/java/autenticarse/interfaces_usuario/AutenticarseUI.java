package autenticarse.interfaces_usuario;

import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class AutenticarseUI {
        public static final Target LOCALIZADOR_NOMBRE_USUARIO = Target
                        .the("Localizador para capturar el campo nombre de usuario del login")
                        .located(By.id("username"));

        public static final Target LOCALIZADOR_CONTRASENA = Target
                        .the("Localizador para capturar el campo contrasena del login")
                        .located(By.id("password"));

        public static final Target LOCALIZADOR_BOTON_ACCEDER = Target
                        .the("Localizador para dar clic en el boton acceder")
                        .located(By.id("loginbtn"));

}