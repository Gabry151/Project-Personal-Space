import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        //crea la finestra e imposta tutto
        JFrame frame = new JFrame("Personal Space");
        frame.setSize(500, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        
        ChartPanel chartPanel = new ChartPanel();
        MoodPanel moodPanel = new MoodPanel(chartPanel);

        List<JPanel> panels = new ArrayList<JPanel>();

        panels.add(new LabeledPanel("Chart", LabeledPanel.layoutType.flow, new JComponent[] { chartPanel }));
        panels.add(new LabeledPanel("Data", LabeledPanel.layoutType.flow, new JComponent[] { new DataPanel() }));
        panels.add(new LabeledPanel("Mood", LabeledPanel.layoutType.flow, new JComponent[] { moodPanel }));

        for (int i = 0; i < panels.size(); i++){
            frame.add(panels.get(i));
        }

        frame.setVisible(true);
    }
}
