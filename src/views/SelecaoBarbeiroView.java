package views;

import controllers.Autenticacao;
import models.Barbeiro;
import models.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelecaoBarbeiroView {
    private JFrame frame;
    private JPanel panel;
    private JComboBox<String> barbeiroDropdown;
    private JTextArea agendamentosArea;
    private ArrayList<Barbeiro> barbeiros;

    public SelecaoBarbeiroView(Autenticacao autenticacao, JFrame frame, Cliente cliente) {
        this.frame = frame;
        this.barbeiros = autenticacao.getBarbeiros();

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel barbeiroLabel = new JLabel("Selecione seu barbeiro:");
        panel.add(barbeiroLabel, constraints);

        constraints.gridy = 1;
        barbeiroDropdown = new JComboBox<>();

        // Add os nomes dos barbeiros cadastrados ao dropdown
        for(Barbeiro barbeiro : barbeiros){
            barbeiroDropdown.addItem(barbeiro.getEmail());
        }

        panel.add(barbeiroDropdown, constraints);

        constraints.gridy = 4;
        JButton selecionarButton = new JButton("Selecionar");
        panel.add(selecionarButton, constraints);

        constraints.gridy = 5;
        JButton voltarButton = new JButton("Voltar");
        panel.add(voltarButton, constraints);

        selecionarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String barbeiroSelecionado = (String) barbeiroDropdown.getSelectedItem();
                Barbeiro barbeiro = autenticacao.getBarbeiro(autenticacao, barbeiroSelecionado);

                frame.setContentPane(new SelecaoHorarioView(autenticacao, frame, barbeiro, cliente).getPanel());
                frame.revalidate();
                frame.repaint();

            }
        });

        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new ClienteLogadoView(autenticacao, frame, cliente.getEmail()).getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });


    }

    public JPanel getPanel() {
        return panel;
    }



}
