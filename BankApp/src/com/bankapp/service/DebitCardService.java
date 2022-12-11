package com.bankapp.service;

import com.bankapp.entity.DebitCard;
import com.bankapp.entity.User;
import com.bankapp.exception.ExcepValidationDebitCard;
import com.bankapp.exception.ExcepValidationUser;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;
public class DebitCardService {
    Scanner sc = new Scanner(System.in);
    public DebitCard createDebitCard(ArrayList<User> customers) {

        DebitCard debitCard = new DebitCard();

        System.out.println("---- Debir Card -----");

        String cardnumber = String.valueOf((long)(Math.random() *1000000000+1));
        System.out.println("Number of debit card " + cardnumber + "/n");

        boolean segurityControl;
        do{
            try {
                segurityControl=false;
                System.out.println("Enter the segurity code of the debit card");
                String securityCode = sc.nextLine();
                if (securityCode.equals("")) {
                    throw new ExcepValidationDebitCard("Security code can´t be empty");
                } else if (securityCode.length() != 4) {
                    throw new ExcepValidationDebitCard("Security code must be 4");
                } else {
                    debitCard.setSecurityCode(Integer.parseInt(securityCode));
                }
            }catch(Exception e){
                e.printStackTrace();
                segurityControl=true;
            }
        }while(segurityControl);

        System.out.println("Enter the expiration date of the debit card:  ");

        String expirationDate="";
        boolean monthControl ;
        do{
            try{
                monthControl=false;
                System.out.println("You must enter 2 digit for month. Month: ");
                int month = sc.nextInt();
                if(month <13){
                    System.out.println("--------------------------------");
                }else {
                    throw new ExcepValidationUser("Invalid");
                }
            }catch(Exception e){
                e.printStackTrace();//para imprimir por consola
                monthControl=true;
            }
        }while(monthControl);

        boolean yearControl;
        do{
            try{
                yearControl=false;
                System.out.println("Year: ");
                int year=sc.nextInt();
               if (year>= Year.now().getValue()){
                   System.out.println("--");
               }else{
                   throw new ExcepValidationUser("Invalid year");
               }
            }catch (Exception e){
                e.printStackTrace();
                yearControl=true;
            }
        }while(yearControl);

        debitCard.setExpirationDate(expirationDate);

        return debitCard;
    };

    }

