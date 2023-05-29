package controllers;

import models.Cliente;

public class CadastroClienteController {
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    public CadastroClienteController(String nome, String email, String senha, String telefone){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;

        new Cliente(nome, email, senha, telefone);
    }

}
