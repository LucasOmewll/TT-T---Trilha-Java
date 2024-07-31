package estagio.trilhas.avancado.exercicioavancado01.dominio;

public enum TipoArquivo {
    MP3(".mp3"),
    WAV(".wav"),
    PDF(".pdf"),
    MP4(".mp4");

    private String extensao;

    TipoArquivo(String extensao) {
        this.extensao = extensao;
    }

    public String getExtensao() {
        return extensao;
    }
}
