package id.alta.qa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

    @FindBy(id = "email")
    private WebElementFacade emailField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "btn-login")
    private WebElementFacade loginButton;

    @FindBy(css = ".error-message")
    private WebElementFacade errorMessage;

    @FindBy(css = ".welcome-message")
    private WebElementFacade welcomeMessage;

    public void enterEmail(String email) {
        emailField.clear();
        emailField.type(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }
}
