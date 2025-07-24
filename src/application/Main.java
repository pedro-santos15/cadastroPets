package application;

import application.menu.Menu;
import model.services.BuscaPet;

public class Main {
    public static void main(String[] args) {

        String caminho = "formulario.txt";


        try {
            Menu.menuInicial();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


    }
}
