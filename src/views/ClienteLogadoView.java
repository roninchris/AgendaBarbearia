package views;

import controllers.Autenticacao;
import models.Cliente;
import models.Pessoa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteLogadoView {
    private Autenticacao autenticacao;
    private JFrame frame;
    private JPanel panel;
    private Cliente cliente;

    public ClienteLogadoView(Autenticacao autenticacao, JFrame frame, String email) {
        this.autenticacao = autenticacao;
        this.frame = frame;
        this.cliente = autenticacao.getCliente(autenticacao, email);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton agendarHorario = new JButton("Agendar Horário");
        JButton visualizarHorarios = new JButton("Visualizar horários");
        JButton editarDados = new JButton("Editar dados");
        JButton logout = new JButton("LogOut");

        panel.add(agendarHorario);
        panel.add(visualizarHorarios);
        panel.add(editarDados);
        panel.add(logout);

        agendarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new SelecaoBarbeiroView(autenticacao, frame, cliente).getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        visualizarHorarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new ClienteVisualizarHorariosView(autenticacao, frame, cliente).getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        editarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new EdicaoClienteView(autenticacao, frame, cliente).getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel, "LogOut feito com sucesso!");
                frame.setContentPane(new App(autenticacao, frame).getMenuPanel());
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    private Cliente getClienteLogado() {
        for (Pessoa pessoa : autenticacao.getClientes()) {
            if (pessoa.getEmail().equals(autenticacao.getEmailUsuarioLogado())) {
                return (Cliente) pessoa;
            }
        }
        return null;
    }

    public JPanel getPanel() {
        return panel;
    }
}
