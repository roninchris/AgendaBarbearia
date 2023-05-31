package views;

import controllers.Autenticacao;
import models.Barbeiro;
import models.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelecaoUsuarioView {
    private JPanel panel;
    private Autenticacao autenticacao;
    private JFrame frame;

    public SelecaoUsuarioView(Autenticacao autenticacao, JFrame frame) {
        this.autenticacao = autenticacao;
        this.frame = frame;

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton editarClienteButton = new JButton("Editar Cliente");
        JButton editarBarbeiroButton = new JButton("Editar Barbeiro");
        JButton voltarButton = new JButton("Voltar");

        editarClienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Cliente> clientes = autenticacao.getClientes();

                if (clientes.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Não há clientes cadastrados!");
                } else {
                    Cliente[] clientesArray = clientes.toArray(new Cliente[clientes.size()]);
                    Cliente selectedCliente = (Cliente) JOptionPane.showInputDialog(frame, "Selecione um cliente:",
                            "Editar Cliente", JOptionPane.PLAIN_MESSAGE, null, clientesArray, null);

                    if (selectedCliente != null) {
                        frame.setContentPane(new EdicaoClienteView(autenticacao, selectedCliente, frame).getPanel());
                        frame.revalidate();
                        frame.repaint();
                    }
                }
            }
        });

        editarBarbeiroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Barbeiro> barbeiros = autenticacao.getBarbeiros();

                if (barbeiros.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Não há barbeiros cadastrados!");
                } else {
                    Barbeiro[] barbeirosArray = barbeiros.toArray(new Barbeiro[barbeiros.size()]);
                    Barbeiro selectedBarbeiro = (Barbeiro) JOptionPane.showInputDialog(frame, "Selecione um barbeiro:",
                            "Editar Barbeiro", JOptionPane.PLAIN_MESSAGE, null, barbeirosArray, null);

                    if (selectedBarbeiro != null) {
                        frame.setContentPane(new EdicaoBarbeiroView(autenticacao, selectedBarbeiro, frame).getPanel());
                        frame.revalidate();
                        frame.repaint();
                    }
                }
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new App(autenticacao, frame).getMenuPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        panel.add(editarClienteButton);
        panel.add(editarBarbeiroButton);
        panel.add(voltarButton);
    }

    public JPanel getPanel() {
        return panel;
    }
}
