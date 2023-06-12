package views;

import controllers.Autenticacao;
import models.Cliente;
import models.Horario;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClienteVisualizarHorariosView {
    private Autenticacao autenticacao;
    private JFrame frame;
    private JPanel panel;
    private Cliente cliente;
    private ArrayList<Horario> horarios;

    public ClienteVisualizarHorariosView(Autenticacao autenticacao, JFrame frame, String email) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        this.autenticacao = autenticacao;
        this.frame = frame;

        panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2));

        cliente = autenticacao.getCliente(autenticacao, email);
        horarios = cliente.getHorarios();

        for(Horario horario : horarios){
            JLabel nomeBarbeiro = new JLabel(horario.getBarbeiro().getNome());
            JLabel horarioLabel = new JLabel(horario.getDataHora().format(formatter));
            panel.add(nomeBarbeiro);
            panel.add(horarioLabel);
        }

    }

    public JPanel getPanel() {
        return panel;
    }
}
