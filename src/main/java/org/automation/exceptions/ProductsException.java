package org.automation.exceptions;

public class ProductsException {
    static String data = null;

    public static void productsLoader() {

        //   int sizeOfData = data.length();

        try {
            int sizeOfData = data.length();
        } catch (Exception exception) {
            //tratarea exceptiei intodeauna trebuie sa fie la sfarsit
            System.out.println(exception.getMessage());

        } finally {
            System.out.println("finaly block executed");
        }
    }
}
