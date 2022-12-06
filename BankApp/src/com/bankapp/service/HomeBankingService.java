package com.bankapp.service;

import com.bankapp.entity.HomeBanking;
import com.bankapp.exception.ExcepValidationLogin;

import java.util.List;
import java.util.Scanner;

public class HomeBankingService {
    private final Scanner sc = new Scanner(System.in);

    public HomeBanking login(List<HomeBanking> homeBankings) {
        HomeBanking account = null; //inicializarlo

        System.out.println("Enter the username :");
        String usersame = sc.next();

        try {

            for (HomeBanking homeBanking : homeBankings) {
                if (homeBanking.getUsername().equals(usersame)){
                    account = homeBanking;
                }
            }
            if (account != null){
                System.out.println("Enter password");
                String password = sc.next();
                if (account.getPassword().equals(password)){
                    System.out.println("You have entered correctly.. ");
                } else {
                  throw new ExcepValidationLogin("Wrong password");
                }
            }else {

                throw new ExcepValidationLogin("Invalid user");
            }

        } catch ( Exception e ) {
            e.printStackTrace();
        };
        return account;
    }

}



