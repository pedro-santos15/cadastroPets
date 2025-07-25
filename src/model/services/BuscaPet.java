package model.services;

import model.entities.Pet;

import java.util.*;
import java.util.function.Predicate;

public class BuscaPet {
    private static List<Pet> filtrados;

    public static List<Pet> getFiltrados() {
        return filtrados;
    }

    public static void buscar() {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Qual o tipo do animal?");
            String tipo = sc.nextLine();

            Map<String, String> map = new HashMap<>();
            map.put("tipo", tipo);

            menuBusca();
            String criterio = sc.nextLine();

            List<String> criterios;


            if (criterio.contains(" e ")) {
                criterios = List.of(criterio.toLowerCase().split(" e "));

                for (String s : criterios) {
                    System.out.print(s.toUpperCase() + " QUE DESEJA BUSCAR: ");
                    map.put(s.toLowerCase(), sc.nextLine());
                }
            } else {
                System.out.print(criterio.toUpperCase() + " QUE DESEJA BUSCAR: ");
                map.put(criterio.toLowerCase(), sc.nextLine());
            }

            Predicate<Pet> predicateTotal = p -> true;

            for (String s : map.keySet()) {

                String valor = map.get(s).trim().toLowerCase();
                switch (s.toLowerCase()) {

                    case "tipo" -> {
                        Predicate<Pet> predicate = p -> p.getTipo().toString().toLowerCase().contains(valor);
                        predicateTotal = predicateTotal.and(predicate);
                    }

                    case "nome" -> {
                        Predicate<Pet> predicate = p -> p.getNome().getPrimeiroNome().toLowerCase().contains(valor);
                        predicateTotal = predicateTotal.and(predicate);
                    }
                    case "sobrenome" -> {
                        Predicate<Pet> predicate = p -> p.getNome().getSobrenome().toLowerCase().contains(valor);
                        predicateTotal = predicateTotal.and(predicate);
                    }
                    case "sexo" -> {
                        Predicate<Pet> predicate = p -> p.getSexo().toString().toLowerCase().contains(valor);
                        predicateTotal = predicateTotal.and(predicate);
                    }
                    case "idade" -> {
                        Predicate<Pet> predicate = p -> p.getIdade().toLowerCase().contains(valor);
                        predicateTotal = predicateTotal.and(predicate);
                    }
                    case "peso" -> {
                        Predicate<Pet> predicate = p -> p.getPeso().toLowerCase().contains(valor);
                        predicateTotal = predicateTotal.and(predicate);
                    }
                    case "raça", "raca" -> {
                        Predicate<Pet> predicate = p -> p.getRaca().toLowerCase().contains(valor);
                        predicateTotal = predicateTotal.and(predicate);
                    }
                    case "endereco", "endereço" -> {
                        Predicate<Pet> predicate = p -> p.getEndereco().toString().toLowerCase().contains(valor);
                        predicateTotal = predicateTotal.and(predicate);
                    }
                }
            }
            filtrados = Pet.getPets()
                    .stream()
                    .filter(predicateTotal)
                    .toList();

            if (filtrados.isEmpty()) {
                System.out.println("Sua busca não retornou nada, por favor tente outros critérios!");
            }

            for (int i = 0; i < filtrados.size(); i++) {
                System.out.println((i + 1) + ". " + filtrados.get(i));
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida!");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void menuBusca() {

        System.out.println("Nome ou sobrenome");
        System.out.println("Sexo");
        System.out.println("Idade");
        System.out.println("Peso");
        System.out.println("Raça");
        System.out.println("Endereço");
        System.out.println("Escreva de um a dois critérios para busca:");
        System.out.println("(Separe por 'e' os critérios)");
    }
}
