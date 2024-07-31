package estagio.trilhas.avancado.exercicioavancado01.dominio;

public class Livro extends ItemBiblioteca {
    public GeneroLivro generoLivro;
    private int edicao;

    public Livro(String titulo, String autor, boolean disponivel) {
        super(titulo, autor, disponivel);
    }

    public Livro(String titulo, String autor, boolean disponivel, GeneroLivro generoLivro, int edicao) {
        super(titulo, autor, disponivel);
        this.generoLivro = generoLivro;
        this.edicao = edicao;
    }

    @Override
    public void emprestar() throws ItemNaoDisponivelException {
        if (this.isDisponivel()) {
            this.setDisponivel(false);
        } else {
            throw new ItemNaoDisponivelException("O livro " + this.getTitulo() + " não está disponível para empréstimo. Aguarde a devolução do mesmo para pegá-lo.");
        }
    }

    @Override
    public void devolver() {
        if (!this.isDisponivel()){
            this.setDisponivel(true);
        }else {
            System.out.println("Este item já foi devolvido previamente.");
        }
    }

    @Override
    public String toString() {
        return "Livro: " + this.getTitulo() + " " + this.getEdicao() +"ª Edição, Autor: " + this.getAutor() + ", Gênero: " + this.generoLivro.getGenero();
    }

    public GeneroLivro getGeneroLivro() {
        return generoLivro;
    }

    public void setGeneroLivro(GeneroLivro generoLivro) {
        this.generoLivro = generoLivro;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
}
