package views;

import controllers.Autenticacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroClienteView {
    private JLabel emailLabel;
    private JLabel nomeLabel;
    private JLabel passwordLabel;
    private JLabel telefoneLabel;
    private JTextField emailInput;
    private JTextField nomeInput;
    private JPasswordField passwordInput;
    private JTextField telefoneInput;
    private JButton cadastrarButton;
    private JButton cancelarButton;
    private JPanel cadastroClientePanel;

    private Autenticacao autenticacao;
    private JPanel previousPanel; // Referência para o painel anterior

    public CadastroClienteView(Autenticacao autenticacao, JPanel previousPanel) {
        this.autenticacao = autenticacao;
        this.previousPanel = previousPanel;

        cadastroClientePanel = new JPanel();
        cadastroClientePanel.setLayout(new GridLayout(6, 2));

        nomeLabel = new JLabel("Nome: ");
        emailLabel = new JLabel("Email: ");
        passwordLabel = new JLabel("Senha: ");
        telefoneLabel = new JLabel("Telefone: ");

        nomeInput = new JTextField();
        emailInput = new JTextField();
        passwordInput = new JPasswordField();
        telefoneInput = new JTextField();

        cadastrarButton = new JButton("Cadastrar");
        cancelarButton = new JButton("Cancelar");

        cadastroClientePanel.add(nomeLabel);
        cadastroClientePanel.add(nomeInput);
        cadastroClientePanel.add(emailLabel);
        cadastroClientePanel.add(emailInput);
        cadastroClientePanel.add(passwordLabel);
        cadastroClientePanel.add(passwordInput);
        cadastroClientePanel.add(telefoneLabel);
        cadastroClientePanel.add(telefoneInput);
        cadastroClientePanel.add(cadastrarButton);
        cadastroClientePanel.add(cancelarButton);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeInput.getText();
                String email = emailInput.getText();
                String senha = new String(passwordInput.getPassword());
                String telefone = telefoneInput.getText();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(cadastroClientePanel, "Por favor, preencha todos os campos.");
                } else {
                    autenticacao.cadastrarCliente(nome, email, senha, telefone);
                    JOptionPane.showMessageDialog(cadastroClientePanel, "Cliente cadastrado com sucesso!");
                    limparCampos();
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarAoMenuPrincipal();
            }
        });
    }

    private void limparCampos() {
        nomeInput.setText("");
        emailInput.setText("");
        passwordInput.setText("");
        telefoneInput.setText("");
    }

    private void voltarAoMenuPrincipal() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(cadastroClientePanel);
        frame.setContentPane(previousPanel);
        frame.revalidate();
        frame.repaint();
    }

    public JPanel getPanel() {
        return cadastroClientePanel;
    }
}
