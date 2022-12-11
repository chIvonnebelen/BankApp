package com.bankapp;
import com.bankapp.service.MenuService;

public  class Main {
    public static void main(String[] args) {

        MenuService menuService = new MenuService();

        menuService.menuPrincipal();

        }

}