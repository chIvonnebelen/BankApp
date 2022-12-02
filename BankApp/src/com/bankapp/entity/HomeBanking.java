package com.bankapp.entity;

public class HomeBanking {

    private String username;
    private String password;

    public HomeBanking(){}

    public HomeBanking(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "HomeBanking{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
