import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;


public class MoodPanel extends JPanel {

    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");

    List<MoodRecord> records = new ArrayList<>();

    ChartMaker chartMaker;

    public MoodPanel(ChartPanel chartPanel){
        set(chartPanel);
    }

    private void set(ChartPanel chartPanel){
        chartMaker = chartPanel.getChartMaker();

        //setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setLayout(new GridLayout(1,5, 5, 5));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        add(button0);
        add(button1);
        add(button2);
        add(button3);
        add(button4);

        button0.addActionListener(l -> { addRecord(0); });
        button1.addActionListener(l -> { addRecord(1); });
        button2.addActionListener(l -> { addRecord(2); });
        button3.addActionListener(l -> { addRecord(3); });
        button4.addActionListener(l -> { addRecord(4); });
    }

    public void addRecord(int value){
        records.add(new MoodRecord(value, 1));
        chartMaker.addPoint(new Point(records.size() -1, value + 2));
    }
}
