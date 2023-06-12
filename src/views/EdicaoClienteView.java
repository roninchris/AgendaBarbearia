package views;

import controllers.Autenticacao;
import models.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EdicaoClienteView {
    private Autenticacao autenticacao;
    private Cliente cliente;
    private JFrame frame;
    private JPanel panel;
    private JTextField nomeTextField;
    private JTextField emailTextField;
    private JTextField senhaTextField;
    private JTextField telefoneTextField;

    public EdicaoClienteView(Autenticacao autenticacao, JFrame frame, Cliente cliente) {
        this.autenticacao = autenticacao;
        this.cliente = cliente;
        this.frame = frame;

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel senhaLabel = new JLabel("Senha:");
        JLabel telefoneLabel = new JLabel("Telefone:");

        nomeTextField = new JTextField(cliente.getNome());
        emailTextField = new JTextField(cliente.getEmail());
        senhaTextField = new JTextField(cliente.getSenha());
        telefoneTextField = new JTextField(cliente.getTelefone());

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
                voltarParaClienteLogado();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarParaClienteLogado();
            }
        });
    }

    private void salvarDadosEditados() {
        String nome = nomeTextField.getText();
        String email = emailTextField.getText();
        String senha = senhaTextField.getText();
        String telefone = telefoneTextField.getText();

        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setTelefone(telefone);

        autenticacao.atualizarCliente(cliente);
    }

    private void voltarParaClienteLogado() {
        frame.setContentPane(new ClienteLogadoView(autenticacao, frame, cliente.getEmail()).getPanel());
        frame.revalidate();
        frame.repaint();
    }

    public JPanel getPanel() {
        return panel;
    }
}
