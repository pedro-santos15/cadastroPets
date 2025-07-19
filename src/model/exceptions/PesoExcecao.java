package model.exceptions;

public class PesoExcecao extends RuntimeException {
    public PesoExcecao(String message) {
        System.out.println(message);
    }
}
