import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        //crea la finestra e imposta tutto
        JFrame frame = new JFrame("Personal Space");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        
        Gui gui = new Gui();

        ArrayList<JPanel> panels = new ArrayList<JPanel>();

        panels.add(new LabeledPanel("Chart", LabeledPanel.layoutType.flow, new JComponent[] { gui.chartPanel() }));
        panels.add(new LabeledPanel("Data", LabeledPanel.layoutType.flow, new JComponent[] { new DataPanel() }));

        for (int i = 0; i < panels.size(); i++){
            frame.add(panels.get(i));
        }

        frame.setVisible(true);
    }
}
