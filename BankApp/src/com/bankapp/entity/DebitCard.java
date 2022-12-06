package com.bankapp.entity;

public class DebitCard {
    private String cardNumber;
    private Integer securityCode;
    private String expirationDate;
    private User user;

    public DebitCard() {}

    public DebitCard(String cardNumber, Integer securityCode, String expirationDate, User user) {
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
        this.user = user;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Integer securityCode) {
        this.securityCode = securityCode;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", securityCode=" + securityCode +
                ", expirationDate='" + expirationDate + '\'' +
                ", user=" + user +
                '}';
    }
}
