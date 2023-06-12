package views;

import controllers.Autenticacao;
import models.Barbeiro;
import models.Cliente;
import models.Horario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BarbeiroVisualizarHorariosView {
    private Autenticacao autenticacao;
    private JFrame frame;
    private JPanel panel;
    private Barbeiro barbeiro;
    private ArrayList<Horario> horarios;

    public BarbeiroVisualizarHorariosView(Autenticacao autenticacao, JFrame frame, Barbeiro barbeiro) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        this.autenticacao = autenticacao;
        this.frame = frame;
        this.barbeiro = barbeiro;

        panel = new JPanel();

        panel.setLayout(new GridLayout(12, 2));


        horarios = barbeiro.getAgenda().getAgendamentos();

        for(Horario horario : horarios){
            JLabel nomeCliente = new JLabel(horario.getCliente(horario).getNome());
            JLabel horarioLabel = new JLabel(horario.getDataHora().format(formatter));
            panel.add(nomeCliente);
            panel.add(horarioLabel);
        }

        JButton voltar = new JButton("Voltar");

        panel.add(voltar);

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new BarbeiroLogadoView(autenticacao, frame, barbeiro.getEmail()).getPanel());
                frame.revalidate();
                frame.repaint();

            }
        });

    }

    public JPanel getPanel() {
        return panel;
    }
}
