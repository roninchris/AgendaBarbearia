package views;

import controllers.Autenticacao;
import models.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CadastroClienteView {
    private JPanel panel;
    private Autenticacao autenticacao;
    private JFrame frame;

    public CadastroClienteView(Autenticacao autenticacao, JFrame frame) {
        this.autenticacao = autenticacao;
        this.frame = frame;

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField();

        JLabel emailLabel = new JLabel("E-mail:");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Senha:");
        JPasswordField passwordField = new JPasswordField();

        JLabel telefoneLabel = new JLabel("Telefone:");
        JTextField telefoneField = new JTextField();

        JButton cadastrarButton = new JButton("Cadastrar");
        JButton cancelarButton = new JButton("Cancelar");


        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nameField.getText();
                String email = emailField.getText();
                String senha = new String(passwordField.getPassword());
                String telefone = telefoneField.getText();

                try {
                    // Verificação do e-mail
                    if (!isValidEmail(email)) {
                        throw new EmailInvalidoException("E-mail inválido");
                    }

                    if (autenticacao.cadastrarCliente(nome, email, senha, telefone)) {
                        JOptionPane.showMessageDialog(panel, "Cliente cadastrado com sucesso!");
                        frame.setContentPane(new App(autenticacao, frame).getMenuPanel());
                        frame.revalidate();
                        frame.repaint();
                    } else {
                        JOptionPane.showMessageDialog(panel, "Email já utilizado, tente com outro email!");
                    }
                } catch (EmailInvalidoException ex) {
                    JOptionPane.showMessageDialog(panel, ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Ocorreu um erro ao cadastrar o cliente: " + ex.getMessage());
                }
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
        panel.add(cadastrarButton);
        panel.add(cancelarButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    private boolean isValidEmail(String email) {
        // validando o e-mail
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        //retorna true se o email for valido e false se for invalido.
    }

    private class EmailInvalidoException extends Exception {
        public EmailInvalidoException(String mensagem) {
            super(mensagem);
        }
    }

}
