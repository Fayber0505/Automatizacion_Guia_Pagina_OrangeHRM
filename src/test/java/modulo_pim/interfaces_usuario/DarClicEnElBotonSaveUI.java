package modulo_pim.interfaces_usuario;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class DarClicEnElBotonSaveUI {
  public static final Target DAR_CLIC_EN_El_BOTON_SAVE = Target
      .the("Localizador para ubicar el boton Save")
      .located(By.xpath("//button[normalize-space()='Save']"));

}
