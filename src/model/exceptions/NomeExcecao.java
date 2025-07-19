package model.exceptions;

public class NomeExcecao extends RuntimeException {
    public NomeExcecao(String message) {
        System.out.println(message);
    }
}
