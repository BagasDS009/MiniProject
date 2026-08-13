package id.alta.qa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class ProductsPage extends PageObject {

    @FindBy(css = ".product-card")
    private List<WebElementFacade> productCards;

    @FindBy(id = "search-input")
    private WebElementFacade searchInput;

    @FindBy(id = "btn-search")
    private WebElementFacade searchButton;

    @FindBy(css = ".product-name")
    private List<WebElementFacade> productNames;

    @FindBy(css = ".product-price")
    private List<WebElementFacade> productPrices;

    @FindBy(css = ".empty-result")
    private WebElementFacade emptyResultMessage;

    public int getProductCount() {
        return productCards.size();
    }

    public void searchProduct(String keyword) {
        searchInput.clear();
        searchInput.type(keyword);
        searchButton.click();
    }

    public void clickFirstProduct() {
        if (!productCards.isEmpty()) {
            productCards.get(0).click();
        }
    }

    public boolean isProductListDisplayed() {
        return !productCards.isEmpty();
    }

    public boolean areNamesAndPricesDisplayed() {
        return !productNames.isEmpty() && !productPrices.isEmpty();
    }

    public boolean isEmptyResultDisplayed() {
        return emptyResultMessage.isDisplayed();
    }

    public List<WebElementFacade> getProductNames() {
        return productNames;
    }
}
