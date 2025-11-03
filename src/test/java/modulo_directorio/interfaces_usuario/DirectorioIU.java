package modulo_directorio.interfaces_usuario;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class DirectorioIU {

  public static final Target LOCALIZADOR_FILTRO_NOMBRE_EMPLEADO = Target
      .the("Localizador para identificar el filtro 'Nombre Empleado'")
      .located(By.xpath("//input[@placeholder='Type for hints...']"));

  public static final Target OPCION_SUGERIDA = Target
      .the("Opción sugerida en el listbox")
      .locatedBy("//div[@role='option' and contains(.,'{0}')]");

  public static final Target LOCALIZADOR_BOTON_BUSCAR = Target.the("Localizador del botón buscar")
      .located(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));

  public static final Target LOCALIZADOR_CARD = Target.the("Localizador de la card encontrada")
      .located(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']"));

}
