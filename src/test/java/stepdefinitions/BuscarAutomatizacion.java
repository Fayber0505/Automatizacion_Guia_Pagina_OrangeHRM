package stepdefinitions;

import autenticarse.model.CredencialesModelo;
import autenticarse.tareas.AutenticarseTarea;
import autenticarse.tareas.AbrirNavegadorTarea;
import curso.preguntas.ValidarTituloDelCurso;
import curso.tareas.SeleccionarOpccionCursoTarea;
import curso.tareas.IngresarAlCursoTarea;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

public class BuscarAutomatizacion {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario").wasAbleTo(AbrirNavegadorTarea.dePaginaChoucair());
    }

    @Given("que el usuario se autentica con usuario {string} y contraseña {string}")
    public void que_el_usuario_se_autentica_con_usuario_y_contraseña(String usuario, String contrasena) {
        CredencialesModelo credencialesModelo = new CredencialesModelo();
        credencialesModelo.setNombreDeUsuario(usuario);
        credencialesModelo.setContraseniaDeUsuario(contrasena);
        OnStage.theActorInTheSpotlight().wasAbleTo(AutenticarseTarea.con(credencialesModelo));

    }

    @When("el usuario en el menú da clic en la opción {string}")
    public void el_usuario_en_el_menú_da_clic_en_la_opción_mis_cursos(String menuMisCursos) {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarOpccionCursoTarea.menuMisCursos(menuMisCursos));

    }

    @And("accede al curso {string}")
    public void accede_al_curso_guias_técnicas_analista_financial(String accedeCurso) {
        OnStage.theActorInTheSpotlight().attemptsTo(IngresarAlCursoTarea.listaDeCursos());
    }

    @Then("el aplicativo muestra el curso {string}")
    public void el_aplicativo_muestra_el_curso_guias_técnicas_analista_financial(String guiaTecnica) {
        OnStage.theActorInTheSpotlight().attemptsTo(Ensure.that(ValidarTituloDelCurso.tituloDelCurso()).isEqualTo(guiaTecnica));
        
    }
    
}
