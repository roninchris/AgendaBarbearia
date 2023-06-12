package views;

import controllers.Autenticacao;
import models.Cliente;
import models.Horario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClienteVisualizarHorariosView {
    private Autenticacao autenticacao;
    private JFrame frame;
    private JPanel panel;
    private Cliente cliente;
    private ArrayList<Horario> horarios;

    public ClienteVisualizarHorariosView(Autenticacao autenticacao, JFrame frame, Cliente cliente) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        this.autenticacao = autenticacao;
        this.frame = frame;
        this.cliente = cliente;

        panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2));


        horarios = cliente.getAgendamentos();

        for(Horario horario : horarios){
            JLabel nomeBarbeiro = new JLabel(horario.getBarbeiro().getNome());
            JLabel horarioLabel = new JLabel(horario.getDataHora().format(formatter));
            panel.add(nomeBarbeiro);
            panel.add(horarioLabel);
        }

        JButton voltar = new JButton("Voltar");

        panel.add(voltar);

        voltar.addActionListener(new ActionListener() {
            @Override
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
