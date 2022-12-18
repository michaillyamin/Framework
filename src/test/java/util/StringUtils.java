package util;

public class StringUtils {

    public static String getAllNumbersFromString(String inputString) {
        return inputString.replaceAll("[^0-9]", "");
    }
}
