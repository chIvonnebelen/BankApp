package com.bankapp.service;

import com.bankapp.entity.User;
import com.bankapp.exception.ExcepValidationUser;

import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    Scanner sc = new Scanner(System.in);
    ArrayList<User> clientes = new ArrayList<>();
    public void createUser(){
        while(verifyUser()){
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

            }catch (Exception e){
                e.printStackTrace();
            }
            clientes.add(user);
            showUser();
        }
        System.out.println("You have a exceeded the limit");
    }

    private boolean verifyUser () {
        return clientes.size() < 10;
    };
    public void showUser() {
        for (User user : clientes) {
            System.out.println(user.getName() + " " + user.getLastName() + " " + user.getEmail() + " " + user.getDni() + " " + user.getAge());
        }
    }
}
