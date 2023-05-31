package views;

import controllers.Autenticacao;
import models.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EdicaoClienteView {
    private JPanel panel;
    private Autenticacao autenticacao;
    private Cliente cliente;
    private JFrame frame;

    public EdicaoClienteView(Autenticacao autenticacao, Cliente cliente, JFrame frame) {
        this.autenticacao = autenticacao;
        this.cliente = cliente;
        this.frame = frame;

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField(cliente.getNome());

        JLabel emailLabel = new JLabel("E-mail:");
        JTextField emailField = new JTextField(cliente.getEmail());

        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField(cliente.getSenha());

        JLabel telefoneLabel = new JLabel("Telefone:");
        JTextField telefoneField = new JTextField(cliente.getTelefone());

        JButton salvarButton = new JButton("Salvar");
        JButton cancelarButton = new JButton("Cancelar");

        salvarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nameField.getText();
                String email = emailField.getText();
                String senha = new String(passwordField.getPassword());
                String telefone = telefoneField.getText();

                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setSenha(senha);
                cliente.setTelefone(telefone);

                JOptionPane.showMessageDialog(panel, "Dados do cliente atualizados com sucesso!");

                frame.setContentPane(new App(autenticacao, frame).getMenuPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new App(autenticacao, frame).getMenuPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(telefoneLabel);
        panel.add(telefoneField);
        panel.add(salvarButton);
        panel.add(cancelarButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
