package models;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

public class Horario {
    private Date dataHora;
    private boolean disponibilidade;
    private Barbeiro barbeiro;

    public Horario(Date dataHora, boolean disponibilidade, Barbeiro barbeiro) {
        this.dataHora = dataHora;
        this.disponibilidade = disponibilidade;
        this.barbeiro = barbeiro;
    }

    public Date getData() {
        return dataHora;
    }

    public void setData(Date dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

}
