package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;


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
        LocalDate dataAtual = LocalDate.now();

        // Obtém o primeiro dia do mês atual
        LocalDate primeiroDiaMesAtual = dataAtual.withDayOfMonth(1);

        // Define o horário de início e fim
        LocalTime horarioInicio = LocalTime.of(8, 0);
        LocalTime horarioFim = LocalTime.of(19, 0);

        // Verifica se a data atual é igual ou posterior ao primeiro dia do mês atual
        if (dataAtual.isAfter(primeiroDiaMesAtual) || dataAtual.isEqual(primeiroDiaMesAtual)) {
            // Cria os horários para o dia atual com intervalo de 1 hora
            LocalDateTime dataHora = LocalDateTime.of(dataAtual, horarioInicio);
            while (dataHora.toLocalTime().isBefore(horarioFim)) {
                Horario horario = new Horario(dataHora, true, barbeiro);
                horarios.add(horario);
                dataHora = dataHora.plusHours(1);
            }
        }

        // Percorre os dias restantes do mês atual
        LocalDate data = primeiroDiaMesAtual.plusDays(1);
        while (data.getMonthValue() == primeiroDiaMesAtual.getMonthValue()) {
            // Cria os horários para cada dia com intervalo de 1 hora
            LocalDateTime dataHora = LocalDateTime.of(data, horarioInicio);
            while (dataHora.toLocalTime().isBefore(horarioFim)) {
                Horario horario = new Horario(dataHora, true, barbeiro);
                horarios.add(horario);
                dataHora = dataHora.plusHours(1);
            }
            data = data.plusDays(1);
        }

        return horarios;
    }


    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void addHorario(Horario horario) {
        horarios.add(horario);
    }

}
