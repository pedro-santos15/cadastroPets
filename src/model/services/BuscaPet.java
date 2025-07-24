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

            Predicate<Pet> predicateTotal = p -> p.getTipo().toString().contains(buscaPets.get("tipo"));

            for (String s : buscaPets.keySet()) {
                switch (s.toLowerCase()){
                    case "nome" -> {
                        Predicate<Pet> predicate = p -> p.getNome().getPrimeiroNome().contains(buscaPets.get(s));
                        predicateTotal.and(predicate);
                    }
                    case "sobrenome" -> {
                        Predicate<Pet> predicate = p -> p.getNome().getSobrenome().contains(buscaPets.get(s));
                        predicateTotal.and(predicate);
                    }
                    case "sexo" ->  {
                        Predicate<Pet> predicate = p -> p.getSexo().toString().contains(buscaPets.get(s));
                    predicateTotal.and(predicate);
                    }
                    case "idade" -> {
                        Predicate<Pet> predicate = p -> p.getIdade().contains(buscaPets.get(s));
                        predicateTotal.and(predicate);
                    }
                    case "peso" -> {
                        Predicate<Pet> predicate = p -> p.getPeso().contains(buscaPets.get(s));
                        predicateTotal.and(predicate);
                    }
                    case "raça", "raca" ->{
                        Predicate<Pet> predicate = p -> p.getRaca().contains(buscaPets.get(s));
                        predicateTotal.and(predicate);
                    }
                    case "endereco", "endereço" -> {
                        Predicate<Pet> predicate = p -> p.getEndereco().toString().contains(buscaPets.get(s));
                        predicateTotal.and(predicate);
                    }
                    default -> throw new RuntimeException("Nenhum critério foi identificado");
                }
            }
            List<Pet> filtrados = Pet.getPets()
                    .stream()
                    .filter(predicateTotal)
                    .toList();

            if (filtrados.isEmpty()){
                throw new RuntimeException("Sua busca não retornou nada, por favor tente outros critérios!");
            }

            System.out.println(filtrados);
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
