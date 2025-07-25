package model.services;

import model.entities.Pet;
import model.exceptions.IdadeExcecao;
import model.exceptions.PesoExcecao;
import model.vo.Endereco;
import model.vo.Nome;

import java.util.Scanner;

public class AlterarPet {
    public static void alterar() {
        Scanner sc = new Scanner(System.in);

        int nPetAlteracao = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            BuscaPet.buscar();

            System.out.println("Qual pet você deseja editar?");
            nPetAlteracao = sc.nextInt();
            sc.nextLine();

            if (nPetAlteracao > BuscaPet.getFiltrados().size() || nPetAlteracao < 0) {
                System.out.println("\nDigite um número válido para o pet!\n");
            } else {
                entradaValida = true;
            }
        }

        int index = nPetAlteracao - 1;
        int atributoAlteracao = 0;

        while (atributoAlteracao < 1 || atributoAlteracao > 5) {
            menuAlteracao();
            System.out.println("Qual atributo você deseja alterar?");
            atributoAlteracao = sc.nextInt();
            sc.nextLine();

            if (atributoAlteracao < 1 || atributoAlteracao > 5) {
                System.out.println("\nDigite um número existente para o atributo que deseja alterar!\n");
            }
        }

        switch (atributoAlteracao) {
            case 1 -> {
                System.out.println("Digite o novo nome completo:");
                BuscaPet.getFiltrados().get(index).setNome(new Nome(sc.nextLine()));
            }
            case 2 -> {
                System.out.println("Digite a nova idade:");
                String idade = sc.nextLine();
                if (idade.isBlank()) {
                    BuscaPet.getFiltrados().get(index).setIdade("NÃO INFORMADO");
                } else if (Pet.validacaoIdade(idade)) {
                    BuscaPet.getFiltrados().get(index).setIdade(idade);
                } else {
                    throw new IdadeExcecao("Idade inválida! Favor informe apenas números");
                }
            }
            case 3 -> {
                System.out.println("Digite o peso novo:");
                String peso = sc.nextLine();

                if (peso.isBlank()) {
                    BuscaPet.getFiltrados().get(index).setPeso("NÃO INFORMADO");
                } else if (Pet.validacaoPeso(peso)) {
                    BuscaPet.getFiltrados().get(index).setPeso(peso);
                } else {
                    throw new PesoExcecao("Peso invalido! Favor informe um peso valido");
                }
            }
            case 4 -> {
                System.out.println("Digite a raça:");
                String raca = sc.nextLine();
                if (raca.isBlank()) {
                    BuscaPet.getFiltrados().get(index).setRaca("NÃO INFORMADO");
                } else if (raca.matches("^[A-Za-zÀ-ÖØ-öø-ÿ]+( [A-Za-zÀ-ÖØ-öø-ÿ]+)*$")) {
                    BuscaPet.getFiltrados().get(index).setRaca(raca);
                } else {
                    throw new RuntimeException("Raça Inválida! Favor informar uma raça válida");
                }
            }
            case 5 -> {
                System.out.println("Digite o novo endereço:");
                System.out.print("Rua: ");
                String rua = sc.nextLine();
                System.out.print("Número: ");
                String numero = sc.nextLine();
                System.out.print("Cidade: ");
                String cidade = sc.nextLine();

                if (numero.isBlank()) {
                    BuscaPet.getFiltrados().get(index).setEndereco(new Endereco(rua, "NÃO INFORMADO", cidade));
                } else {
                    BuscaPet.getFiltrados().get(index).setEndereco(new Endereco(rua, numero, cidade));
                }
            }
        }

        System.out.println(BuscaPet.getFiltrados().get(index));


    }

    public static void menuAlteracao() {
        System.out.println("1 - Nome");
        System.out.println("2 - Idade");
        System.out.println("3 - Peso");
        System.out.println("4 - Raça");
        System.out.println("5 - Endereço");
    }
}
