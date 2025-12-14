import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) throws Exception {

        //crea la finestra e imposta tutto
        JFrame frame = new JFrame("Personal Space");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel dataPanel = new JPanel(new FlowLayout());
        dataPanel.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1), "Insert data"
            )
        );
        
        JTextField textField = new JTextField(20);
        
        JLabel label = new JLabel();
        label.setText("Name");

        JLabel outputLabel = new JLabel();
        outputLabel.setText("TEST");

        JButton button = new JButton("Save");
        button.addActionListener(l -> {
            outputLabel.setText(textField.getText());
        });

        dataPanel.add(label);
        dataPanel.add(textField);
        dataPanel.add(button);

        mainPanel.add(dataPanel, BorderLayout.NORTH);
        mainPanel.add(outputLabel, BorderLayout.CENTER);

        frame.add(mainPanel, BorderLayout.NORTH);

        //mostra la finestra
        frame.setVisible(true);
    }
}
