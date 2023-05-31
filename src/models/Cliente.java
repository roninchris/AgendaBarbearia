package models;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(String nome, String email, String senha, String telefone) {
        super(nome, email, senha, telefone);
        clientes.add(this);
    }

    public static void excluirCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
