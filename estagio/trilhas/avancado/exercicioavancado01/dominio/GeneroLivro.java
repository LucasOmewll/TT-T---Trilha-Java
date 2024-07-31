package estagio.trilhas.avancado.exercicioavancado01.dominio;

public enum GeneroLivro{
    FANTASIA("Fantasia"),
    FICCAO("Ficção"),
    DRAMA("Drama"),
    TERROR("Terror"),
    HISTORIA("História");

    private String genero;

    GeneroLivro(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
}