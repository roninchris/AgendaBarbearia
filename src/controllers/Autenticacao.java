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

    private boolean verificarCadastro(String email){
        for(Pessoa usuario : usuarios){
            if(usuario.getEmail().equals(email)) {
                return false;
            }
        }

        return true;
    }

    private void adicionarUsuario(Pessoa usuario) {
        if(verificarCadastro(usuario.getEmail())){
            usuarios.add(usuario);
        }
        else {
            System.out.println("Email já cadastrado dentro do sistema");
        }

    }

    public void cadastrarCliente(String nome, String email, String senha, String telefone){
        Cliente cliente = new Cliente(nome, email, senha, telefone);
        adicionarUsuario(cliente);
    }

    public void cadastrarBarbeiro(String nome, String email, String senha, String telefone){
        Barbeiro barbeiro = new Barbeiro(nome, email, senha, telefone);
        adicionarUsuario(barbeiro);
    }

    public boolean autenticar(String email, String senha) {
        for (Pessoa usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return true; // Autenticação bem-sucedida
            }
        }
        return false; // Autenticação falhou
    }
}
