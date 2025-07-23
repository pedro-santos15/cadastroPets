package model.services;

import model.entities.Pet;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BuscaPet {

    public static void buscar(){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Qual o tipo do animal?");
            String tipo = sc.nextLine();

            Map<String, String> buscaPets = new HashMap<>();
            buscaPets.put("tipo", tipo);

            menuBusca();
            String criterio = sc.nextLine();

            List<String> criterios;


            if (criterio.contains(" e ")){
               criterios  = List.of(criterio.toLowerCase().split(" e "));

                for (String s : criterios) {
                    System.out.print(s + " que deseja buscar: ");
                    buscaPets.put(s, sc.nextLine());
                }
            } else {
                criterios = List.of(criterio);

                System.out.print(criterio + " que deseja buscar: ");
                buscaPets.put(criterio, sc.nextLine());
            }

            List<Pet> filtrados;

            for (String s : buscaPets.keySet()) {
                String teste = String.valueOf(s.equalsIgnoreCase(s));

                switch (String.valueOf(s.equalsIgnoreCase(s)).toLowerCase()){
                    case "nome" -> filtrados = Pet.getPets().stream()
                            .filter(p -> p.getNome().getPrimeiroNome().contains(buscaPets.get(s)))
                            .toList();
                    case "sobrenome" -> filtrados = Pet.getPets().stream()
                            .filter(p -> p.getNome().getSobrenome().contains(buscaPets.get(s)))
                            .toList();
                    case "sexo" -> filtrados = Pet.getPets().stream()
                            .filter(p -> p.getSexo().toString().toLowerCase().contains(buscaPets.get(s)))
                            .toList();
                    case "idade" -> filtrados = Pet.getPets().stream()
                            .filter(p -> p.getIdade().contains(buscaPets.get(s)))
                            .toList();
                    case "peso" -> filtrados = Pet.getPets().stream()
                            .filter(p -> p.getPeso().contains(buscaPets.get(s)))
                            .toList();
                }
            }
        }
    }

    public static void menuBusca(){

        System.out.println("Nome ou sobrenome");
        System.out.println("Sexo");
        System.out.println("Idade");
        System.out.println("Peso");
        System.out.println("Raça");
        System.out.println("Endereço");
        System.out.println("Escreva de um a dois critérios para busca");
    }
}
