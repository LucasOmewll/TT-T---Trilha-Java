package estagio.trilhas.avancado.exercicioavancado01.dominio;

public abstract class ItemBiblioteca {
    private String titulo;
    private String autor;
    private boolean disponivel;

    public ItemBiblioteca(String titulo, String autor, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
    }

    public abstract void emprestar() throws ItemNaoDisponivelException;

    public abstract void devolver();

    @Override
    public String toString() {
        return this.autor + " " + this.titulo + " " + this.disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
