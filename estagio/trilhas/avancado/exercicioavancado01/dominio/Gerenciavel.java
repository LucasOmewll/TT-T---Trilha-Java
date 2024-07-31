package estagio.trilhas.avancado.exercicioavancado01.dominio;

public interface Gerenciavel{
    void adicionarItem(ItemBiblioteca item);

    void removerItem(ItemBiblioteca item);

    ItemBiblioteca buscarItem(String titulo);
}
