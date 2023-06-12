package views;

import controllers.Autenticacao;
import models.Barbeiro;
import models.Cliente;
import models.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EdicaoBarbeiroView {
    private Autenticacao autenticacao;
    private Barbeiro barbeiro;
    private JFrame frame;
    private JPanel panel;
    private JTextField nomeTextField;
    private JTextField emailTextField;
    private JTextField senhaTextField;
    private JTextField telefoneTextField;

    public EdicaoBarbeiroView(Autenticacao autenticacao, Barbeiro barbeiro, JFrame frame) {
        this.autenticacao = autenticacao;
        this.barbeiro = barbeiro;
        this.frame = frame;

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel senhaLabel = new JLabel("Senha:");
        JLabel telefoneLabel = new JLabel("Telefone:");

        nomeTextField = new JTextField(barbeiro.getNome());
        emailTextField = new JTextField(barbeiro.getEmail());
        senhaTextField = new JTextField(barbeiro.getSenha());
        telefoneTextField = new JTextField(barbeiro.getTelefone());

        JButton salvarButton = new JButton("Salvar");
        JButton cancelarButton = new JButton("Cancelar");

        panel.add(nomeLabel);
        panel.add(nomeTextField);
        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(senhaLabel);
        panel.add(senhaTextField);
        panel.add(telefoneLabel);
        panel.add(telefoneTextField);
        panel.add(salvarButton);
        panel.add(cancelarButton);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarDadosEditados();
                voltarParaBarbeiroLogado();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaBarbeiroLogado();
            }
        });
    }

    private void salvarDadosEditados() {
        String nome = nomeTextField.getText();
        String email = emailTextField.getText();
        String senha = senhaTextField.getText();
        String telefone = telefoneTextField.getText();

        barbeiro.setNome(nome);
        barbeiro.setEmail(email);
        barbeiro.setSenha(senha);
        barbeiro.setTelefone(telefone);

        autenticacao.atualizarBarbeiro(barbeiro);
    }

    private void voltarParaBarbeiroLogado() {
        frame.setContentPane(new BarbeiroLogadoView(autenticacao, frame).getPanel());
        frame.revalidate();
        frame.repaint();
    }

    private Barbeiro getBarbeiroLogado() {
        for (Pessoa pessoa : autenticacao.getClientes()) {
            if (pessoa.getEmail().equals(autenticacao.getEmailUsuarioLogado())) {
                return (Barbeiro) pessoa;
            }
        }
        return null;
    }
    public JPanel getPanel() {
        return panel;
    }
}
