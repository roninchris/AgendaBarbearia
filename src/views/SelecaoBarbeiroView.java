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

        constraints.gridy = 2;
        JLabel agendamentosLabel = new JLabel("Agendamentos:");
        panel.add(agendamentosLabel, constraints);

        constraints.gridy = 3;
        agendamentosArea = new JTextArea();
        agendamentosArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(agendamentosArea);
        panel.add(scrollPane, constraints);

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

    private List<String> getClientesCadastrados() {
        // Use aqui para obter os nomes dos clientes
        List<String>clientes = new ArrayList<>();
        // Exemplo de adição de nomes de barbeiros:
        clientes.add("pedrin cabelo de foice");
        return clientes;
    }

    private List<String> getAgendamentosBarbeiro(String barbeiro) {
        //puxe os agendamentos aqui
        List<String> agendamentos = new ArrayList<>();
        // Exemplo de agendamentos:
        agendamentos.add("Cliente 1 - Horário: 2023-06-12T10:00");
        return agendamentos;
    }

    private void atualizarAgendamentos(List<String> agendamentos) {
        agendamentosArea.setText("");
        for (String agendamento : agendamentos) {
            agendamentosArea.append(agendamento + "\n");
        }
    }
}
