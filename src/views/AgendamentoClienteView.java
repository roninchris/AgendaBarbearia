package views;

import controllers.Autenticacao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoClienteView {
    private JPanel panel;
    private JComboBox<String> barbeiroDropdown;
    private JComboBox<LocalDateTime> horariosDropdown;
    private JTextField observacaoField;
    private JFrame frame;

    public AgendamentoClienteView(Autenticacao autenticacao, JFrame frame) {
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
        List<String> barbeiros = getNomesBarbeirosCadastrados();
        for (String barbeiro : barbeiros) {
            barbeiroDropdown.addItem(barbeiro);
        }
        panel.add(barbeiroDropdown, constraints);

        constraints.gridy = 2;
        JLabel horarioLabel = new JLabel("Horário:");
        panel.add(horarioLabel, constraints);

        constraints.gridy = 3;
        horariosDropdown = new JComboBox<>();
        // Adicione os horários disponíveis para o barbeiro selecionado
        String barbeiroSelecionado = (String) barbeiroDropdown.getSelectedItem();
        List<LocalDateTime> horariosDisponiveis = getHorariosDisponiveis(barbeiroSelecionado);
        for (LocalDateTime horario : horariosDisponiveis) {
            horariosDropdown.addItem(horario);
        }
        panel.add(horariosDropdown, constraints);

        constraints.gridy = 4;
        JLabel observacaoLabel = new JLabel("Observação:");
        panel.add(observacaoLabel, constraints);

        constraints.gridy = 5;
        observacaoField = new JTextField();
        panel.add(observacaoField, constraints);

        constraints.gridy = 6;
        JButton agendarButton = new JButton("Agendar");
        panel.add(agendarButton, constraints);

        agendarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String barbeiroSelecionado = (String) barbeiroDropdown.getSelectedItem();
                LocalDateTime horarioSelecionado = (LocalDateTime) horariosDropdown.getSelectedItem();
                String observacao = observacaoField.getText();

                // Lógica para agendar o horário com os dados selecionados
                // ...

                JOptionPane.showMessageDialog(panel, "Horário agendado com sucesso!");
                observacaoField.setText("");
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
//        constraints.gridy = 4;
//        panel.add(logoutButton, constraints);
//
//        logoutButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Limpar os dados de autenticação, se necessário
//                // Exemplo: autenticacao.logout();
//                frame.setContentPane(new App(autenticacao, frame).getMenuPanel());
//                frame.revalidate();
//                frame.repaint();
//            }
//        });
    }

    public JPanel getPanel() {
        return panel;
    }

    private List<String> getNomesBarbeirosCadastrados() {
        // aqui puxe os barbeiros, Sid
        List<String> barbeiros = new ArrayList<>();
        // Exemplo de dados fictícios
        barbeiros.add("Barbeiro Jamal indiano");

        return barbeiros;
    }

    private List<LocalDateTime> getHorariosDisponiveis(String barbeiro) {
        // aqui puxe os horarios dos barbeiros, Sid
        List<LocalDateTime> horarios = new ArrayList<>();
        // Exemplo de dados fictícios
        LocalDateTime now = LocalDateTime.now();
        for (int i = 1; i <= 5; i++) {
            LocalDateTime horario = now.plusHours(i);
            horarios.add(horario);
        }
        return horarios;
    }
}