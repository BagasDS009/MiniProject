package id.alta.qa.steps;

import id.alta.qa.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    LoginPage loginPage;

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage.open();
    }

    @When("user enters valid email {string}")
    public void userEntersValidEmail(String email) {
        loginPage.enterEmail(email);
    }

    @When("user enters invalid email {string}")
    public void userEntersInvalidEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("user enters valid password {string}")
    public void userEntersValidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("user enters wrong password {string}")
    public void userEntersWrongPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("user leaves email field empty")
    public void userLeavesEmailFieldEmpty() {
        loginPage.enterEmail("");
    }

    @When("user leaves password field empty")
    public void userLeavesPasswordFieldEmpty() {
        loginPage.enterPassword("");
    }

    @And("user clicks the login button")
    public void userClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user should be redirected to the dashboard")
    public void userShouldBeRedirectedToTheDashboard() {
        // Verify URL contains dashboard path
        assertThat(loginPage.getDriver().getCurrentUrl()).contains("dashboard");
    }

    @Then("user should see welcome message")
    public void userShouldSeeWelcomeMessage() {
        assertThat(loginPage.isWelcomeMessageDisplayed()).isTrue();
    }

    @Then("user should see error message {string}")
    public void userShouldSeeErrorMessage(String expectedMessage) {
        assertThat(loginPage.getErrorMessage()).contains(expectedMessage);
    }
}
