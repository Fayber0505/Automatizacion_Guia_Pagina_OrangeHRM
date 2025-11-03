package modulo_pim.tareas;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

import java.nio.file.Path;
import java.nio.file.Paths;

import modulo_pim.interfaces_usuario.DarClicEnElBotonAgregarFotoUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class CargarFotoTarea implements Task {

  private final Path rutaFoto;
  private static final int TIEMPO_DE_ESPERA_EN_SEGUNDOS = 180;

  public CargarFotoTarea(Path rutaFoto) {
    this.rutaFoto = rutaFoto;
  }

  public static CargarFotoTarea empleado() {
    Path rutaAbsolutaFoto = Paths.get("src/test/resources/datosprueba/foto_empleado/empleado1.jpg")
        .toAbsolutePath();
    return instrumented(CargarFotoTarea.class, rutaAbsolutaFoto);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(DarClicEnElBotonAgregarFotoUI.LOCALIZADOR_IMAGE, isPresent())
            .forNoMoreThan(TIEMPO_DE_ESPERA_EN_SEGUNDOS).seconds(),
        Upload.theFile(rutaFoto).to(DarClicEnElBotonAgregarFotoUI.INPUT_SUBIR_FOTO));
  }

}
