package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.AutenticarseModelo;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.Login;
import tasks.MenuPrincipal;
import tasks.OpenUp;
import tasks.VistaGeneralDelcurso;

public class BuscarAutomatizacion {

    //private String tituloCurso;
   

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario").wasAbleTo(OpenUp.thePage());
    }

    @Given("que el usuario se autentica con usuario {string} y contraseña {string}")
    public void que_el_usuario_se_autentica_con_usuario_y_contraseña(String usuario,String contrasena) {
        AutenticarseModelo autenticarseModelo = new AutenticarseModelo();
        autenticarseModelo.setNombreDeUsuario(usuario);
        autenticarseModelo.setContraseniaDeUsuario(contrasena);
        OnStage.theActorInTheSpotlight().wasAbleTo(Login.onThePage(autenticarseModelo));
        
    }

    @When("el usuario en el menú da clic en la opción {string}")
    public void el_usuario_en_el_menú_da_clic_en_la_opción_mis_cursos(String menuMisCursos) {
        OnStage.theActorInTheSpotlight().attemptsTo(MenuPrincipal.menuMisCursos(menuMisCursos));
        
    }

    @And ("accede al curso {string}")
    public void accede_al_curso_guias_técnicas_analista_financial(String accedeCurso) {
        //this.tituloCurso = accedeCurso;
      OnStage.theActorInTheSpotlight().attemptsTo(VistaGeneralDelcurso.listaDeCursos(accedeCurso));
    }

    @Then("el aplicativo muestra el curso {string}")
    public void el_aplicativo_muestra_el_curso_guias_técnicas_analista_financial(String guiaTecnica) {

       
    }

}
