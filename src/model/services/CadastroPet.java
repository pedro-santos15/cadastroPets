package model.services;

import application.menu.Menu;
import model.entities.Pet;
import model.enums.Sexo;
import model.enums.Tipo;
import model.vo.Endereco;
import model.vo.Nome;

public class CadastroPet {

    public static void cadastrar(String caminho){
        Nome nome;
        String idade;
        String peso;
        Endereco endereco;
        Tipo tipo;
        Sexo sexo;
        String raca;

        Menu.leituraFormulario(caminho);
        String[] respostas = Menu.getRespostas();


        if (respostas[0].isBlank()){
            nome = new Nome("NÃO INFORMADO");
        } else {
            nome = new Nome(respostas[0]);
        }

        if (respostas[1].equalsIgnoreCase("Cachorro")|| respostas[1].equalsIgnoreCase("Gato")){
            tipo = Tipo.valueOf(respostas[1]);
        } else {
            throw new RuntimeException("Favor informar um tipo válido (Cachorro/Gato)");
        }

    }
}
