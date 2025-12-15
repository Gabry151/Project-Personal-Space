import javax.swing.*;
import java.awt.*;


public class LabeledInputField extends JPanel{
    
    private JLabel label;
    private JTextField textField;

    private static int maxLabelWidth = 0;

    public LabeledInputField(String text, int length){
        SetBox(text, length);
    }

    private void SetGrid(String text, int length){
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridy = 0;

        label = new JLabel(text);
        gbc.gridx = 0;
        add(label, gbc);

        textField = new JTextField(length);
        gbc.gridx = 1;
        add(textField, gbc);
    }

    private void SetSpring(String text, int length){
        SpringLayout layout = new SpringLayout();

        setLayout(layout);
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        label = new JLabel(text);
        textField = new JTextField(length);

        add(label);
        add(textField);

        layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, label, 5, SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.WEST, textField, 5, SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, textField, 5, SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.EAST, this, 5, SpringLayout.EAST, textField);

        layout.putConstraint(
                SpringLayout.SOUTH, this,
                5, SpringLayout.SOUTH, textField);
    }

    private void SetBox(String text, int length){
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        label = new JLabel(text);
        textField = new JTextField(length);

        Dimension d = label.getPreferredSize();
        maxLabelWidth = Math.max(maxLabelWidth, d.width);
        label.setPreferredSize(new Dimension(maxLabelWidth, d.height));

        add(label);
        add(Box.createHorizontalStrut(5));
        add(textField);
    }

    public String getText(){
        return textField.getText();
    }
}
