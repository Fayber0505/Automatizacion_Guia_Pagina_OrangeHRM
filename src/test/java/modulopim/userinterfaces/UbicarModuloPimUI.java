package modulopim.userinterfaces;

import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class UbicarModuloPimUI {
    public static final Target UBICAR_MODULO_PIM = Target
            .the("Localizador para capturar el modulo PIM de la pagina OrangeHRM")
            .located(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']"));
}
