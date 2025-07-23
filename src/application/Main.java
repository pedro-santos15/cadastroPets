package application;

import application.menu.Menu;
import model.services.BuscaPet;

public class Main {
    public static void main(String[] args) {

        String caminho = "formulario.txt";
        //Menu.menuInicial();

        try {
            BuscaPet.buscar();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


    }
}
