import javax.swing.*;
import java.awt.*;


public class Gui {

    public JPanel chartPanel(){
        ChartMaker chartMaker = new ChartMaker(new Point(25, 225), 200, 200);
        chartMaker.addPoint(new Point(0, 0));
        chartMaker.addPoint(new Point(3, 4));
        chartMaker.addPoint(new Point(5, 7));
        chartMaker.addPoint(new Point(10, 3));
        chartMaker.addPoint(new Point(10, 10));
        return chartMaker;
    }
}
