package controllers;

import models.Barbeiro;
import models.Cliente;
import models.Pessoa;

import java.util.ArrayList;

public class Autenticacao {
    private ArrayList<Pessoa> usuarios; // Lista de usuários registrados

    public Autenticacao() {
        // Inicializa a lista de usuários
        usuarios = new ArrayList<Pessoa>();
    }

    //Verifica se o email já não é utilizado no sistema
    private boolean verificarCadastro(String email) {
        for (Pessoa usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    private boolean adicionarUsuario(Pessoa usuario) {
        if (verificarCadastro(usuario.getEmail())) {
            usuarios.add(usuario);
            return true;
        } else {
            return false;
        }
    }

    public boolean cadastrarCliente(String nome, String email, String senha, String telefone) {
        Cliente cliente = new Cliente(nome, email, senha, telefone);
        return adicionarUsuario(cliente);

    }

    public boolean cadastrarBarbeiro(String nome, String email, String senha, String telefone) {
        Barbeiro barbeiro = new Barbeiro(nome, email, senha, telefone);
        return adicionarUsuario(barbeiro);

    }

    public boolean autenticar(String email, String senha) {
        for (Pessoa usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return true; // Autenticação bem-sucedida
            }
        }
        return false; // Autenticação falhou
    }

    public void atualizarCliente(Cliente cliente) {
        // Atualize os dados do cliente no banco de dados ou em algum sistema de armazenamento
    }

    public void atualizarBarbeiro(Barbeiro barbeiro) {
        // Atualize os dados do barbeiro no banco de dados ou em algum sistema de armazenamento
    }

    public ArrayList<Cliente> getClientes() {
        // Obtenha a lista de clientes do banco de dados ou de algum sistema de armazenamento
        ArrayList<Cliente> clientes = new ArrayList<>();
        // Retorne a lista de clientes
        return clientes;
    }

    public ArrayList<Barbeiro> getBarbeiros() {
        // Obtenha a lista de barbeiros do banco de dados ou de algum sistema de armazenamento
        ArrayList<Barbeiro> barbeiros = new ArrayList<>();
        // Retorne a lista de barbeiros
        return barbeiros;
    }
}
