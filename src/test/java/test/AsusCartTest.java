package test;

import model.Product;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AsusCartPage;
import page.AsusProductPage;
import service.ProductCreator;
import service.TestDataReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AsusCartTest extends CommonConditions {

    private final String ADDED_PRODUCT_TO_CART_MESSAGE = TestDataReader.getTestData("testdata.added_product_to_cart_message");
    private final String INVALID_COUPON_CODE = TestDataReader.getTestData("testdata.invalid_coupon_code");
    private final String INVALID_COUPON_CODE_MESSAGE = TestDataReader.getTestData("testdata.invalid_coupon_code_message");
    private final String MESSAGE_AFTER_REMOVING_PRODUCT_FROM_CART = TestDataReader.getTestData("testdata.empty_cart_message");
    private final String INCORRECT_AMOUNT_OF_PRODUCTS_TO_BUY = TestDataReader.getTestData("testdata.incorrect_amount_of_products_to_buy");
    private final String INCORRECT_AMOUNT_OF_PRODUCTS_TO_BUY_MESSAGE = TestDataReader.getTestData("testdata.incorrect_amount_of_products_to_buy_message");

    @BeforeMethod(onlyForGroups = {"addedProductToCartPreconditionIsNeeded"})
    public void addProductToCart() {
        new AsusProductPage(driver)
                .openPage()
                .addProductToCart();
    }

    @Test
    public void addProductToCartTest() {
        AsusProductPage asusProductPage = new AsusProductPage(driver)
                .openPage()
                .addProductToCart();

        String addedProductToCartMessage = asusProductPage.getAddedProductToCartMessage();

        assertThat(addedProductToCartMessage, is(equalTo(ADDED_PRODUCT_TO_CART_MESSAGE)));
    }

    @Test(groups = {"addedProductToCartPreconditionIsNeeded"})
    public void removeProductFromCartTest() {
        String messageAfterRemovingProductsFromCart = new AsusCartPage(driver)
                .openPage()
                .removeProductFromCart()
                .getTextAfterRemovingProductFromCart();

        assertThat(messageAfterRemovingProductsFromCart, is(equalTo(MESSAGE_AFTER_REMOVING_PRODUCT_FROM_CART)));
    }

    @Test(groups = {"addedProductToCartPreconditionIsNeeded"})
    public void useInvalidCouponCodeTest() {
        String couponCodeStatusMessage = new AsusCartPage(driver)
                .openPage()
                .enterCouponCode(INVALID_COUPON_CODE)
                .getCouponCodeStatusMessage();

        assertThat(couponCodeStatusMessage, is(equalTo(INVALID_COUPON_CODE_MESSAGE)));
    }

    @Test(groups = {"addedProductToCartPreconditionIsNeeded"})
    public void setIncorrectAmountOfProductsToBuyTest() {
        String incorrectAmountOfProductsMessage = new AsusCartPage(driver)
                .openPage()
                .setAmountOfCurrentProduct(INCORRECT_AMOUNT_OF_PRODUCTS_TO_BUY)
                .getIncorrectAmountOfProductsMessage();

        assertThat(incorrectAmountOfProductsMessage, is(equalTo(INCORRECT_AMOUNT_OF_PRODUCTS_TO_BUY_MESSAGE)));
    }
}
