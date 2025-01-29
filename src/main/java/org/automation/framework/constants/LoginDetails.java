package org.automation.framework.constants;

public enum LoginDetails {

    LOGIN_USER("mariusmihalache08@gmail.com", "Enesedetamina179"),
    INVALID_USER("User", "123786"),
    EMPTY_USER("empty_USER");

    private final String username;
    private String password;

    LoginDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    LoginDetails(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}