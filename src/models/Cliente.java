package models;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private ArrayList<Horario> agendamentos = new ArrayList<>();
    public Cliente(String nome, String email, String senha, String telefone) {
        super(nome, email, senha, telefone);

    }

    public void addAgendamento(Horario horario){
        agendamentos.add(horario);
    }

    public ArrayList<Horario> getAgendamentos(){
        return agendamentos;
    }


}
