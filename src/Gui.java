import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Gui {
    public JPanel mainMenu(){
        //dati input field
        LabeledInputField lif_name = new LabeledInputField("Name", 20);
        LabeledInputField lif_age = new LabeledInputField("Birthday", 20);

        //output text
        JLabel outputLabel = new JLabel("WAITING");
        outputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //save button
        JButton button = new JButton("Save");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(l -> {
            outputLabel.setText(lif_name.getText() + ", " + lif_age.getText());
        });

        //panel dei dati
        JPanel dataPanel = labeledPanel("Insert data", new Component[] {
                lif_name,
                lif_age,
        });

        //panel principale
        JPanel mainPanel = verticalPanel(new Component[] {
                dataPanel,
                button,
                outputLabel,
        });

        return mainPanel;
    }



    private JPanel verticalPanel(Component[] components){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Component component : components) {
            panel.add(component);
        }

        return panel;
    }

    private JPanel labeledPanel(String text, Component[] components){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.BLACK, 1), text));

        for (Component component : components) {
            panel.add(component);
        }

        return panel;
    }
}
