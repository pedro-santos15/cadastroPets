package model.vo;

import model.exceptions.NomeExcecao;

public class Nome {

    private String primeiroNome;
    private String sobrenome;
    private String nomeCompleto;

    public Nome(String nomeCompleto) {
        if (validacaoNome(nomeCompleto.trim())) {
            String[] campos = nomeCompleto.split(" ");
            this.primeiroNome = campos[0];
            this.sobrenome = campos[campos.length - 1];
            this.nomeCompleto = nomeCompleto;
        } else if (nomeCompleto.isBlank()) {
            this.nomeCompleto = "NÃO INFORMADO";
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

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public static boolean validacaoNome(String nomeCompleto) {

        return nomeCompleto.matches("^[A-Za-zÀ-ÖØ-öø-ÿ]+( [A-Za-zÀ-ÖØ-öø-ÿ]+)+$");

    }

    @Override
    public String toString() {
        return nomeCompleto;
    }
}
