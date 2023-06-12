package models;
import java.time.LocalDateTime;

public class Agendamento {
    private LocalDateTime horario;
    private String observacao;

    public Agendamento(LocalDateTime horario, String observacao) {
        this.horario = horario;
        this.observacao = observacao;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public String getObservacao() {
        return observacao;
    }
}