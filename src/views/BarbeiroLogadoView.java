package views;

import controllers.Autenticacao;
import models.Barbeiro;
import models.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarbeiroLogadoView {
    private Autenticacao autenticacao;
    private JFrame frame;
    private JPanel panel;
    private Barbeiro barbeiro;

    public BarbeiroLogadoView(Autenticacao autenticacao, JFrame frame, String email) {
        this.autenticacao = autenticacao;
        this.frame = frame;
        this.barbeiro = autenticacao.getBarbeiro(autenticacao, email);

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
                frame.setContentPane(new EdicaoBarbeiroView(autenticacao, frame, barbeiro).getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

    }

    public JPanel getPanel() {
        return panel;
    }
}