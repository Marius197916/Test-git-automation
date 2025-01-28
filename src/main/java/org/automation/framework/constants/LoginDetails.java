package org.automation.framework.constants;

public enum LoginDetails {

    LOGIN_USER("mariusmihalache@gmail.com", "Enesedetamina179");
//nu l am putut adauga
     INVALID_USER("marius","123") {

   }

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
