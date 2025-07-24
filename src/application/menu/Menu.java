package application.menu;

import model.services.BuscaPet;
import model.services.CadastroPet;
import model.vo.Nome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static String[] respostas = new String[9];

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

                    while (escolha != 6){

                        switch (escolha){
                            case 1 -> CadastroPet.cadastrar("formulario.txt");
                            case 2 -> BuscaPet.buscar();
                        }

                        if (escolha < 1 || escolha > 6) {
                            throw new InputMismatchException("\nEntrada inválida! Por favor digite um número válido pelo sistema!\n");
                        }

                        escolhasMenu();
                        escolha = sc.nextInt();
                        sc.nextLine();

                    }


                } else {
                    sc.next();
                    throw new InputMismatchException("\nEntrada inválida! Por favor digite um número válido pelo sistema!\n");
                }


            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void leituraFormulario(String caminho) {
        Scanner sc = new Scanner(System.in);
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String line = br.readLine();

            int i = 0;

            while (line != null) {
                System.out.println(line);

                if (line.equals("4 - Qual endereço que ele foi encontrado?")){
                    line = br.readLine();
                    continue;
                }
                respostas[i] = sc.nextLine();

                switch (i) {
                    case 1 -> {
                        if (!respostas[1].equalsIgnoreCase("CACHORRO") || respostas[1].isBlank()) {
                            if (!respostas[1].equalsIgnoreCase("GATO")) {
                                throw new RuntimeException("Tipo desconhecido! Favor informar o tipo correto (Cachorro/Gato)");
                            }
                        }
                    }
                    case 2 -> {
                        if (!respostas[2].equalsIgnoreCase("MASCULINO") || respostas[2].isBlank()) {
                            if (!respostas[2].equalsIgnoreCase("FEMININO")) {
                                throw new RuntimeException("Sexo desconhecido! Favor informar o sexo correto (Masculino/Feminino)");
                            }
                        }
                    }
                    case 3 -> {
                        if (respostas[3].isBlank()){
                            throw new RuntimeException("Favor informar uma rua valida!");
                        }
                    }
                    case 5 -> {
                        if (respostas[5].isBlank()){
                            throw new RuntimeException("Favor informar uma cidade existente");
                        }
                    }

                }
                line = br.readLine();
                i++;
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
