package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.tasks.Login;
import edu.pe.cibertec.shooping.ui.CheckoutInfoPage;
import edu.pe.cibertec.shooping.ui.CheckoutCompletePage;
import edu.pe.cibertec.shooping.ui.CheckoutOverviewPage;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSteps {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new net.serenitybdd.screenplay.actors.OnlineCast());
    }

    @Given("que el usuario tiene productos en el carrito")
    public void tieneProductos() {
        OnStage.theActorCalled("Andrea").attemptsTo(
                Login.withCredentials("user1@test.com", "password1"),
                Click.on(AppiumBy.xpath("(//android.view.View[@content-desc='Agregar al carrito'])[1]"))
        );
    }

    @Given("que el usuario tiene el carrito vacio")
    public void tieneElCarritoVacio() {
        OnStage.theActorCalled("Andrea").attemptsTo(
                Login.withCredentials("user1@test.com", "password1")
        );
    }

    @When("procede al checkout")
    public void procedeAlCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(AppiumBy.xpath("//android.widget.TextView[@text='Carrito']")),
                Click.on(AppiumBy.xpath("//android.widget.TextView[@text='Proceder al Pago']"))
        );
    }

    @And("intenta proceder al checkout")
    public void intentaProcederAlCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(AppiumBy.xpath("//android.widget.TextView[@text='Carrito']"))
        );
    }

    @And("ingresa los datos de envio")
    public void ingresaDatos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutInfoPage.ADDRESS_FIELD, isVisible()).forNoMoreThan(10).seconds(),

                Enter.theValue("Jr. Los Olivos 456").into(CheckoutInfoPage.ADDRESS_FIELD),
                Enter.theValue("Lima").into(CheckoutInfoPage.CITY_FIELD),
                Enter.theValue("15037").into(CheckoutInfoPage.ZIP_CODE_FIELD),
                Click.on(CheckoutInfoPage.YAPE_OPTION)
        );
    }

    @And("ingresa los datos de envio pero deja la direccion vacia")
    public void ingresaDatosSinDireccion() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutInfoPage.ADDRESS_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue("").into(CheckoutInfoPage.ADDRESS_FIELD),
                Enter.theValue("Lima").into(CheckoutInfoPage.CITY_FIELD),
                Enter.theValue("15037").into(CheckoutInfoPage.ZIP_CODE_FIELD),
                Click.on(CheckoutInfoPage.YAPE_OPTION)
        );
    }

    @And("confirma la compra")
    public void confirma() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(CheckoutOverviewPage.CONFIRM_BUTTON)
        );
    }

    @Then("deberia ver mensaje de carrito vacio")
    public void validaCarritoVacio() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Visibility.of(Target.the("mensaje vacio")
                                .locatedBy("//android.widget.TextView[contains(@text, 'vacío')]")).asBoolean(), // Agregada la tilde
                        equalTo(true))
        );
    }

    @Then("deberia ver un mensaje de error indicando que la direccion es obligatoria")
    public void validaErrorDireccion(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutInfoPage.ERROR_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(Visibility.of(CheckoutInfoPage.ERROR_MESSAGE).asBoolean(), equalTo(true))
        );
    }

    @Then("deberia ver el mensaje de compra exitosa")
    public void validaExito(){
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutCompletePage.SUCCESS_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(Visibility.of(CheckoutCompletePage.SUCCESS_MESSAGE).asBoolean(), equalTo(true))
        );
    }
}
