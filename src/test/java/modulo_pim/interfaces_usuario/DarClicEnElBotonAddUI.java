package modulo_pim.interfaces_usuario;

import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class DarClicEnElBotonAddUI {
  public static final Target DAR_CLIC_EN_El_BOTONADD = Target
      .the("Localizador para capturar el boton Add")
      .located(By.xpath("//button[contains(@class, 'oxd-button--secondary') and @type='button']"));
}
