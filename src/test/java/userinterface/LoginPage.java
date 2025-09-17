package userinterface;

import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target NOMBRE_USUARIO = Target
            .the("Localizador para capturar el campo nombre de usuario del login")
            .located(By.id("username"));

    public static final Target CONTRASENA = Target
            .the("Localizador para capturar el campo contrasena del login")
            .located(By.id("password"));

    public static final Target BOTON_ACCEDER = Target
            .the("Localizador para dar clic en el boton acceder")
            .located(By.id("loginbtn"));

}