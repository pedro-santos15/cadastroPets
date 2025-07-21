package model.services;

import application.menu.Menu;
import model.entities.Pet;
import model.enums.Sexo;
import model.enums.Tipo;
import model.vo.Endereco;
import model.vo.Nome;

public class CadastroPet {

    public static void cadastrar(String caminho){
        String[] respostas = Menu.getRespostas();
        Nome nome;
        Tipo tipo = Tipo.valueOf(respostas[1]);
        Sexo sexo = Sexo.valueOf(respostas[2]);
        Endereco endereco;
        String idade;
        String peso;
        String raca;

        Menu.leituraFormulario(caminho);



        if (respostas[0].isBlank()){
            nome = new Nome("NÃO INFORMADO");
        } else {
            nome = new Nome(respostas[0]);
        }

        String[] enderecovect = respostas[3].split(",");



    }
}
