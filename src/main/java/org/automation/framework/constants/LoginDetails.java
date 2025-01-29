package org.automation.framework.constants;

public enum LoginDetails {

    LOGIN_USER("mariusmihalache@gmail.com", "Enesedetamina"),

    INVALID_USER("marius", "123");


    private final String username;
    private String password;

    LoginDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
