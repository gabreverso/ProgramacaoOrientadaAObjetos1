import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class Formulario{
    private JTextField campoNome;
    private JFormattedTextField campoCPF;
    private JFormattedTextField campoTelefone;
    private JFormattedTextField campoDataNascimento;
    private JTextArea areaResultado;

    public Formulario() {
        JFrame frame = new JFrame("Formulário de Contato");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(6, 2));

        JLabel rotuloNome = new JLabel("Nome:");
        campoNome = new JTextField();

        JLabel rotuloCPF = new JLabel("CPF:");
        campoCPF = criarCampoMascarado("###.###.###-##");

        JLabel rotuloTelefone = new JLabel("Celular:");
        campoTelefone = criarCampoMascarado("(##) #####-####");

        JLabel rotuloNascimento = new JLabel("Data de Nascimento:");
        campoDataNascimento = criarCampoMascarado("##/##/####");

        JButton botaoEnviar = new JButton("Enviar");

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        painel.add(rotuloNome);
        painel.add(campoNome);
        painel.add(rotuloCPF);
        painel.add(campoCPF);
        painel.add(rotuloTelefone);
        painel.add(campoTelefone);
        painel.add(rotuloNascimento);
        painel.add(campoDataNascimento);
        painel.add(new JLabel()); 
        painel.add(botaoEnviar);

        frame.add(painel, BorderLayout.CENTER);
        frame.add(areaResultado, BorderLayout.SOUTH);

        botaoEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostraEnvio();
            }
        });

        frame.setVisible(true);
    }

    private JFormattedTextField criarCampoMascarado(String mascara) {
        try {
            MaskFormatter formatador = new MaskFormatter(mascara);
            return new JFormattedTextField(formatador);
        } catch (ParseException e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    private void mostraEnvio() {
        String nome = campoNome.getText();
        String cpf = campoCPF.getText();
        String telefone = campoTelefone.getText();
        String dataNascimento = campoDataNascimento.getText();

        String resultado = "Nome: " + nome + "\nCPF: " + cpf + "\nCelular: " + telefone + "\nData de Nascimento: " + dataNascimento;


        areaResultado.setText(resultado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Formulario();
            }
        });
    }
}
