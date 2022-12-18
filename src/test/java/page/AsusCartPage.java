package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaitUtils;

public class AsusCartPage extends AbstractPage{

    private final String ASUS_CART_PAGE_URL = "https://uk.store.asus.com/checkout/cart/";
    private final String acceptAllCookiesButtonXpath = "//div[@class=\"btn-asus btn-ok btn-read-ck\"]";
    private final String productNameXpath = "//strong[@class=\"product-item-name\"]";
    private final String productPriceXpath = "//span[@class=\"price\"]";
    private final String removeProductFromCartButtonXpath = "//a[@class=\"action action-delete\"]";
    private final String incrementAmountOfProductButtonXpath = "//span[@class=\"icon plus pluscart-196300-qty\"]";
    private final String decrementAmountOfProductButtonXpath = "//span[@class=\"icon minus minuscart-196300-qty\"]";
    private final String amountOfProductInputXpath = "//input[@class=\"input-text qty\"]";
    private final String couponCodeInputXpath = "//input[@class=\"input-text\"]";
    private final String applyCouponCodeButtonXpath = "//button[@class=\"action apply primary\"]";
    private final String couponCodeStatusMessageXpath = "//div[@class=\"message-error error message\"]";
    private final String messageAfterRemovingProductsFromCartXpath = "//div[@class=\"cart-empty\"]";
    private final String incorrectAmountOfProductsXpath = "//div[@class=\"mage-error\"]";

    @FindBy(xpath = acceptAllCookiesButtonXpath)
    private WebElement acceptAllCookiesButton;

    @FindBy(xpath = productNameXpath)
    private WebElement productName;

    @FindBy(xpath = productPriceXpath)
    private WebElement productPrice;

    @FindBy(xpath = removeProductFromCartButtonXpath)
    private WebElement removeProductFromCartButton;

    @FindBy(xpath = incrementAmountOfProductButtonXpath)
    private WebElement incrementAmountOfProductButton;

    @FindBy(xpath = decrementAmountOfProductButtonXpath)
    private WebElement decrementAmountOfProductButton;

    @FindBy(xpath = amountOfProductInputXpath)
    private WebElement amountOfProductInput;

    @FindBy(xpath = couponCodeInputXpath)
    private WebElement couponCodeInput;

    @FindBy(xpath = applyCouponCodeButtonXpath)
    private WebElement applyCouponCodeButton;

    @FindBy(xpath = couponCodeStatusMessageXpath)
    private WebElement couponCodeStatusMessage;

    @FindBy(xpath = messageAfterRemovingProductsFromCartXpath)
    private WebElement messageAfterRemovingProductsFromCart;

    @FindBy(xpath = incorrectAmountOfProductsXpath)
    private WebElement incorrectAmountOfProducts;

    public AsusCartPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    public String getProductName() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(productNameXpath, webDriver);
        return productName.getText();
    }

    public String getProductPrice() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(productPriceXpath, webDriver);
        return productPrice.getText();
    }

    public AsusCartPage removeProductFromCart() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(removeProductFromCartButtonXpath, webDriver);
        WaitUtils.waitForElementToBeClickable(removeProductFromCartButtonXpath, webDriver);
        removeProductFromCartButton.click();
        return this;
    }

    public AsusCartPage incrementAmountOfProduct() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(incrementAmountOfProductButtonXpath, webDriver);
        incrementAmountOfProductButton.click();
        return this;
    }

    public AsusCartPage decrementAmountOfProduct() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(decrementAmountOfProductButtonXpath, webDriver);
        decrementAmountOfProductButton.click();
        return this;
    }

    public String getAmountOfCurrentProduct() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(amountOfProductInputXpath, webDriver);
        return amountOfProductInput.getText();
    }

    public AsusCartPage setAmountOfCurrentProduct(String amountOfProduct) {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(amountOfProductInputXpath, webDriver);
        amountOfProductInput.sendKeys(amountOfProduct);
        amountOfProductInput.sendKeys(Keys.ENTER);
        return this;
    }

    public AsusCartPage enterCouponCode(String couponCode) {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(couponCodeInputXpath, webDriver);
        couponCodeInput.sendKeys(couponCode);

        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(applyCouponCodeButtonXpath, webDriver);
        applyCouponCodeButton.click();
        return this;
    }

    public String getCouponCodeStatusMessage() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(couponCodeStatusMessageXpath, webDriver);
        return couponCodeStatusMessage.getText();
    }

    public String getTextAfterRemovingProductFromCart() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(messageAfterRemovingProductsFromCartXpath, webDriver);
        return messageAfterRemovingProductsFromCart.getText();
    }

    public String getIncorrectAmountOfProductsMessage() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(incorrectAmountOfProductsXpath, webDriver);
        return incorrectAmountOfProducts.getText();
    }

    @Override
    public AsusCartPage openPage() {
        webDriver.get(ASUS_CART_PAGE_URL);
        return this;
    }
}
