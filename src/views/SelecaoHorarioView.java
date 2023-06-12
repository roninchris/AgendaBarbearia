package views;

import controllers.Autenticacao;
import models.Barbeiro;
import models.Cliente;
import models.Horario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SelecaoHorarioView {
    private JPanel panel;
    private JFrame frame;
    private Autenticacao autenticacao;
    private JComboBox<String> selecaoHorario;

    public SelecaoHorarioView(Autenticacao autenticacao, JFrame frame, Barbeiro barbeiro, Cliente cliente) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        this.frame = frame;
        this.autenticacao = autenticacao;
        this.selecaoHorario = new JComboBox<>();

        panel  = new JPanel();

        ArrayList<Horario> horarios = barbeiro.getAgenda().getHorarios();

        for(Horario horario : horarios){
            if (horario.isDisponivel()){
                selecaoHorario.addItem(horario.getDataHora().format(formatter));
            }
        }

        JButton agendarHorario = new JButton("Agendar");

        panel.add(selecaoHorario);
        panel.add(agendarHorario);

        agendarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String horarioSelecionado = (String) selecaoHorario.getSelectedItem();

                // Atribui horário com o barbeiro
                barbeiro.getAgenda().agendarHorario(barbeiro.getAgenda().getHorario(horarioSelecionado));
                barbeiro.getAgenda().getHorario(horarioSelecionado).setDisponibilidade(false);



                // Atribui horário com o cliente
                cliente.addAgendamento(barbeiro.getAgenda().getHorario(horarioSelecionado));
                barbeiro.getAgenda().getHorario(horarioSelecionado).setCliente(cliente);

                //Mostra aviso na tela
                JOptionPane.showMessageDialog(panel, "Horário com " + barbeiro.getNome() + " agendado com sucesso!");

                //Redireciona o usuário para a tela do cliente novamente
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
