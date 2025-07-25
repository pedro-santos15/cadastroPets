package application;

import application.menu.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("****************************************************");
            System.out.println("    SEJA BEM VINDO AO SISTEMA DE GESTÃO DE PETS");
            System.out.println("****************************************************");

            Menu.menuInicial();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


    }
}
