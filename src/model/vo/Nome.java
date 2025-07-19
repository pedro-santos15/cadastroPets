package model.vo;

import model.exceptions.NomeExcecao;

public class Nome {

    private String primeiroNome;
    private String sobrenome;

    public Nome(String nomeCompleto) {
        if (validacaoNome(nomeCompleto.trim())){
            String[] campos = nomeCompleto.split(" ");
            this.primeiroNome = campos[0];
            this.sobrenome = campos[campos.length - 1];
        } else {
            throw new NomeExcecao("O nome está inválido, favor conferir novamente!");
        }
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public static boolean validacaoNome(String nomeCompleto){

        return nomeCompleto.matches("^[A-Za-zÀ-ÖØ-öø-ÿ]+( [A-Za-zÀ-ÖØ-öø-ÿ]+)+$");

    }

    @Override
    public String toString() {
        return primeiroNome + " " + sobrenome;
    }
}
