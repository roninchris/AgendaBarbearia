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
    private boolean verificarSeCadastroExiste(String email) {
        for (Pessoa usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    private boolean adicionarUsuario(Pessoa usuario) {
        if (verificarSeCadastroExiste(usuario.getEmail())) {
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
        ArrayList<Pessoa> usuarios = getUsuarios();
        ArrayList<Cliente> clientes = new ArrayList<>();

        for(Pessoa pessoa : usuarios){
            if(pessoa instanceof Cliente){
                clientes.add((Cliente) pessoa);
            }
        }
        // Retorne a lista de clientes
        return clientes;
    }

    public ArrayList<Barbeiro> getBarbeiros() {
        ArrayList<Pessoa> usuarios = getUsuarios();
        ArrayList<Barbeiro> barbeiros = new ArrayList<>();

        for (Pessoa pessoa : usuarios) {
            if(pessoa instanceof Barbeiro){
                barbeiros.add((Barbeiro) pessoa);
            }
        }
        // Retorne a lista de barbeiros
        return barbeiros;
    }

    private ArrayList<Pessoa> getUsuarios(){
        return usuarios;
    }
}
