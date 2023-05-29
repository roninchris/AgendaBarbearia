package models;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public Cliente(String nome, String email, String senha, String telefone) {
        super(nome, email, senha, telefone);

        clientes.add(this);
    }
}
