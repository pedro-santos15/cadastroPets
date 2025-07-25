package model.entities;

import model.enums.Sexo;
import model.enums.Tipo;
import model.exceptions.IdadeExcecao;
import model.exceptions.PesoExcecao;
import model.vo.Endereco;
import model.vo.Nome;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    private Nome nome;
    private String idade;
    private String peso;
    private Endereco endereco;
    private Tipo tipo;
    private Sexo sexo;
    private String raca;

    private static List<Pet> pets = new ArrayList<>();

    public Pet(Nome nome, String idade, String peso, Endereco endereco, Tipo tipo, Sexo sexo, String raca) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.endereco = endereco;
        this.tipo = tipo;
        this.sexo = sexo;
        this.raca = raca;
        pets.add(this);
    }

    public Nome getNome() {
        return nome;
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        if (validacaoIdade(idade)) {
            this.idade = idade;
        }
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public static List<Pet> getPets() {
        if (pets.isEmpty()){
            System.out.println("Atualmente não há nenhum pet cadastrado!");
        }
        return pets;
    }

    public static void adicionarPet(Pet pet) {
        pets.add(pet);
    }

    public static boolean validacaoIdade(String idade) {
        try {
            if (idade.isBlank()) {
                idade = "NÃO INFORMADO";
                return true;
            }
            double valor = Double.parseDouble(idade);
            if (idade.matches("^\\d+([.,]\\d+)?$") && Integer.parseInt(String.valueOf(Math.round(valor))) <= 20) {
                return true;
            } else {
                throw new IdadeExcecao("Idade preenchida incorretamente");
            }
        } catch (NumberFormatException e) {
            throw new IdadeExcecao("Idade preenchida incorretamente");
        }
    }

    public static boolean validacaoPeso(String peso) {
        try {
            double valor = Double.parseDouble(peso);
            if (peso.matches("^\\d+([.,]\\d+)?$") && Integer.parseInt(String.valueOf(Math.round(valor))) < 60
                    && Double.parseDouble(peso) > 0.5) {
                return true;
            } else {
                throw new PesoExcecao("Peso preenchido incorretamente");
            }
        } catch (NumberFormatException e) {
            throw new PesoExcecao("Peso preenchido incorretamente");
        }

    }

    public static void removerPet(Pet pet) {
        pets.remove(pet);
    }

    @Override
    public String toString() {
        return nome + " - "
                + tipo + " - "
                + sexo + " - "
                + endereco + " - "
                + idade + " anos - "
                + peso + "kg - "
                + raca;
    }
}
