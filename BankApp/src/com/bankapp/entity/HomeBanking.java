package com.bankapp.entity;

public class HomeBanking {
    private String username;
    private String password;
    private User user;
    public HomeBanking(){}

    public HomeBanking(String username, String password, User user) {
        this.username = username;
        this.password = password;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "HomeBanking{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user=" + user +
                '}';
    }
}
