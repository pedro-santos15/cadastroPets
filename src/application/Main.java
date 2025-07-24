package application;

import application.menu.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String caminho = "formulario.txt";


        try (Scanner sc = new Scanner(System.in)) {
            Menu.menuInicial();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


    }
}
