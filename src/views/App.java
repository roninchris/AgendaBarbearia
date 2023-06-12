package views;

import controllers.Autenticacao;
import models.Barbeiro;
import models.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App {
    private JFrame frame;
    private JPanel menuPanel;
    private Autenticacao autenticacao;

    public App(Autenticacao autenticacao, JFrame frame) {
        this.autenticacao = autenticacao;
        this.frame = frame;
        initializeMenuPanel();
    }

    private void initializeMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3, 1));

        JButton loginButton = new JButton("Login");
        JButton cadastrarBarbeiroButton = new JButton("Cadastrar Barbeiro");
        JButton cadastrarClienteButton = new JButton("Cadastrar Cliente");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new LoginView(autenticacao, frame).getPanel());
                frame.revalidate();
            }
        });

        cadastrarBarbeiroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new CadastroBarbeiroView(autenticacao, frame).getPanel());
                frame.revalidate();
            }
        });

        cadastrarClienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new CadastroClienteView(autenticacao, frame).getPanel());
                frame.revalidate();
            }
        });

        menuPanel.add(loginButton);
        menuPanel.add(cadastrarBarbeiroButton);
        menuPanel.add(cadastrarClienteButton);
        frame.setContentPane(menuPanel);
        frame.revalidate();
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public static void main(String[] args) {
        Autenticacao autenticacao = new Autenticacao();

        JFrame frame = new JFrame("Agenda Barbearia");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new App(autenticacao, frame);

    }
}
