package views;

import controllers.Autenticacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        menuPanel.setLayout(new GridLayout(4, 1));

        JButton loginButton = new JButton("Login");
        JButton cadastrarBarbeiroButton = new JButton("Cadastrar Barbeiro");
        JButton cadastrarClienteButton = new JButton("Cadastrar Cliente");
        JButton cadastrarComTxtButton = new JButton("Cadastrar com TXT");

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

        cadastrarComTxtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new CadastroComTxtView(autenticacao, frame).getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        menuPanel.add(loginButton);
        menuPanel.add(cadastrarBarbeiroButton);
        menuPanel.add(cadastrarClienteButton);
        menuPanel.add(cadastrarComTxtButton);

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
