package application.menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void menuInicial() {
        int escolha = 0;
        Scanner sc = new Scanner(System.in);
        while (escolha < 1 || escolha > 6) {
            try {
                escolhasMenu();

                if (sc.hasNextInt()) {
                    escolha = sc.nextInt();

                    if (escolha < 1 || escolha > 6) {
                        throw new InputMismatchException("\nEntrada inválida! Por favor digite um número válido pelo sistema!\n");
                    }

                } else {
                    sc.next();
                    throw new InputMismatchException("\nEntrada inválida! Por favor digite um número válido pelo sistema!\n");
                }

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }

    public static void leituraFormulario(String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void escolhasMenu() {
        System.out.println("1. Cadastrar um novo pet");
        System.out.println("2. Alterar os dados do pet cadastrado");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6. Sair");
        System.out.print("Qual opção você deseja? ");
    }


}
