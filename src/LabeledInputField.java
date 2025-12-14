import javax.swing.*;
import java.awt.*;


public class LabeledInputField extends JPanel{
    
    private JLabel label;
    private JTextField textField;

    public LabeledInputField(String text, int lenght){
        setLayout(new BorderLayout());

        label = new JLabel(text);
        textField = new JTextField(lenght);

        add(label, BorderLayout.WEST);
        add(textField, BorderLayout.EAST);
    }

    public String getText(){
        return textField.getText();
    }
}
