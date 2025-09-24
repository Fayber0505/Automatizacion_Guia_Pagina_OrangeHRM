package curso.interfaces_usuario;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class UbicarOpccionMisCursosUI {
    public static Target ubicarMenuCursos(String nombreDelMenu) {
        return Target
                .the("Localizador para capturar el campo mis cursos de la pagina principal")
                .located(By.xpath("//a[contains(text(), '" + nombreDelMenu + "') and @role='menuitem']"));

    }
}
