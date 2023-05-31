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
        menuPanel.setLayout(new GridLayout(4, 1));

        JButton loginButton = new JButton("Login");
        JButton cadastrarBarbeiroButton = new JButton("Cadastrar Barbeiro");
        JButton cadastrarClienteButton = new JButton("Cadastrar Cliente");
        JButton editarDadosButton = new JButton("Editar Dados");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implemente a lógica de login
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

        editarDadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Cliente> clientes = autenticacao.getClientes();
                ArrayList<Barbeiro> barbeiros = autenticacao.getBarbeiros();

                Cliente[] clientesArray = clientes.toArray(new Cliente[clientes.size()]);
                Barbeiro[] barbeirosArray = barbeiros.toArray(new Barbeiro[barbeiros.size()]);

                JComboBox<Cliente> clientesComboBox = new JComboBox<>(clientesArray);
                JComboBox<Barbeiro> barbeirosComboBox = new JComboBox<>(barbeirosArray);

                JPanel selectPanel = new JPanel();
                selectPanel.add(new JLabel("Selecione um cliente ou barbeiro: "));
                selectPanel.add(clientesComboBox);
                selectPanel.add(barbeirosComboBox);

                int result = JOptionPane.showConfirmDialog(App.this.frame, selectPanel, "Editar Dados",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    if (clientesComboBox.getSelectedItem() != null) {
                        Cliente selectedCliente = (Cliente) clientesComboBox.getSelectedItem();
                        frame.setContentPane(new EdicaoClienteView(autenticacao, selectedCliente, frame).getPanel());
                        frame.revalidate();
                    } else if (barbeirosComboBox.getSelectedItem() != null) {
                        Barbeiro selectedBarbeiro = (Barbeiro) barbeirosComboBox.getSelectedItem();
                        frame.setContentPane(new EdicaoBarbeiroView(autenticacao, selectedBarbeiro, frame).getPanel());
                        frame.revalidate();
                    }
                }
            }
        });

        menuPanel.add(loginButton);
        menuPanel.add(cadastrarBarbeiroButton);
        menuPanel.add(cadastrarClienteButton);
        menuPanel.add(editarDadosButton);

        frame.setContentPane(menuPanel);
        frame.revalidate();
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public static void main(String[] args) {
        Autenticacao autenticacao = new Autenticacao();

        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new App(autenticacao, frame);

    }
}
