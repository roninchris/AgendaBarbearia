package views;

import javax.swing.*;
import java.awt.*;

public class CadastroClienteView extends JPanel{
    private JTextField emailInput;
    private JTextField nomeInput;
    private JPasswordField passwordField1;
    private JTextField telefoneInput;
    private JButton cadastrarButton;
    private JButton cancelarButton;
    private JPanel cadastroClientePanel;

    public CadastroClienteView(){

    }

    public JPanel getPanel() {
        return cadastroClientePanel; // Retorna o painel atual (this é uma instância de JPanel)
    }
}


