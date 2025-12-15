import javax.swing.*;
import java.awt.*;

public class InputField extends JPanel {
    
    private JLabel label;
    private JTextField textField;

    public InputField(String text, int length){
        SetGrid(text, length);
    }

    private void SetGrid(String text, int length){
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridy = 0;
        
        label = new JLabel(text);
        gbc.gridx = 0;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(label, gbc);

        textField = new JTextField(length);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        add(textField, gbc);
    }
}
