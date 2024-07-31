package estagio.trilhas.avancado.exercicioavancado01.dominio;

public class MidiaDigital extends ItemBiblioteca {
    public TipoArquivo tipoArquivo;

    public MidiaDigital(String titulo, String autor, boolean disponivel) {
        super(titulo, autor, disponivel);
    }

    public MidiaDigital(String titulo, String autor, boolean disponivel, TipoArquivo tipoArquivo) {
        super(titulo, autor, disponivel);
        this.tipoArquivo = tipoArquivo;
    }

    @Override
    public String toString() {
        return  "Livro: " + this.getTitulo() + ", Autor: " + this.getAutor() + ", Formato de Arquivo: " + this.tipoArquivo.getExtensao();
    }

    @Override
    public void emprestar() {
        System.out.println(this.getTitulo() + " foi adicionado à sua coleção");
    }

    @Override
    public void devolver() {
        System.out.println(this.getTitulo() + " foi removido da sua coleção");
    }
}
