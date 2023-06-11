package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Agenda {
    private Barbeiro barbeiro;
    private ArrayList<Horario> horarios;

    public Agenda(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
        this.horarios = criarHorarios();
    }

    private ArrayList<Horario> criarHorarios() {
        ArrayList<Horario> horarios = new ArrayList<>();

        // Obtém a data atual
        LocalDate dataAtual = LocalDate.now().plusDays(1); // Adiciona um dia

        // Define o horário de início e fim
        LocalTime horarioInicio = LocalTime.of(8, 0);
        LocalTime horarioFim = LocalTime.of(19, 0);

        // Cria os horários com intervalo de 1 hora
        LocalDateTime dataHora = LocalDateTime.of(dataAtual, horarioInicio);
        while (dataHora.toLocalTime().isBefore(horarioFim)) {
            Horario horario = new Horario(dataHora, true, barbeiro);
            horarios.add(horario);
            dataHora = dataHora.plusHours(1);
        }

        return horarios;
    }
    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    // getters e setters
}
