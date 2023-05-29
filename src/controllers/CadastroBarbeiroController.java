package controllers;

import models.Barbeiro;

import java.sql.SQLOutput;

public class CadastroBarbeiroController {
    private String nome;
    private String email;
    private String senha;
    private String telefone;

    public CadastroBarbeiroController(String nome, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;

        Barbeiro newBarbeiro = new Barbeiro(nome, email, senha, telefone);

        System.out.println(newBarbeiro.getBarbeiros());

    }
}
