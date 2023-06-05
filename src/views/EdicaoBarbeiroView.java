package views;

import controllers.Autenticacao;
import models.Barbeiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EdicaoBarbeiroView {
    private JPanel panel;
    private Autenticacao autenticacao;
    private Barbeiro barbeiro;
    private JFrame frame;

    public EdicaoBarbeiroView(Autenticacao autenticacao, Barbeiro barbeiro, JFrame frame) {
        this.autenticacao = autenticacao;
        this.barbeiro = barbeiro;
        this.frame = frame;

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField(barbeiro.getNome());

        JLabel emailLabel = new JLabel("E-mail:");
        JTextField emailField = new JTextField(barbeiro.getEmail());

        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField(barbeiro.getSenha());

        JLabel telefoneLabel = new JLabel("Telefone:");
        JTextField telefoneField = new JTextField(barbeiro.getTelefone());

        JButton salvarButton = new JButton("Salvar");
        JButton cancelarButton = new JButton("Cancelar");

        salvarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nameField.getText();
                String email = emailField.getText();
                String senha = new String(passwordField.getPassword());
                String telefone = telefoneField.getText();

                barbeiro.setNome(nome);
                barbeiro.setEmail(email);
                barbeiro.setSenha(senha);
                barbeiro.setTelefone(telefone);

                JOptionPane.showMessageDialog(panel, "Dados do barbeiro atualizados com sucesso!");

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
