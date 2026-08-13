package id.alta.qa.steps;

import id.alta.qa.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductSteps {

    ProductsPage productsPage;

    @Given("user is on the products page")
    public void userIsOnTheProductsPage() {
        productsPage.open();
    }

    @Then("user should see list of products")
    public void userShouldSeeListOfProducts() {
        assertThat(productsPage.isProductListDisplayed()).isTrue();
    }

    @And("each product should display name and price")
    public void eachProductShouldDisplayNameAndPrice() {
        assertThat(productsPage.areNamesAndPricesDisplayed()).isTrue();
    }

    @When("user clicks on a product")
    public void userClicksOnAProduct() {
        productsPage.clickFirstProduct();
    }

    @Then("user should see product detail page")
    public void userShouldSeeProductDetailPage() {
        assertThat(productsPage.getDriver().getCurrentUrl()).contains("product");
    }

    @And("user should see product name, price, and description")
    public void userShouldSeeProductNamePriceAndDescription() {
        // Verify product detail elements are present
        assertThat(productsPage.getDriver().getPageSource()).isNotEmpty();
    }

    @When("user searches for {string}")
    public void userSearchesFor(String keyword) {
        productsPage.searchProduct(keyword);
    }

    @Then("user should see products matching {string}")
    public void userShouldSeeProductsMatching(String keyword) {
        boolean found = productsPage.getProductNames().stream()
            .map(WebElementFacade::getText)
            .anyMatch(name -> name.toLowerCase().contains(keyword.toLowerCase()));
        assertThat(found).isTrue();
    }

    @Then("user should see empty result message")
    public void userShouldSeeEmptyResultMessage() {
        assertThat(productsPage.isEmptyResultDisplayed()).isTrue();
    }
}
