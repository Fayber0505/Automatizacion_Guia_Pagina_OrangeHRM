package modulo_pim.interfaces_usuario;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class TituloListaDeEmpleadosIU {

  public static final Target TIUTLO_LISTA_EMPLEADOS = Target
      .the("Lozalizador para Capturar el titulo Datos Personales")
      .located(By.xpath("//span[@class='oxd-text oxd-text--span']"));

}
