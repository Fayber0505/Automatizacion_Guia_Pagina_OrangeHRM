package modulo_pim.interfaces_usuario;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class DarClicEnElBotonAgregarFotoUI {

  public static final Target LOCALIZADOR_IMAGE = Target.the("Localizador para cargar foto")
      .located(By.cssSelector("img.employee-image"));

  public static final Target INPUT_SUBIR_FOTO = Target.the("campo input oculto para subir la foto del empleado")
      .locatedBy("//input[@type='file']");

}
