package com.bankapp.entity;

public class BankAccount {
    // private tarjeta de credito; banKA.setdebitcar(dbitServicio.createTarteja); cuando creo
    //usuario.getAccount.getDebitCar();
    private String username;
    private String password;
    private Double balance;
    private String cbu;
    private DebitCard debit;

    public BankAccount() {}

    public BankAccount(String username, String password, Double balance, String cbu, DebitCard debit) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.cbu = cbu;
        this.debit = debit;
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

    public DebitCard getDebit() {
        return debit;
    }

    public void setDebit(DebitCard debit) {
        this.debit = debit;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", cbu='" + cbu + '\'' +
                ", debit=" + debit +
                '}';
    }
}
