package modulopim.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class DiligenciarFormularioDeEmpleadoUI {

    public static final Target PRIMER_NOMBRE = Target
            .the("Localizador para capturar el primer nombre del empleado")
            .located(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-firstname']"));

    public static final Target PRIMER_SEGUNDO_NOMBRE = Target
            .the("Localizador para capturar el segundo nombre del empleado")
            .located(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-middlename']"));
            
    public static final Target APELLIDO = Target
            .the("Localizador para capturar el apellido del empleado")
            .located(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-lastname' and @name='lastName']"));
}



