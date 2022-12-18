package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.StringUtils;
import util.WaitUtils;

public class AsusSearchPage extends AbstractPage {

    private final String ASUS_SEARCH_RESULT_PAGE_URL = "https://www.asus.com/uk/searchresult?searchType=&searchKey=&page=1";

    private final String searchInputXpath = "//input[@class=\"SearchResultRightArea__searchInput__1Y2Tm\"]";
    private final String emptySearchResultAreaXpath = "//div[@class=\"SearchResultRightArea__emptyWord__LRN3T\"]";
    private final String receivedNameOfProductXpath = "//a[@class=\"headingRow ProductCardNormalStore__headingRow__33zg8\"]";
    private final String receivedPriceOfProductXpath = "//div[@class=\"ProductCardNormalStore__price__1-alX\"]";
    private final String acceptAllCookiesButtonXpath = "//div[@class=\"btn-asus btn-ok btn-read-ck\"]";

    @FindBy(xpath = acceptAllCookiesButtonXpath)
    private WebElement acceptAllCookiesButton;

    @FindBy(xpath = searchInputXpath)
    private WebElement searchInput;

    @FindBy(xpath = emptySearchResultAreaXpath)
    private WebElement emptySearchResultArea;

    @FindBy(xpath = receivedNameOfProductXpath)
    private WebElement receivedNameOfProduct;

    @FindBy(xpath = receivedPriceOfProductXpath)
    private WebElement receivedPriceOfProduct;

    public AsusSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    public AsusSearchPage setInputSearchRequest(String request) {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(searchInputXpath, webDriver);
        searchInput.sendKeys(request);
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }

    public String getEmptySearchResultArea() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(emptySearchResultAreaXpath, webDriver);
        return emptySearchResultArea.getText();
    }

    public String getProductName() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(receivedNameOfProductXpath, webDriver);
        return receivedNameOfProduct.getText();
    }

    public String getProductPrice() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(receivedPriceOfProductXpath, webDriver);
        return receivedPriceOfProduct.getText();
    }

    @Override
    public AsusSearchPage openPage() {
        webDriver.get(ASUS_SEARCH_RESULT_PAGE_URL);
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(acceptAllCookiesButtonXpath, webDriver);
        WaitUtils.waitForElementToBeClickable(acceptAllCookiesButtonXpath, webDriver);
        acceptAllCookiesButton.click();
        return this;
    }
}
