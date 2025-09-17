package tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterface.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import model.AutenticarseModelo;
import net.serenitybdd.screenplay.Actor;

public class Login implements Task {

    private AutenticarseModelo autenticarseModelo;

    public Login(AutenticarseModelo autenticarseModelo){
        this.autenticarseModelo = autenticarseModelo;

    }


    public static Login onThePage(AutenticarseModelo autenticarseModelo) {
        return instrumented(Login.class, autenticarseModelo);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.autenticarseModelo.getNombreDeUsuario()).into(LoginPage.NOMBRE_USUARIO),
                Enter.theValue(this.autenticarseModelo.getContraseniaDeUsuario()).into(LoginPage.CONTRASENA),
                Click.on(LoginPage.BOTON_ACCEDER));
    }

}
