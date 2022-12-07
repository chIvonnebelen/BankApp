package com.bankapp.service;

import com.bankapp.entity.BankAccount;
import com.bankapp.entity.User;
import com.bankapp.exception.ExcepValidationBankAccount;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountService {
    Scanner sc = new Scanner(System.in);
    BankAccount bankAccount = new BankAccount();
    public void menuBanckAccount(ArrayList<User> customers) {   //debit card atraves de bankAccount, mismo de usuario

        int numValitor=0;
        System.out.println("Choose one option ");
        System.out.println("--------------------------------");
        System.out.println("1. First Deposit");
        System.out.println("2. Enter the Alias");
        System.out.println("3. Deposit");
        System.out.println("4. Transaction");
        System.out.println("5. Extraction");

        numValitor= sc.nextInt();
        switch (numValitor) {
            case 1:
                System.out.println("Enter the firs initial deposit ");
                actualBalance(bankAccount);
                break;
            case 2:
                System.out.println("Alias ");
                cbuValidation(bankAccount);
                break;
            case 3:

                System.out.println("Deposit ");
                deposit(bankAccount);
                break;
            case 4:
                System.out.println("Transaction");
                transfer(bankAccount);

                break;
            case 5:
                System.out.println("Extraction");
                extraction(bankAccount);

                break;
            case 6:
                System.out.println("Salir");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }
    public BankAccount createBankAccount(ArrayList<User> customers){
        DebitCardService debitCardService= new DebitCardService();

        System.out.println(usernameValidation(customers));
        passwordValidation(bankAccount);
        cbuValidation(bankAccount);
        actualBalance(bankAccount);
        bankAccount.setUsername(usernameValidation(customers));
        deposit(bankAccount);
        transfer(bankAccount);
        extraction(bankAccount);

        bankAccount.setDebit(debitCardService.createDebitCard(customers));

        return bankAccount;
    };

    public String usernameValidation(ArrayList<User> clientes) {

        String username= "";
        Boolean validation;

        System.out.println("Enter the username :");

        do {
            validation= false;
            try {
                username = sc.next();
                for (User aux : clientes) {
                    if (aux.getAccount().getUsername().equals(username)) { //para no repetir datos user
                        validation= true;
                        System.out.println("The usermane  is already exist, try again: ");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (validation);


        return username;
    }
    public void passwordValidation(BankAccount bankAccount){

        System.out.println("Enter the password :");
        String password=sc.nextLine();
        if (password.equals("")) {
            throw new ExcepValidationBankAccount("Password can´t be empty");
        }else if (password.length()!=4){
            throw new ExcepValidationBankAccount("Password  must be 4 digit ");
        }else {
            bankAccount.setPassword(String.valueOf(Integer.parseInt(password)));
        }
    }

    public void cbuValidation(BankAccount bankAccount) {
        System.out.println("Enter you alias : ");
        try {
            String cbu = sc.nextLine();
            if (cbu.equals("")) {
                throw new ExcepValidationBankAccount("Invalid CBU");
            }else {
                bankAccount.setCbu(bankAccount.getCbu());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void actualBalance(BankAccount bankAccount) {
        System.out.println("Enter the first initial deposit");
        bankAccount.setBalance(sc.nextDouble());
        if (bankAccount.getBalance() < 0.0) {
            throw new ExcepValidationBankAccount("Insufficient balance");
        }else{
            System.out.println("Your account balance is " + bankAccount.getBalance());
        }
    }

    public void  deposit(BankAccount bankAccount){
        System.out.println(" Enter the deposit amount");
        Double newDeposit= sc.nextDouble();
        bankAccount.setBalance(bankAccount.getBalance()+newDeposit);

    }
    public void transfer(BankAccount bankAccount ){
        System.out.println("Enter the transfer amount");
        Double amount= sc.nextDouble();
        if(amount  > bankAccount.getBalance()){
            throw new ExcepValidationBankAccount("Insuficient amount");
        }else{
            bankAccount.setBalance(bankAccount.getBalance()-amount);
        }
    }
    public void extraction(BankAccount bankAccount){
        System.out.println("Enter the extraction amount");
        Double amount= sc.nextDouble();
        if(amount  < bankAccount.getBalance()){
            throw new ExcepValidationBankAccount("Insuficient amount");
    }else {
            bankAccount.setBalance(bankAccount.getBalance()-amount);}
    }
}