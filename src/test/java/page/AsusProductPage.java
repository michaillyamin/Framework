package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaitUtils;

public class AsusProductPage extends AbstractPage {

    private final String ASUS_PRODUCT_PAGE_URL = "https://uk.store.asus.com/proart-studiobook-16-oled-h7600-12th-gen-intel-2017-20547.html";

    private final String acceptAllCookiesButtonXpath = "//div[@class=\"btn-asus btn-ok btn-read-ck\"]";
    private final String addProductToCartButtonXpath = "//button[@class=\"action primary tocart\"]";
    private final String addedProductToCartMessageXpath = "//div[@class=\"message-success success message\"]";

    @FindBy(xpath = acceptAllCookiesButtonXpath)
    private WebElement acceptAllCookiesButton;

    @FindBy(xpath = addProductToCartButtonXpath)
    private WebElement addProductToCartButton;

    @FindBy(xpath = addedProductToCartMessageXpath)
    private WebElement addedProductToCartMessage;

    public AsusProductPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    public AsusProductPage addProductToCart() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(addProductToCartButtonXpath, webDriver);
        WaitUtils.waitForElementToBeClickable(addProductToCartButtonXpath, webDriver);
        addProductToCartButton.click();
        return this;
    }

    public String getAddedProductToCartMessage() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(addedProductToCartMessageXpath, webDriver);
        return addedProductToCartMessage.getText();
    }

    @Override
    public AsusProductPage openPage() {
        webDriver.get(ASUS_PRODUCT_PAGE_URL);
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(acceptAllCookiesButtonXpath, webDriver);
        WaitUtils.waitForElementToBeClickable(acceptAllCookiesButtonXpath, webDriver);
        acceptAllCookiesButton.click();
        return this;
    }
}
