package estagio.trilhas.avancado.exercicioavancado01.dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public enum FrequenciaPublicacao {
    SEMANAL("Semanal"){
        @Override
        public boolean hasNovaPublicacao(LocalDate dataUltimaPublicacao, LocalDate dataAtual) {
            double diasEntre = ChronoUnit.DAYS.between(dataAtual, dataUltimaPublicacao);

            if (diasEntre >= 7) {
                return true;
            } else return false;
        }
    },

    BISSEMANAL("Bissemanal"){
        @Override
        public boolean hasNovaPublicacao(LocalDate dataUltimaPublicacao, LocalDate dataAtual) {
            double diasEntre = ChronoUnit.DAYS.between(dataAtual, dataUltimaPublicacao);

            if (diasEntre >= 14) {
                return true;
            } else{
                return false;
            }
        }
    },

    MENSAL("Mensal"){
        @Override
        public boolean hasNovaPublicacao(LocalDate dataUltimaPublicacao, LocalDate dataAtual) {
            double mesEntre = ChronoUnit.MONTHS.between(dataAtual, dataUltimaPublicacao);

            if (mesEntre >= 1) {
                return true;
            } else{
                return false;
            }
        }
    },

    BIMESTRAL("Bimestral"){
        @Override
        public boolean hasNovaPublicacao(LocalDate dataUltimaPublicacao, LocalDate dataAtual) {
            double mesEntre = ChronoUnit.MONTHS.between(dataAtual, dataUltimaPublicacao);

            if (mesEntre >= 2) {
                return true;
            } else{
                return false;
            }
        }
    },

    SEMESTRAL("Semestral"){
        @Override
        public boolean hasNovaPublicacao(LocalDate dataUltimaPublicacao, LocalDate dataAtual) {
            double mesEntre = ChronoUnit.MONTHS.between(dataAtual, dataUltimaPublicacao);

            if (mesEntre >= 6) {
                return true;
            } else{
                return false;
            }
        }
    };
    public String frequencia;

    FrequenciaPublicacao(String frequencia) {
        this.frequencia = frequencia;
    }

    public abstract boolean hasNovaPublicacao(LocalDate dataUltimaPublicacao, LocalDate dataAtual);

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }
}
