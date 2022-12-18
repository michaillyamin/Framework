package test;

import model.Product;
import org.testng.annotations.Test;
import page.AsusSearchPage;
import service.ProductCreator;
import service.TestDataReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AsusSearchTest extends CommonConditions {

    private final String INCORRECT_SEARCH_REQUEST = TestDataReader.getTestData("testdata.incorrect_search_request");
    private final String INCORRECT_SEARCH_REQUEST_MESSAGE = TestDataReader.getTestData("testdata.incorrect_search_request_message");
    private final String CORRECT_SEARCH_REQUEST = TestDataReader.getTestData("testdata.correct_search_request");

    @Test
    public void searchForProductTest() {
        Product testProduct = ProductCreator.createProductWithCredentialsFromProperty();

        AsusSearchPage asusSearchPage = new AsusSearchPage(driver)
                .openPage()
                .setInputSearchRequest(CORRECT_SEARCH_REQUEST);

        String foundedProductName = asusSearchPage
                .getProductName();

        String foundedProductPrice = asusSearchPage
                .getProductPrice();

        assertThat(foundedProductName, is(equalTo(testProduct.getName())));
        assertThat(foundedProductPrice, is(equalTo(testProduct.getPrice())));
    }

    @Test
    public void useIncorrectRequestForSearchTest() {
        String incorrectSearchMessage = new AsusSearchPage(driver)
                .openPage()
                .setInputSearchRequest(INCORRECT_SEARCH_REQUEST)
                .getEmptySearchResultArea();

        assertThat(incorrectSearchMessage, is(equalTo(INCORRECT_SEARCH_REQUEST_MESSAGE)));
    }

}
