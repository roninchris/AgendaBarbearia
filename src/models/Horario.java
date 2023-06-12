package models;

import java.time.LocalDateTime;

public class Horario {
    private LocalDateTime dataHora;
    private boolean disponibilidade;
    private Barbeiro barbeiro;
    private Cliente cliente;

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

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Barbeiro getBarbeiro(){
        return barbeiro;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente(Horario horario){
        return horario.cliente;
    }
}
