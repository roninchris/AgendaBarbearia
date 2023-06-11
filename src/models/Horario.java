package models;

import java.time.LocalDateTime;

public class Horario {
    private LocalDateTime dataHora;
    private boolean disponibilidade;
    private Barbeiro barbeiro;

    public Horario(LocalDateTime dataHora, boolean disponibilidade, Barbeiro barbeiro) {
        this.dataHora = dataHora;
        this.disponibilidade = disponibilidade;
        this.barbeiro = barbeiro;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
