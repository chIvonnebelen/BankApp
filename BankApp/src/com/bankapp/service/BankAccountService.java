package com.bankapp.service;

import com.bankapp.entity.BankAccount;
import com.bankapp.entity.User;
import com.bankapp.exception.ExcepValidationBankAccount;
import java.util.ArrayList;
import java.util.Scanner;
public class BankAccountService {
    Scanner sc = new Scanner(System.in);
    BankAccount bankAccount = new BankAccount();
    DebitCardService debitCardService = new DebitCardService();

    UserService userService = new UserService();

 /*    public void menuBanckAccount(ArrayList<User> customers) {   //debit card atraves de bankAccount, mismo de usuario

        int numValitor = 0;
        System.out.println("Choose one option ");
        System.out.println("--------------------------------");
        System.out.println("1. Login to bankAccount");
        System.out.println("2. First Deposit");
        System.out.println("3. Deposit");
        System.out.println("4. Transaction");
        System.out.println("5. Extraction");
        System.out.println("6. Debit Card");
        System.out.println("7. Exit");

        numValitor = sc.nextInt();
        switch (numValitor) {
            case 1:
                System.out.println("Welcome to bankAccount");
               // System.out.println(loginBankAccount(customers));
                User user = loginBankAccount(customers);
                user.getAccounts();
                break;
            case 2:
                System.out.println("Enter the firs initial deposit ");
                initialDeposit(bankAccount);
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
                System.out.println("Debit Card");
                bankAccount.setDebit(debitCardService.createDebitCard(customers));
                break;
            case 7:
                System.out.println("Return to previous menu");

                break;

            case 8:
                System.out.println("Salir");

                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }*/

    public User loginBankAccount(ArrayList<User> customers){
            boolean validator;
            String username="";
            User user=new User();
            do {
                try {
                    validator = false;
                    System.out.println(" Enter the username :");
                    username = sc.next();
                    for (User aux : customers) {
                        if (aux.getUsername().equals(username)) { //para no repetir datos user
                            System.out.println("username correct");
                            loginPaswword(aux.getPassword());
                            System.out.println("Welcome "+ aux.getName());
                            user=aux;
                            break;
                        }
                    }
                } catch (Exception e) {
                    validator=true;
                    e.printStackTrace();
                }
            } while (validator);

            return user;
    }
    public void loginPaswword(String passwordUser){

        boolean validator;
        String password="";

        do {
            try {
                validator = false;
                System.out.println(" Enter the password :");
                password = sc.next();

                    if (passwordUser.equals(password)) { //para no repetir datos user
                        System.out.println("-------");
                    }else{
                        throw new ExcepValidationBankAccount("Password incorrect invalid, try again");
                    }

            } catch (Exception e) {
                validator=true;
                e.printStackTrace();
            }
        } while (validator);
      //  return password;
    }
    public BankAccount createBankAccount(ArrayList<User> customers){
        actualBalance(bankAccount);
        deposit(bankAccount);
        transfer(bankAccount);
        extraction(bankAccount);
        bankAccount.setDebit(debitCardService.createDebitCard(customers));
        return bankAccount;
        //  bankAccount.setMenu(unionService.menu());// chequear
    }

    public void cbuValidation(BankAccount bankAccount) {
        System.out.println("Enter you alias : ");
        boolean aliasControl=true;
        do {
            try {
                aliasControl=false;
                String cbu = sc.nextLine();
                if (cbu.equals("")) {
                    throw new ExcepValidationBankAccount("Invalid CBU");
                } else {
                    bankAccount.setCbu(bankAccount.getCbu());
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        } while (!aliasControl);
    }

    public void initialDeposit(BankAccount bankAccount){
        boolean depositControl=true;
        do{
            try{
                depositControl=false;
                System.out.println("Enter the first initial deposit");
                double firstDeposit = sc.nextDouble();
                if (firstDeposit >0.0){
                    bankAccount.setBalance(bankAccount.getBalance()+firstDeposit);
                    System.out.println("Congratulation of the first deposit" );
                    System.out.println("Your actual balance is " + bankAccount.getBalance());

                }else{
                    throw new ExcepValidationBankAccount("Invalid Initial Deposit");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }while (!depositControl);

    }
    public void actualBalance(BankAccount bankAccount) {

        if (bankAccount.getBalance() < 0.0) {
            throw new ExcepValidationBankAccount("Insufficient balance");
        }else{
            System.out.println("Your account balance is " + bankAccount.getBalance());
        }
    }
    public void  deposit(BankAccount bankAccount) {
        System.out.println(" Enter the deposit amount");
        double newDeposit = sc.nextDouble();
        if (newDeposit > 0.0) {
            bankAccount.setBalance(bankAccount.getBalance() + newDeposit);
            System.out.println("You deposit : " + newDeposit);
            System.out.println("Your actual balance is " + bankAccount.getBalance());
        } else{
            throw new ExcepValidationBankAccount("Invalid deposit");
        }
    }

    public void transfer(BankAccount bankAccount){
        System.out.println("Enter the transfer amount");

        double amount= sc.nextDouble();
        if(amount > bankAccount.getBalance()){
            throw new ExcepValidationBankAccount("Insuficient amount");
        }else{
            bankAccount.setBalance(bankAccount.getBalance()-amount);
            System.out.println("Successful transfer");
            System.out.println("Your actual balance : "+ bankAccount.getBalance());
        }
    }
    public void extraction(BankAccount bankAccount){
        System.out.println("Enter the extraction amount");
        double amount= sc.nextDouble();
        if(amount<0.0 ){
            throw new ExcepValidationBankAccount("Invalid amount");
        } else if(amount > bankAccount.getBalance()){
            throw new ExcepValidationBankAccount("Insuficient amount");
    }else {
            bankAccount.setBalance(bankAccount.getBalance()-amount);
            System.out.println("Successful extraction");
            System.out.println("Your actual balance : "+ bankAccount.getBalance());
        }

    }
}