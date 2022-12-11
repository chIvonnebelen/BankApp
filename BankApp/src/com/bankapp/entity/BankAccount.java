package com.bankapp.entity;

import com.bankapp.service.MenuService;
public class BankAccount {
    // private tarjeta de credito; banKA.setdebitcar(dbitServicio.createTarteja); cuando creo
    //usuario.getAccount.getDebitCar();
    private double balance;
    private int cbu=1000;
    private User user;
    private DebitCard debit;
    private MenuService menu;
    public BankAccount() {}
    public BankAccount(User user) {
        this.user = user;
        this.balance=0.0;
        this.cbu++;
    }

    public BankAccount(User user, int cbu, double balance) {
        this.user = user;
        this.cbu ++;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCbu() {
        return cbu;
    }

    public void setCbu(int cbu) {
        this.cbu = cbu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DebitCard getDebit() {
        return debit;
    }

    public void setDebit(DebitCard debit) {
        this.debit = debit;
    }

    public MenuService getMenu() {
        return menu;
    }

    public void setMenu(MenuService menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", cbu=" + cbu +
                ", user=" + user +
                ", debit=" + debit +
                ", menu=" + menu +
                '}';
    }
    /* public BankAccount(double balance, String cbu, DebitCard debit, UnionService menu) {
        this.balance = balance;
        this.cbu = cbu;
        this.debit = debit;
        this.menu = menu;
    }*/


}
