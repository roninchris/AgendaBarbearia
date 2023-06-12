package models;

public class Barbeiro extends Pessoa{
    private Agenda agenda;
    public Barbeiro(String nome, String email, String senha, String telefone) {

        super(nome, email, senha, telefone);
        this.agenda = new Agenda(this);

    }

    public Agenda getAgenda() {
        return agenda;
    }

    @Override
    public String getNome(){
        return "Barbeiro " + nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = "Barbeiro " + nome;
    }
}
