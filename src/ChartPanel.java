import java.awt.Component;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ChartPanel extends JPanel {
    private ChartMaker chartMaker;


    public ChartPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        chartMaker = new ChartMaker(new Point(25, 225), 200, 200);

        add(chartMaker);
    }

    public ChartMaker getChartMaker(){
        return chartMaker;
    }
}
