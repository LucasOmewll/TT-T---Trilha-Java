package estagio.trilhas.avancado.exercicioavancado02.dominio;

public class DadoInvalidoException extends Exception {
    public DadoInvalidoException() {
        System.out.println("Dados inválidos.");
    }

    public DadoInvalidoException(String message) {
        super(message);
    }
}
