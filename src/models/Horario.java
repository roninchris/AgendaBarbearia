package models;

import java.sql.Time;
import java.util.Date;

public class Horario {
    private Date data;
    private Time hora;
    private boolean disponibilidade;
    private Barbeiro barbeiro;

    public Horario(Date data, Time hora, boolean disponibilidade, Barbeiro barbeiro) {
        this.data = data;
        this.hora = hora;
        this.disponibilidade = disponibilidade;
        this.barbeiro = barbeiro;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }
}
