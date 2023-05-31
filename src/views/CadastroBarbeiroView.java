package views;

import controllers.Autenticacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroBarbeiroView {
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
    private JPanel cadastroBarbeiroPanel;

    private Autenticacao autenticacao;
    private JPanel previousPanel; // Referência ao painel anterior

    public CadastroBarbeiroView(Autenticacao autenticacao, JPanel previousPanel) {
        this.autenticacao = autenticacao;
        this.previousPanel = previousPanel;

        cadastroBarbeiroPanel = new JPanel();
        cadastroBarbeiroPanel.setLayout(new GridLayout(6, 2));

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

        cadastroBarbeiroPanel.add(nomeLabel);
        cadastroBarbeiroPanel.add(nomeInput);
        cadastroBarbeiroPanel.add(emailLabel);
        cadastroBarbeiroPanel.add(emailInput);
        cadastroBarbeiroPanel.add(passwordLabel);
        cadastroBarbeiroPanel.add(passwordInput);
        cadastroBarbeiroPanel.add(telefoneLabel);
        cadastroBarbeiroPanel.add(telefoneInput);
        cadastroBarbeiroPanel.add(cadastrarButton);
        cadastroBarbeiroPanel.add(cancelarButton);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeInput.getText();
                String email = emailInput.getText();
                String senha = new String(passwordInput.getPassword());
                String telefone = telefoneInput.getText();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || telefone.isEmpty()) {
                    JOptionPane.showMessageDialog(cadastroBarbeiroPanel, "Por favor, preencha todos os campos.");
                } else {
                    autenticacao.cadastrarBarbeiro(nome, email, senha, telefone);
                    JOptionPane.showMessageDialog(cadastroBarbeiroPanel, "Barbeiro cadastrado com sucesso!");
                    limparCampos();
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaAnterior();
            }
        });
    }

    private void limparCampos() {
        nomeInput.setText("");
        emailInput.setText("");
        passwordInput.setText("");
        telefoneInput.setText("");
    }

    private void voltarTelaAnterior() {
        if (previousPanel != null) {
            App app = (App) SwingUtilities.getWindowAncestor(cadastroBarbeiroPanel);
            app.setPanel(previousPanel);
        }
    }

    public JPanel getPanel() {
        return cadastroBarbeiroPanel;
    }
}
