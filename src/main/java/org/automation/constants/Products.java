package org.automation.constants;


public enum Products {

    FIRST_PRODUCT("Lanseta"),
    SECOND_PRODUCT("Cort"),
    THIRD_PRODUCT("Mulineta"),
    FOURTH_PRODUCT("Scaun"),
    FIVE_PRODUCT("Fir"),
    SIX_PRODUCT("Bocanci"),;

    public final String product;

    Products(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }
}

