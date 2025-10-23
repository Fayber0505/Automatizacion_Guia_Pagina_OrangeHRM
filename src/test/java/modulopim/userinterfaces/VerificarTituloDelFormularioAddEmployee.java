package modulopim.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class VerificarTituloDelFormularioAddEmployee {

    public static final Target TITULO_DEL_FORMULARIO_ADDEMPLOYEE = Target
    .the("Localizador para capturar el titulo del formulario para crear un nuevo empleado")
    .located(By.xpath("//h6[contains(@class,'orangehrm-main-title')]"));

}
