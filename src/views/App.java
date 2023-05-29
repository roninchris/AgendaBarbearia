package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{
    private JButton cadastrarClienteButton;
    private JButton loginButton;
    private JButton cadastrarBarbeiroButton;
    private JPanel MenuPrincipal;
    private JPanel currentPanel;

    public App (){
        setContentPane(MenuPrincipal);
        setTitle("Barbearia aplicativo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 720);
        setLocationRelativeTo(null);
        setVisible(true);

        currentPanel = new JPanel();


        // Ação do botão Cadastrar Barbeiro
        cadastrarBarbeiroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroBarbeiroView cadastroBarbeiroView = new CadastroBarbeiroView();
                setPanel(cadastroBarbeiroView.getPanel());
            }
        });


        // Ação do botão Cadastrar Cliente
        cadastrarClienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadastroClienteView cadastroClienteView = new CadastroClienteView();
                setPanel(cadastroClienteView.getPanel());
            }
        });

    }

    private void setPanel(JPanel panel){
        if (currentPanel != null) {
            getContentPane().remove(currentPanel);
        }

        currentPanel = panel;
        getContentPane().add(currentPanel);
        getContentPane().revalidate();
        getContentPane().repaint();
    }


    public static void main(String[] args) {
        new App();
    }
}
