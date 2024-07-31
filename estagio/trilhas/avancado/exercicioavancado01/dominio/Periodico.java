package estagio.trilhas.avancado.exercicioavancado01.dominio;

import java.time.LocalDate;

public class Periodico extends ItemBiblioteca {
    LocalDate ultimaPublicacao;
    FrequenciaPublicacao frequenciaPublicacao;

    public Periodico(String titulo, String autor, boolean disponivel, LocalDate ultimaPublicacao, FrequenciaPublicacao frequenciaPublicacao) {
        super(titulo, autor, disponivel);
        this.ultimaPublicacao = ultimaPublicacao;
        this.frequenciaPublicacao = frequenciaPublicacao;
    }

    @Override
    public void emprestar() throws ItemNaoDisponivelException {
        if (this.isDisponivel()) {
            this.setDisponivel(false);
        } else {
            throw new ItemNaoDisponivelException("O periódico " + this.getTitulo() + " não está disponível. Aguarde a devolução do mesmo ou aguarde pela próxima publicação");
        }
    }

    @Override
    public void devolver() {
        if (!this.isDisponivel()) {
            this.setDisponivel(true);
        } else {
            System.out.println("Este item já foi devolvido ou há uma nova publicação para ser resgatada.");
        }
    }

    @Override
    public boolean isDisponivel() {
        atualizarDisponibilidade();

        return super.isDisponivel();
    }

    @Override
    public String toString() {
        return "Períodico: " + this.getTitulo() +", Autor: " + this.getAutor() + ", Última Públicação: " + this.getUltimaPublicacao() + ", Frequência de Publicação: " + this.frequenciaPublicacao.frequencia;
    }

    public void atualizarDisponibilidade(){
        if (this.frequenciaPublicacao.hasNovaPublicacao(ultimaPublicacao, LocalDate.now())) {
            this.setDisponivel(true);
        }
    }

    public LocalDate getUltimaPublicacao() {
        return ultimaPublicacao;
    }

    public void setUltimaPublicacao(LocalDate ultimaPublicacao) {
        this.ultimaPublicacao = ultimaPublicacao;
    }

    public FrequenciaPublicacao getFrequenciaPublicacao() {
        return frequenciaPublicacao;
    }

    public void setFrequenciaPublicacao(FrequenciaPublicacao frequenciaPublicacao) {
        this.frequenciaPublicacao = frequenciaPublicacao;
    }
}
