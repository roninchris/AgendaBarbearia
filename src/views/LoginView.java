package views;

import controllers.Autenticacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView {
    private JPanel panel;
    private Autenticacao autenticacao;
    private JFrame frame;

    public LoginView(Autenticacao autenticacao, JFrame frame){
        this.autenticacao = autenticacao;
        this.frame = frame;

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel emailLabel = new JLabel("Email: ");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha: ");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Entrar");
        JButton cancelButton = new JButton("Cancelar");

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(cancelButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(autenticacao.verificarLogin(emailField.getText(), new String(passwordField.getPassword()))){
                    JOptionPane.showMessageDialog(panel, "Login realizado com sucesso!");

                }
                else {
                    JOptionPane.showMessageDialog(panel, "Email ou senha incorretos!");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new App(autenticacao, frame).getMenuPanel());
                frame.revalidate();
                frame.repaint();
            }
        });


    }

    public JPanel getPanel(){
        return panel;
    }
}
