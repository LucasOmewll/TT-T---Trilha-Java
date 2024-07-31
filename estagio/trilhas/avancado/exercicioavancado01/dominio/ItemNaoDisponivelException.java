package estagio.trilhas.avancado.exercicioavancado01.dominio;

public class ItemNaoDisponivelException extends Exception{
    public ItemNaoDisponivelException() {
        System.out.println("Não foi possível realizar o empréstimo: o item não está disponível");
    }

    public ItemNaoDisponivelException(String message) {
        super(message);
    }

}
