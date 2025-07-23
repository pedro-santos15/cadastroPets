package model.services;

import application.menu.Menu;
import model.entities.Pet;
import model.enums.Sexo;
import model.enums.Tipo;
import model.exceptions.IdadeExcecao;
import model.exceptions.PesoExcecao;
import model.vo.Endereco;
import model.vo.Nome;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CadastroPet {

    public static void cadastrar(String caminho){
        Menu.leituraFormulario(caminho);
        String[] respostas = Menu.getRespostas();
        Nome nome;
        Tipo tipo = null;
        Sexo sexo = null;
        Endereco endereco;
        String idade;
        String peso;
        String raca;



        if (respostas[0].isBlank()){
            nome = new Nome("NÃO INFORMADO");
        } else {
            nome = new Nome(respostas[0]);
        }

        if (respostas[1].equalsIgnoreCase("cachorro")){
            tipo = Tipo.CACHORRO;
        } else {
            tipo = Tipo.GATO;
        }

        if (respostas[2].equalsIgnoreCase("masculino")){
            sexo = Sexo.MASCULINO;
        } else {
            sexo = Sexo.FEMININO;
        }

        if (respostas[4].isBlank()){
            endereco = new Endereco(respostas[3], "NÃO INFORMADO", respostas[5]);
        } else {
            endereco = new Endereco(respostas[3], respostas[4], respostas[5]);
        }

        if (respostas[6].isBlank()) {
            idade = "NÃO INFORMADO";
        } else if (Pet.validacaoIdade(respostas[6])){
            idade = respostas[6];
        } else {
            throw new IdadeExcecao("Idade inválida! Favor informe apenas números");
        }

        if (respostas[7].isBlank()){
            peso = "NÃO INFORMADO";
        } else if (Pet.validacaoPeso(respostas[7])) {
            peso = respostas[7];
        } else {
            throw new PesoExcecao("Peso invalido! Favor informe um peso valido");
        }

        if (respostas[8].isBlank()){
            raca = "NÃO INFORMADO";
        } else if (respostas[8].matches("^[A-Za-zÀ-ÖØ-öø-ÿ]+( [A-Za-zÀ-ÖØ-öø-ÿ]+)*$")) {
            raca = respostas[8];
        } else {
            throw new RuntimeException("Raça Inválida! Favor informar uma raça válida");
        }

        Pet pet = new Pet(nome, idade, peso, endereco, tipo, sexo, raca);

        armazenamentoPet(pet);
    }

    public static void armazenamentoPet(Pet pet){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");

        String nomeArquivo = fmt.format(LocalDateTime.now())
                + pet.getNome().getNomeCompleto().replace(" ", "").toUpperCase() + ".txt";

        File arquivo = new File("pets", nomeArquivo);

        File diretorioArquivo = arquivo.getParentFile();
        if (diretorioArquivo != null && !diretorioArquivo.exists()){
            diretorioArquivo.mkdirs();
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {

        String[] respostas = pet.toString().split("\\.");

            for (int i = 0; i < respostas.length ; i++) {
                bw.write(i + 1 + " - " + respostas[i]);
                bw.newLine();
            }



        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
