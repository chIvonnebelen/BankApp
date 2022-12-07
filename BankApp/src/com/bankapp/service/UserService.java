package com.bankapp.service;

import com.bankapp.entity.User;
import com.bankapp.exception.ExcepValidationUser;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    Scanner sc = new Scanner(System.in);
    public void createUser(ArrayList<User> customers){
        BankAccountService bankAccountService = new BankAccountService();
        while(verifyUser(customers)){
            User user = new User();

            System.out.println("Enter the name ");

            try {
                String name = sc.nextLine();
                if (name.trim().equals("")){
                    throw new ExcepValidationUser("Name can´t be empty");
                } else{
                    user.setName(name);
                }

                System.out.println("Enter the lastName");
                String lastName = sc.nextLine();
                if(lastName.trim().equals("")){
                    throw new ExcepValidationUser("LastName can´t be empty");
                } else {
                    user.setLastName(lastName);
                }

                System.out.println("Enter the email");
                String email = sc.nextLine();
                if(email.trim().equals("")){
                    throw new ExcepValidationUser("Email can´t be empty");
                }else if(!email.contains("@")||!email.contains(".com")){
                    throw new ExcepValidationUser("Email must contain @ and .com ");
                }else {
                    user.setEmail(email);
                }

                System.out.println("Enter the dni");
                String dni = sc.nextLine();
                if(dni.trim().equals("")){
                    throw new ExcepValidationUser("Dni can´t be empty");
                } else if (dni.length()!=8) {
                    throw new ExcepValidationUser("Eight characters expected");
                } else {
                    user.setDni(Integer.parseInt(dni));
                }

                System.out.println("Enter the age");
                String age = sc.nextLine();
                if(age.trim().equals("")){
                    throw new ExcepValidationUser("Age can´t be empty");
                } else if(Integer.parseInt(age)<18){
                    throw new ExcepValidationUser("Age must be greater than 18");
                } else {
                    user.setAge(Integer.parseInt(age));
                }

                user.setAccount(bankAccountService.createBankAccount(customers));

            }catch (Exception e){
                e.printStackTrace();
            }
            customers.add(user);
            showUser(customers);
        }
        System.out.println("You have a exceeded the limit");
    }

    private boolean verifyUser (ArrayList<User> clientes) {
        return clientes.size() < 10;
    };
    public void showUser(ArrayList<User> clientes) {
        for (User user : clientes) {
            System.out.println("Name: "+user.getName() );
            System.out.println("Last Name: "+ user.getLastName() );
            System.out.println("Email: " + user.getEmail() );
            System.out.println("Dni:  " + user.getDni());
            System.out.println("Age: " + user.getAge());
        }
    }
}
