package com.bankapp.entity;

public class BankAccount {
    private Double balance;
    private String cbu;
    private User user;

    public BankAccount() {}

    public BankAccount(Double balance, String cbu, User user) {
        this.balance = balance;
        this.cbu = cbu;
        this.user = user;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", cbu='" + cbu + '\'' +
                ", user=" + user +
                '}';
    }
}
