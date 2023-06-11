package views;

import controllers.Autenticacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteLogadoView {
    private Autenticacao autenticacao;
    private JFrame frame;
    private JPanel panel;

    public ClienteLogadoView(Autenticacao autenticacao, JFrame frame) {
        this.autenticacao = autenticacao;
        this.frame = frame;

        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton agendarHorario = new JButton("Agendar Horário");
        JButton editarDados = new JButton("Editar dados");

        panel.add(agendarHorario);
        panel.add(editarDados);

        agendarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Vai para tela de agendamento de horários
            }
        });

        editarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Vai para a tela de agendamento de horários
            }
        });

    }

    public JPanel getPanel() {
        return panel;
    }
}
