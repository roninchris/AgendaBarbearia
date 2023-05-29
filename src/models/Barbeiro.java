package models;

import java.util.ArrayList;

public class Barbeiro extends Pessoa{
    private ArrayList<Barbeiro> barbeiros = new ArrayList<Barbeiro>();
    public Barbeiro(String nome, String email, String senha, String telefone) {

        super(nome, email, senha, telefone);

        barbeiros.add(this);
    }

    public ArrayList<Barbeiro> getBarbeiros() {
        return barbeiros;
    }

    public void addBarbeiros(ArrayList<Barbeiro> barbeiros) {
        this.barbeiros = barbeiros;
    }
}
