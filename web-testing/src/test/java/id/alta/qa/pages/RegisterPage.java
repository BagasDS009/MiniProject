package id.alta.qa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegisterPage extends PageObject {

    @FindBy(id = "fullname")
    private WebElementFacade fullnameField;

    @FindBy(id = "email")
    private WebElementFacade emailField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "confirm-password")
    private WebElementFacade confirmPasswordField;

    @FindBy(id = "btn-register")
    private WebElementFacade registerButton;

    @FindBy(css = ".error-message")
    private WebElementFacade errorMessage;

    @FindBy(css = ".success-message")
    private WebElementFacade successMessage;

    public void enterFullname(String fullname) {
        fullnameField.clear();
        fullnameField.type(fullname);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.type(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.type(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.clear();
        confirmPasswordField.type(confirmPassword);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }
}
