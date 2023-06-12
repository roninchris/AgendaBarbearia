package views;

import controllers.Autenticacao;
import models.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CadastroComTxtView {
    private JPanel panel;
    private Autenticacao autenticacao;
    private JFrame frame;

    public CadastroComTxtView(Autenticacao autenticacao, JFrame frame) {
        this.autenticacao = autenticacao;
        this.frame = frame;

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel fileLabel = new JLabel("Arquivo:");
        JTextField fileField = new JTextField();

        JButton buscarButton = new JButton("Buscar");
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton cancelarButton = new JButton("Cancelar");

        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(panel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String file = fileChooser.getSelectedFile().getAbsolutePath();
                    fileField.setText(file);
                }
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String file = fileField.getText();

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] data = line.split(",");
                        if (data.length == 4) {
                            String nome = data[0].trim();
                            String email = data[1].trim();
                            String senha = data[2].trim();
                            String telefone = data[3].trim();

                            // Verificação do e-mail
                            if (!isValidEmail(email)) {
                                JOptionPane.showMessageDialog(panel, "E-mail inválido para o cliente: " + nome);
                                continue;
                            }

                            if (autenticacao.cadastrarCliente(nome, email, senha, telefone)) {
                                JOptionPane.showMessageDialog(panel, "Cliente cadastrado com sucesso: " + nome);
                            } else {
                                JOptionPane.showMessageDialog(panel, "Email já utilizado para o cliente: " + nome);
                            }
                        } else {
                            JOptionPane.showMessageDialog(panel, "Dados inválidos no arquivo: " + file);
                        }
                    }
                    reader.close();

                    frame.setContentPane(new App(autenticacao, frame).getMenuPanel());
                    frame.revalidate();
                    frame.repaint();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(panel, "Erro ao ler o arquivo: " + file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Ocorreu um erro ao cadastrar os clientes: " + ex.getMessage());
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new App(autenticacao, frame).getMenuPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        panel.add(fileLabel);
        panel.add(fileField);
        panel.add(buscarButton);
        panel.add(new JLabel()); // Espaço vazio para layout
        panel.add(cadastrarButton);
        panel.add(cancelarButton);
    }

    public JPanel getPanel() {
        return panel;
    }

    private boolean isValidEmail(String email) {
        // validando o e-mail
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        // retorna true se o email for válido e false se for inválido.
    }
}
