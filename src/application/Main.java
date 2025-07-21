package application;

import application.menu.Menu;

public class Main {
    public static void main(String[] args) {

        String caminho = "formulario.txt";
        //Menu.menuInicial();

        try {
            Menu.menuInicial();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


    }
}
