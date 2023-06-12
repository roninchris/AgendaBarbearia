package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Agenda {
    private Barbeiro barbeiro;
    private ArrayList<Horario> horariosDisponiveis;
    private ArrayList<Horario> horariosAgendados = new ArrayList<>();

    public Agenda(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
        this.horariosDisponiveis = criarHorarios();
    }

    private ArrayList<Horario> criarHorarios() {
        ArrayList<Horario> horariosDisponiveis = new ArrayList<>();

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
                horariosDisponiveis.add(horario);
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
                horariosDisponiveis.add(horario);
                dataHora = dataHora.plusHours(1);
            }
            data = data.plusDays(1);
        }

        return horariosDisponiveis;
    }


    public ArrayList<Horario> getHorarios() {
        return horariosDisponiveis;
    }

    public void agendarHorario(Horario horario) {
        horariosAgendados.add(horario);
    }

    public Horario getHorario(String localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        ArrayList<Horario> horarios = getHorarios();

        for(Horario horario : horarios){
            if (horario.getDataHora().format(formatter).equals(localDateTime)){
                return horario;
            }
        }

        return null;
    }

    public ArrayList<Horario> getAgendamentos(){
        return horariosAgendados;
    }
}
