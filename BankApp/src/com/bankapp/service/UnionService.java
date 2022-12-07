package com.bankapp.service;
import com.bankapp.entity.User;
import java.util.ArrayList;
import java.util.Scanner;

public class UnionService {
    Scanner sc = new Scanner(System.in);
    UserService userService = new UserService();
    BankAccountService bankAccountService= new BankAccountService();
    ArrayList<User> customers = new ArrayList<>();

    public void menu(){

        inicialiarDatos();
        Integer i = 1;
        boolean band=false;
        while(!band){
            System.out.println("CHOOSE ONE OPTION ");
            System.out.println("---------------------------------------------------------------");
            System.out.println("1. Create user");
            System.out.println("");
            System.out.println("2. Enter to you banking account");
            System.out.println("");
            System.out.println("3. Leave the program");

          /*  System.out.println("3. Welcome to your Bank account");
            System.out.println(" ");
          //  System.out.println("4. Enter your debit card number");
          //  System.out.println("");*/
            i=sc.nextInt();
            switch(i){
                case 1:
                    System.out.println(" Complete the dates ");
                    userService.createUser(customers);
                    break;
                    case 2:
                    System.out.println("Welcome to your banking account ");
                    bankAccountService.menuBanckAccount(customers);
                    break;
                   /* case 3:
                    System.out.println("Welcome to your Bank Account ");
                    //bankAccountService.createBankAccount();
                    break;*/
                     case 3:
                    System.out.println("Thanks you for using  our services ");
                    break;
                default:
                    System.out.println("The number is not available");
            }
            band=true;
        }


    }

    public  void inicialiarDatos(){


        User user1 = new User("Pepita", "Ona", "majitopepis@gmail.com", 89765456, 20);
        User user2 = new User("Shakira", "Aguila", "chaquichaqui@gmail.com", 93872908, 30);
       // HomeBanking homeBanking1= new HomeBanking("deOro9", "4576", user1  );
       // HomeBanking homeBanking2=new HomeBanking("chiqui3", "ti890", user2);
        //
        customers.add(user1);
        customers.add(user2);

    };


}
