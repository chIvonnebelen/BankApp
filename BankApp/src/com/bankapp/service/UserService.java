package com.bankapp.service;

import com.bankapp.entity.BankAccount;
import com.bankapp.entity.User;
import com.bankapp.exception.ExcepValidationUser;
import java.util.ArrayList;
import java.util.Scanner;
public class UserService {
    User user;
    Scanner sc = new Scanner(System.in);
    public User createUser(ArrayList<User> customers){
        BankAccountService bankAccountService = new BankAccountService();

            User user = new User();
            boolean nameControl;

        do {
            try{
                nameControl=false;
                System.out.println("Enter the name ");
                String name = sc.nextLine();
                if (name.trim().equals("")){
                    throw new ExcepValidationUser("Name can´t be empty, try again");
                } else if (verifyString(name)){
                    throw new ExcepValidationUser("only letters");
                }
                else{
                    user.setName(name);
                }
            }catch(Exception e){
                e.printStackTrace();
                nameControl=true;
            }
        }   while (nameControl);

        boolean lastNameControl;
        do {
            try{
                lastNameControl=false;
                System.out.println("Enter the lastName");
                String lastName = sc.nextLine();
                if(lastName.trim().equals("")){
                    throw new ExcepValidationUser("LastName can´t be empty");

                } else if (verifyString(lastName)){
                throw new ExcepValidationUser("only letters");
                }
                else {
                    user.setLastName(lastName);
                }
            }catch (Exception e){
                e.printStackTrace();
                lastNameControl=true;
            }

        }while(lastNameControl);

        boolean emailControl;
        do{
            try{
                emailControl=false;
                System.out.println("Enter the email");
                String email = sc.nextLine();
                if(email.trim().equals("")){
                    throw new ExcepValidationUser("Email can´t be empty");
                }else if(!email.contains("@")||!email.contains(".com")){
                    throw new ExcepValidationUser("Email must contain @ and .com ");
                }else {
                    user.setEmail(email);
                }
            } catch (Exception e){
                e.printStackTrace();
                emailControl=true;
            }
        }while(emailControl);

        boolean dniControl;
        do{
            try{
                dniControl=false;
                System.out.println("Enter the dni");
                String dni = sc.nextLine();
                if(dni.trim().equals("")){
                    throw new ExcepValidationUser("Dni can´t be empty");
                } else if (dni.length()!=8) {
                    throw new ExcepValidationUser("Eight characters expected");
                } else {
                    user.setDni(Integer.parseInt(dni));
                }
            }catch (Exception e){
                dniControl = true;
                e.printStackTrace();
            }
        }while(dniControl);

         boolean ageControl;
         do{
             try{
                 ageControl=false;
                 System.out.println("Enter the age");
                 String age = sc.nextLine();
                 if(age.trim().equals("")){
                     throw new ExcepValidationUser("Age can´t be empty");
                 } else if(Integer.parseInt(age)<18){
                     throw new ExcepValidationUser("Age must be greater than 18");
                 } else {
                     user.setAge(Integer.parseInt(age));
                 }
                 }catch (Exception e){
                 ageControl=true;
                 e.printStackTrace();}
         }while(ageControl);
         boolean usernameControl;
         do{
             try{
                 usernameControl=false;
                 System.out.println("Enter the username");
                 String username = sc.nextLine();
                 if(username.trim().equals("")){
                     throw new ExcepValidationUser("Username can´t be empty");
                 } else if (verifyUsername(customers,username)){
                     throw new ExcepValidationUser("The username is already exist, try again");
                 }
                 else {
                     user.setUsername(username);
                 }
             }catch (Exception e){
                 usernameControl=true;
                 e.printStackTrace();
             }
         }while(usernameControl);

         boolean passwordControl;
         do{
             try{
                 passwordControl=false;
                 System.out.println("Enter the password");
                 System.out.println("The password must be 4 numbers");
                 String password = sc.nextLine();

                 if (password.trim().equals("")){
                     throw new ExcepValidationUser("Password can´t be empty");
                 }else {
                     user.setPassword(password);
                 }
             }catch (Exception e){
                 passwordControl=true;
                 e.printStackTrace();
             }
         }while(passwordControl);

      /*   try {
             System.out.println( "Do you want to make the first deposit \n1 - YES  \n2 -NO ");
             int option= sc.nextInt();
             if (option == 1){
                 System.out.println("Enter the money :");
                 int amountFirst= sc.nextInt();
                 System.out.println("Your account balance is: " + user.getAccounts().get(0).getBalance()+ amountFirst);
             }else {
                 System.out.println("Thanks for using our service");
             }
         }catch (Exception e){
             e.printStackTrace();
         }*/

            customers.add(user);

            return user;
    }
    public boolean verifyUser(ArrayList<User> customers) {

            boolean verificator;
            if (customers.size() < 10) {
                verificator = false;
            } else {
                verificator = true;
            }
            return verificator;
    };
    public void showUser(ArrayList<User> customers) {
        for (User user : customers) {
            System.out.println("Name: " + user.getName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Dni:  " + user.getDni());
            System.out.println("Age: " + user.getAge());
        }
    }
// show Accounts

    public boolean verifyString(String n) {
        boolean validatorString=false;
       for(int i = 0; i < n.length(); i++) {
           if(Character.isDigit(n.charAt(i)))
           {
              validatorString=true;
           }
       }return validatorString;
    }
    public boolean verifyUsername(ArrayList<User> customers, String username) {
        boolean validator = false;
        for (User aux : customers) {
            if (aux.getUsername().equals(username)) { //para no repetir datos user
                validator = true;
            }
        }return validator;
    }
   /*

    public void passwordValidation(ArrayList<User> customers, BankAccount bankAccount) {
        boolean passwordControl = true;

        System.out.println("Enter the password :");
        do {
            try {
                String password = sc.nextLine();
                for (User auxpassword : customers) {
                    if (auxpassword.getAccount().equals(password)) {
                        throw new ExcepValidationBankAccount("unavailable password ");
                    }
                }
                if (password.equals("")) {
                    throw new ExcepValidationBankAccount("Password can´t be empty");
                } else if (password.length() != 4) {
                    throw new ExcepValidationBankAccount("Password  must be 4 digit ");
                }
                else {
                    user.setPassword(String.valueOf(Integer.parseInt(password)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (passwordControl);

    }*/

}
