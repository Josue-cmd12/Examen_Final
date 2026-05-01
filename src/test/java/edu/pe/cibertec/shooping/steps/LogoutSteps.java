package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.ui.LoginScreen;
import edu.pe.cibertec.shooping.ui.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class LogoutSteps {

    @When("hace clic en el menu de usuario")
    public void clicMenuUsuario() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ProfilePage.PROFILE_TAB),
                WaitUntil.the(ProfilePage.USERNAME_LABEL, isVisible()).forNoMoreThan(10).seconds()
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat("El usuario logueado es Juan Pérez",
                        Visibility.of(ProfilePage.USERNAME_LABEL).asBoolean(), equalTo(true))
        );
    }

    @And("hace clic en cerrar sesion")
    public void clicCerrarSesion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ProfilePage.LOGOUT_ICON),
                WaitUntil.the(ProfilePage.CONFIRM_LOGOUT_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ProfilePage.CONFIRM_LOGOUT_BUTTON)
        );
    }

    @Then("deberia regresar a la pantalla de login")
    public void validarPantallaLogin() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("Regresó exitosamente a la pantalla de login",
                        Visibility.of(LoginScreen.EMAIL_FIELD).asBoolean(), equalTo(true))
        );
    }


}
