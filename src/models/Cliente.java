package models;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private ArrayList<Horario> horarios;
    public Cliente(String nome, String email, String senha, String telefone) {
        super(nome, email, senha, telefone);

    }

    public void addHorario(Horario horario){
        horarios.add(horario);
    }

    public ArrayList<Horario> getHorarios(){
        return horarios;
    }
}
