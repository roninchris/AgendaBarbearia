package views;

import controllers.Autenticacao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoBarbeiroView {
    private JPanel panel;
    private JComboBox<String> barbeiroDropdown;
    private JTextArea agendamentosArea;
    private JFrame frame;

    public AgendamentoBarbeiroView(Autenticacao autenticacao, JFrame frame) {
        this.frame = frame;

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel barbeiroLabel = new JLabel("Barbeiro:");
        panel.add(barbeiroLabel, constraints);

        constraints.gridy = 1;
        barbeiroDropdown = new JComboBox<>();

        // Add os nomes dos barbeiros cadastrados ao dropdown
        List<String> clientes = getClientesCadastrados();
        for (String cliente : clientes) {
            barbeiroDropdown.addItem(cliente);
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
        JButton atualizarButton = new JButton("Atualizar");
        panel.add(atualizarButton, constraints);

        constraints.gridy = 5;
        JButton voltarButton = new JButton("Voltar");
        panel.add(voltarButton, constraints);

        atualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String barbeiroSelecionado = (String) barbeiroDropdown.getSelectedItem();
                List<String> agendamentos = getAgendamentosBarbeiro(barbeiroSelecionado);
                atualizarAgendamentos(agendamentos);
            }
        });

        //cria o botao de voltar
//        JButton voltarButton = new JButton("Voltar");
//        constraints.gridy = 6;
//        panel.add(voltarButton, constraints);
//        voltarButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                frame.setContentPane(new SelecaoUsuarioView(frame).getPanel());
//                frame.revalidate();
//                frame.repaint();
//            }
//        });

        //cria o botao de logout

//        JButton logoutButton = new JButton("Logout");
//        constraints.gridy = 6;
//        panel.add(logoutButton, constraints);
//
//        logoutButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                autenticacao.logout();
//                frame.setContentPane(new App(autenticacao, frame).getMenuPanel());
//                frame.revalidate();
//                frame.repaint();
//            }
//        });
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
