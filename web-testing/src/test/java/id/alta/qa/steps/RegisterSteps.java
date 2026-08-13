package id.alta.qa.steps;

import id.alta.qa.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterSteps {

    RegisterPage registerPage;

    @Given("user is on the registration page")
    public void userIsOnTheRegistrationPage() {
        registerPage.open();
    }

    @When("user enters fullname {string}")
    public void userEntersFullname(String fullname) {
        registerPage.enterFullname(fullname);
    }

    @And("user enters email {string}")
    public void userEntersEmail(String email) {
        registerPage.enterEmail(email);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        registerPage.enterPassword(password);
    }

    @And("user enters confirm password {string}")
    public void userEntersConfirmPassword(String confirmPassword) {
        registerPage.enterConfirmPassword(confirmPassword);
    }

    @And("user clicks the register button")
    public void userClicksTheRegisterButton() {
        registerPage.clickRegisterButton();
    }

    @Then("user should see registration success message")
    public void userShouldSeeRegistrationSuccessMessage() {
        assertThat(registerPage.isSuccessMessageDisplayed()).isTrue();
    }

    @Then("user should be redirected to login page")
    public void userShouldBeRedirectedToLoginPage() {
        assertThat(registerPage.getDriver().getCurrentUrl()).contains("login");
    }

    @Then("user should see error message {string}")
    public void userShouldSeeErrorMessage(String expectedMessage) {
        assertThat(registerPage.getErrorMessage()).contains(expectedMessage);
    }
}
