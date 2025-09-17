package userinterface;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class VistaGeneralDelCurso {
    public static final Target GUIAS_TECNICAS_ANALISTA_FINANCIAL(String guiaTencia) {
        return Target
                .the("Localizador para capturar el Nombre del curso")
                .located(By.cssSelector("span[title='Guías Técnicas - Analista Financial']>span[aria-hidden='true']"));
    }
}
