package utilidades.interfaces_usuario;

import net.serenitybdd.screenplay.targets.Target;

public class UbicarModuloIU {
  public static final Target UBICAR_MODULO = Target
      .the("Localizador para identificar el módulo")
      .locatedBy("//a[@href='{0}']");
}
