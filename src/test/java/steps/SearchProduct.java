package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import general.Base;
import org.openqa.selenium.WebDriver;
import pages.Home;
import pages.List;
import pages.Product;

import static org.junit.Assert.assertEquals;

public class SearchProduct extends Base {
    private Base base;
    private Home home;
    private List list;
    private Product productClass;

    public SearchProduct(WebDriver driver, Base base) {
        super(driver);

    }

    @Given("^I access Petz's homepage$")
    public void iAccessPetzSHomepage() {
        base.driver.get("https://www.petz.com.br");
    }

    @When("^I search \"([^\"]*)\"$")
    public void iSearch(String product) {
        home.searchWithEnter(product);

    }

    @Then("^I see a list of product \"([^\"]*)\"$")
    public void iSeeAListOfProduct(String product)  {
        //Validar o nome da guia
        assertEquals( product + " - Produtos pet em promoção | Petz",list.readTitleTab());


        //Validar o texto no Resultado para
        assertEquals("Resultado para \"" + product + "\"", list.readResultBy());

    }

    @And("^I click at product \"([^\"]*)\"$")
    public void iClickAtProduct(String product)  {
        list.clickAtDesiredProduct(product);

    }

    @Then("^Show the title \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void showTheTitleAndPrice(String product, String price)  {
        //Validar o nome da guia
        assertEquals(product + " - Produtos pet em promoção | Petz",productClass.readProductTitle());

        //Validar o nome do produto
        assertEquals(product,productClass.readProductTitle());

        //Valodar o preço
        assertEquals(price, productClass.readProductPrice());

    }
}
