package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.tasks.Login;
import edu.pe.cibertec.shooping.ui.CatalogPage;
import edu.pe.cibertec.shooping.ui.TheMainScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actions.Enter;
import edu.pe.cibertec.shooping.questions.TheProductList;
import edu.pe.cibertec.shooping.tasks.FilterByCategory;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static org.hamcrest.Matchers.equalTo;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CatalogSteps {

    @Given("que el usuario esta logueado en la aplicacion")
    public void que_el_usuario_esta_logueado_en_la_aplicacion(){
        OnStage.theActorCalled("Andrea").attemptsTo(Login.withCredentials("user1@test.com", "password1"));
    }

    @When("navega al catalogo de productos")
    public void navega_al_catalogo_de_productos(){
        OnStage.theActorInTheSpotlight().should(seeThat(TheMainScreen.isVisible(), equalTo(true)));
    }

    @Then("deberia ver la lista de productos disponibles")
    public void deberia_ver_la_lista_de_productos_disponibles(){
        OnStage.theActorInTheSpotlight().should(seeThat(TheMainScreen.isVisible(), equalTo(true)));

    }

    @Given("que el usuario esta en el catalogo")
    public void que_el_usuario_esta_en_el_catalogo(){
        OnStage.theActorCalled("Andrea").attemptsTo(Login.withCredentials("user1@test.com", "password1"));
    }

    @When("busca el producto {string}")
    public void busca_el_producto(String nombreProducto){
        OnStage.theActorInTheSpotlight().attemptsTo(WaitUntil.the(CatalogPage.SEARCH_FIELD, isVisible()).forNoMoreThan(10).seconds(),Enter.theValue(nombreProducto).into(CatalogPage.SEARCH_FIELD));
    }

    @Then("deberia ver productos que contengan {string}")
    public void deberia_ver_productos_que_contengan(String nombreProducto){
        OnStage.theActorInTheSpotlight().should(seeThat(TheProductList.contains(nombreProducto), equalTo(true)));
    }

    @When("filtra por la categoria {string}")
    public void  filtra_por_la_categoria(String categoria){
        OnStage.theActorInTheSpotlight().attemptsTo(FilterByCategory.of(categoria));
    }

    @Then("deberia ver el producto {string}")
    public void deberia_ver_el_producto(String producto){
        OnStage.theActorInTheSpotlight().should(seeThat(TheProductList.contains(producto), equalTo(true)));
    }
}
