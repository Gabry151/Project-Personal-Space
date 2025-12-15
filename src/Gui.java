import javax.swing.*;
import java.awt.*;


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

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        

        JPanel moodPanel = labeledPanel("Mood", new Component[] {
            button1,
            button2,
            button3,
        });

        //panel principale
        JPanel mainPanel = verticalPanel(new Component[] {
                dataPanel,
                button,
                outputLabel,
                moodPanel,
        });

        return mainPanel;
    }

    public JPanel chartMenu(){
        ChartMaker chartMaker = new ChartMaker(new Point(100, 300), 200, 200);
        chartMaker.addPoint(new Point(0, 0));
        chartMaker.addPoint(new Point(3, 4));
        chartMaker.addPoint(new Point(5, 7));
        chartMaker.addPoint(new Point(10, 3));
        chartMaker.addPoint(new Point(10, 10));
        return chartMaker;
    }


    private JPanel verticalPanel(Component[] components){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (Component component : components) {
            panel.add(component);
        }

        return panel;
    }

    private JPanel horizontalPanel(Component[] components){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

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
