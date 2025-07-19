package application.menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static String[] respostas = new String[7];

    public static String[] getRespostas() {
        return respostas;
    }

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
        Scanner sc = new Scanner(System.in);
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String line = br.readLine();

            int i = 0;

            while (line != null) {
                System.out.println(line);
                respostas[i] = sc.nextLine();

                if (i == 1){
                    if (!respostas[1].equalsIgnoreCase("CACHORRO")){
                        if (!respostas[1].equalsIgnoreCase("GATO")){
                            System.out.println("Tipo desconhecido! Favor informar o tipo correto (Cachorro/Gato)");
                            break;
                        }
                    }
                }


                line = br.readLine();
                i++;
            }

            System.out.println(Arrays.toString(respostas));
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        sc.close();
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
