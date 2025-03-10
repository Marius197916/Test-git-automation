package org.automation.constants;

public enum LoginDetails {

    LOGIN_USER("mariusmihalache08@gmail.com", "xxxxxxxxx"),
    INVALID_USER("marius@gmail.com", "123786"),
    EMPTY_USER("empty_USER", "empty_PASS"),
    ;

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