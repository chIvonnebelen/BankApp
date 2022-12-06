package com.bankapp.service;

import com.bankapp.entity.BankAccount;
import com.bankapp.entity.User;
import com.bankapp.exception.ExcepValidationBankAccount;
import com.bankapp.exception.ExcepValidationLogin;

import java.util.Scanner;



public class BankAccountService {

    Scanner sc = new Scanner(System.in);

    public void createBankAccount() {
        BankAccount bankAccount = new BankAccount();
   /*  bankAccount.setUserId(user.getUserId());
     bankAccount.setUserName(user.getUserName());
     bankAccount.setPassword(user.getPassword());*/

        int numValitor=0;
        System.out.println("Choose one option ");
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
    public void cbuValidation(BankAccount bankAccount) {
        System.out.println("Enter the first initial deposit");
        bankAccount.setBalance(sc.nextDouble());
        System.out.println("Enter you alias : ");
        try {
            String cbu = sc.next();
            if (cbu.equals("")) {
                throw new ExcepValidationBankAccount("Invalid CBU");
            }else {
                bankAccount.setBalance(bankAccount.getBalance());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void actualBalance(BankAccount bankAccount) {
        if (bankAccount.getBalance() < 0.0) {
            throw new ExcepValidationBankAccount("Insufficient balance");
        }else{
            System.out.println("Your account balance is " + bankAccount.getBalance());
        }
    }

    public void  deposit(BankAccount bankAccount ){
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