package estagio.trilhas.avancado.exercicioavancado01.dominio;

public class ItemNaoEncontradoException extends Exception{
    public ItemNaoEncontradoException() {
        super("Não foi possível encontrar o item.");
    }

    public ItemNaoEncontradoException(String message) {
        super(message);
    }
}
