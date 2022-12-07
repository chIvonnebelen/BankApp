package com.bankapp.service;

import com.bankapp.entity.DebitCard;
import com.bankapp.entity.User;
import com.bankapp.exception.ExcepValidationDebitCard;
import com.bankapp.exception.ExcepValidationUser;

import java.util.ArrayList;
import java.util.Scanner;

public class DebitCardService {
    Scanner sc = new Scanner(System.in);
    public DebitCard createDebitCard(ArrayList<User> customers) {
        DebitCard debitCard = new DebitCard();

        String cardnumber = String.valueOf((long) (Math.random() *1000000000+1));
        System.out.println(cardnumber);

        System.out.println("Enter the segurity code of the debit card");
        String securityCode = sc.nextLine();
        if (securityCode.equals("")) {
            throw new ExcepValidationDebitCard("Security code can´t be empty");
        } else if (securityCode.length() != 4) {
            throw new ExcepValidationDebitCard("Security code must be 4");
        } else {
            debitCard.setSecurityCode(Integer.parseInt(securityCode));
        }

        System.out.println("Enter the expiration month of the debit card");
        String expirationDate = sc.nextLine();
        debitCard.setExpirationDate(String.valueOf(Integer.parseInt(expirationDate)));

        return debitCard;
    };
}
