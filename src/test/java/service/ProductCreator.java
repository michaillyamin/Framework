package service;

import model.Product;

public class ProductCreator {

    public static final String TESTDATA_PRODUCT_NAME = "testdata.phone.name";
    public static final String TESTDATA_PRODUCT_PRICE = "testdata.phone.price";

    public static Product createProductWithCredentialsFromProperty() {
        return new Product(TestDataReader.getTestData(TESTDATA_PRODUCT_NAME),
                TestDataReader.getTestData(TESTDATA_PRODUCT_PRICE));
    }

}
