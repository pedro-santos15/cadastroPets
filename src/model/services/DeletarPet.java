package model.services;

import model.entities.Pet;

import java.util.Scanner;

public class DeletarPet {
    public static void deletar() {

        Scanner sc = new Scanner(System.in);

        int nPetDelecao = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            BuscaPet.buscar();

            System.out.println("Qual pet você deseja deletar?");
            nPetDelecao = sc.nextInt();
            sc.nextLine();

            if (nPetDelecao > BuscaPet.getFiltrados().size() || nPetDelecao < 0) {
                System.out.println("\nDigite um número válido para o pet!\n");
            } else {
                entradaValida = true;
            }
        }

        int index = nPetDelecao - 1;

        boolean confirmacao = false;

        while (!confirmacao) {
            System.out.println("Tem certeza que deseja deletar este Pet? (SIM/NAO)");
            String resposta = sc.nextLine();

            if (resposta.equalsIgnoreCase("SIM")) {
                Pet.removerPet(BuscaPet.getFiltrados().get(index));
                confirmacao = true;
            } else if (resposta.equalsIgnoreCase("NAO")) {
                System.out.println("Operação cancelada!");
                confirmacao = true;
            } else {
                System.out.println("Entrada inválida, para confirmação digite SIM ou NAO");
            }
        }

    }
}
